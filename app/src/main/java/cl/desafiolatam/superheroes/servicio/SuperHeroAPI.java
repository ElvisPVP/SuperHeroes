package cl.desafiolatam.superheroes.servicio;

import java.util.List;

import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroAPI {

    @GET("all.json")
    Call<List<HeroesRespuestaItem>> getHeroesRespuesta();

    @GET("{id}/1.json")
    Call<HeroesRespuestaItem> getSuperhero(@Path("id") String id);

}
