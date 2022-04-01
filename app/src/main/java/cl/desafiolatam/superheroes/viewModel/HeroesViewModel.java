package cl.desafiolatam.superheroes.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cl.desafiolatam.superheroes.cliente.ClienteRetrofit;
import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;
import cl.desafiolatam.superheroes.servicio.SuperHeroAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroesViewModel extends ViewModel {

    private SuperHeroAPI servicio = ClienteRetrofit.getInstance(ClienteRetrofit.BASE_URL);
    private MutableLiveData<List<HeroesRespuestaItem>> misHeroes = new MutableLiveData<List<HeroesRespuestaItem>>();
    private MutableLiveData<HeroesRespuestaItem> misHeroesItem = new MutableLiveData<>();

    public void llamarApi(){
        servicio.getHeroesRespuesta().enqueue(new Callback <List<HeroesRespuestaItem>>() {

            @Override
            public void onResponse(Call<List<HeroesRespuestaItem>> call, Response<List<HeroesRespuestaItem>> response) {
                misHeroes.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<HeroesRespuestaItem>> call, Throwable t) {
                Log.i("API",t.getMessage());
                call.cancel();
            }
        });
    }

    public void mostrarHeroe(HeroesRespuestaItem heroesRespuestaItem) {
        misHeroesItem.setValue(heroesRespuestaItem)
        ;}

    public MutableLiveData<List<HeroesRespuestaItem>> getMisHeroes() {
        return misHeroes;
    }

    public MutableLiveData<HeroesRespuestaItem> getMisHeroesItem() {
        return misHeroesItem;
    }
}
