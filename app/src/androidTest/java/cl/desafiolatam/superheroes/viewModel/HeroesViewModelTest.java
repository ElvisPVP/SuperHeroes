package cl.desafiolatam.superheroes.viewModel;

import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.google.common.base.Verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import cl.desafiolatam.superheroes.modelo.HeroesRespuesta;
import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;

@RunWith(MockitoJUnitRunner.class)
public class HeroesViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Observer<HeroesRespuestaItem> heroesRespuestaItemObserver;

    @Mock
    private Observer<List<HeroesRespuestaItem>> listaObserver;

    private HeroesViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        viewModel = new HeroesViewModel();
        viewModel.getMisHeroes().observeForever(listaObserver);
        viewModel.getMisHeroeItem().observeForever(heroesRespuestaItemObserver);
    }

    @Test
    public void mostrarHeroe() throws InterruptedException{
        viewModel.llamarApi();
        Thread.sleep(5000);
        List<HeroesRespuestaItem> nuevosheroes = viewModel.getMisHeroes().getValue();
        verify(listaObserver).onChanged(viewModel.getMisHeroes().getValue());

    }
}