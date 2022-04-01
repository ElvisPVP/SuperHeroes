package cl.desafiolatam.superheroes.servicio;

import java.util.List;

import cl.desafiolatam.superheroes.modelo.HeroesRespuesta;
import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroAPI {

    @GET("all.json")
    Call<List<HeroesRespuestaItem>> getHeroesRespuesta();

    @GET("id/{sid}.json")
    Call<HeroesRespuestaItem> getSuperhero(@Path("sid") String id);

}
