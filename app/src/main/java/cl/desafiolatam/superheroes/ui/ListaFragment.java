package cl.desafiolatam.superheroes.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatam.superheroes.R;
import cl.desafiolatam.superheroes.adapter.HeroesAdapter;
import cl.desafiolatam.superheroes.databinding.FragmentListaBinding;
import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;
import cl.desafiolatam.superheroes.viewModel.HeroesViewModel;


public class ListaFragment extends Fragment {

    private FragmentListaBinding binding;
    private HeroesViewModel viewModel;
    private HeroesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListaBinding.inflate(inflater, container,false);
        viewModel = new ViewModelProvider(getActivity()).get(HeroesViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        adapter = new HeroesAdapter();
        GridLayoutManager manager = new GridLayoutManager(getContext(),1);
        binding.rvLista.setAdapter(adapter);
        binding.rvLista.setLayoutManager(manager);

        adapter.setListener(new HeroesAdapter.MiOnClickListener() {
            @Override
            public void onClickListener(HeroesRespuestaItem heroesRespuestaItem) {
                viewModel.mostrarHeroe(heroesRespuestaItem);

                Navigation.findNavController(getView()).navigate(R.id.action_listaFragment_to_detalleFragment);
            }
        });

        viewModel.getMisHeroes().observe(getViewLifecycleOwner(), heroesRespuesta -> {
            Log.i("Heroes", heroesRespuesta.toString());
            adapter.setLista(heroesRespuesta);
        });
    }
}