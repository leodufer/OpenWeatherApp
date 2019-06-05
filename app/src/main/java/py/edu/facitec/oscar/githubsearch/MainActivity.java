package py.edu.facitec.oscar.githubsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Date;

import py.edu.facitec.oscar.githubsearch.modelo.Clima;
import py.edu.facitec.oscar.githubsearch.modelo.Weather;
import py.edu.facitec.oscar.githubsearch.servicio.ClimaServicio;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<Clima> {
    LinearLayout statusSuccess;
    LinearLayout statusError;
    TextView errorMessage;
    ProgressBar progressBar;
    ImageView iconImageView;
    TextView tempTextView;
    TextView titleTextView;
    TextView mainTextView;
    TextView windCloudines;
    TextView dataTextView;
    TextView windTextView;
    TextView pressureTextView;
    TextView humidityTextView;
    TextView sunriseTextView;
    TextView sunsetTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textViewMSJ = findViewById(R.id.resultMSJ);
        statusSuccess = findViewById(R.id.statusSucccess);
        statusError = findViewById(R.id.statusError);
        progressBar = findViewById(R.id.progressBar);
        errorMessage = findViewById(R.id.errorMessage);
        iconImageView = findViewById(R.id.iconImageView);
        tempTextView = findViewById(R.id.tempTextView);
        titleTextView = findViewById(R.id.titleTextView);
        mainTextView = findViewById(R.id.mainTextView);
        windCloudines = findViewById(R.id.windCloudines);
        dataTextView = findViewById(R.id.dataTextView);
        windTextView = findViewById(R.id.windTextView);
        pressureTextView = findViewById(R.id.pressureTextView);
        humidityTextView = findViewById(R.id.humidityTextView);
        sunriseTextView = findViewById(R.id.sunriseTextView);
        sunsetTextView = findViewById(R.id.sunsetTextView);
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://api.openweathermap.org/data/2.5").build();
        ClimaServicio servicio = restAdapter.create(ClimaServicio.class);
        servicio.obtenerClima(this);
    }

    @Override
    public void success(Clima clima, Response response) {
        progressBar.setVisibility(View.GONE);
        Picasso.with(this).load("https://openweathermap.org/img/w/"+clima.getWeather().get(0).getIcon()+".png").into(iconImageView);
        statusSuccess.setVisibility(View.VISIBLE);
        tempTextView.setText(clima.getMain().getTemp()+"°");
        titleTextView.setText("Clima actual en "+clima.getName()+", "+clima.getSys().getCountry());
        mainTextView.setText(clima.getWeather().get(0).getMain());
        windCloudines.setText(clima.getWeather().get(0).getDescription());
        dataTextView.setText((new Date(Integer.parseInt(clima.getDt()))).toString());
        windTextView.setText(clima.getWind().getSpeed()+" m/s");
        pressureTextView.setText(clima.getMain().getPressure()+" hpa");
        humidityTextView.setText(clima.getMain().getHumidity()+" %");
        sunriseTextView.setText((new Date(Integer.parseInt(clima.getSys().getSunrise())*1000).toString()));
        sunsetTextView.setText((new Date(Integer.parseInt(clima.getSys().getSunset())*1000).toString()));
    }

    @Override
    public void failure(RetrofitError error) {
        errorMessage.setText(error.getLocalizedMessage());
        progressBar.setVisibility(View.GONE);
        statusError.setVisibility(View.VISIBLE);
    }

    public void reintentar(View view) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://api.openweathermap.org/data/2.5").build();
        ClimaServicio servicio = restAdapter.create(ClimaServicio.class);
        servicio.obtenerClima(this);
        progressBar.setVisibility(View.VISIBLE);
        statusSuccess.setVisibility(View.GONE);
        statusError.setVisibility(View.GONE);
    }
}
