package cl.desafiolatam.superheroes.cliente;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import cl.desafiolatam.superheroes.LectorJson;
import cl.desafiolatam.superheroes.modelo.HeroesRespuesta;
import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;
import cl.desafiolatam.superheroes.servicio.SuperHeroAPI;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.http.Path;

@RunWith(AndroidJUnit4.class)
public class ClienteRetrofitTest {

    private MockWebServer server;
    private String url = "http://localhost:8080/api/";
    private String body = LectorJson.lector("heroes.json");

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start(8080);
        server.enqueue(new MockResponse().setResponseCode(200).setBody(body));
        server.url("id/1.json");
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void test_apiSuccess(){
        SuperHeroAPI servicio = ClienteRetrofit.getInstance(url);
        try{
            HeroesRespuestaItem heroesRespuesta = servicio.getSuperhero("id").execute().body();
                Truth.assertThat(heroesRespuesta.getName()).isEqualTo("A-Bomb");


        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}