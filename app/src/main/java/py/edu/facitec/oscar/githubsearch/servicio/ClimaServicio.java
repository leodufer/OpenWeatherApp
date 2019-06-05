package py.edu.facitec.oscar.githubsearch.servicio;

import py.edu.facitec.oscar.githubsearch.modelo.Clima;
import retrofit.Callback;
import retrofit.http.GET;

public interface ClimaServicio {
    @GET("/weather?id=3437148&appid=0b03491d731a084c078fc509c16ba425&units=metric&lang=es")
    void obtenerClima(Callback<Clima> callback);
}
