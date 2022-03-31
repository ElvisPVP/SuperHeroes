package cl.desafiolatam.superheroes.servicio;

import cl.desafiolatam.superheroes.modelo.HeroesRespuesta;
import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroAPI {

    @GET("all.json")
    Call<HeroesRespuesta> getHeroesRespuesta();

    @GET("id/{sid}.json")
    Call<HeroesRespuestaItem> getSuperhero(@Path("sid") String id);

}
