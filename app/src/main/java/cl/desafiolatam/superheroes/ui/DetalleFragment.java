package cl.desafiolatam.superheroes.ui;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;


import cl.desafiolatam.superheroes.databinding.FragmentDetalleBinding;
import cl.desafiolatam.superheroes.viewModel.HeroesViewModel;


public class DetalleFragment extends Fragment {

    private FragmentDetalleBinding binding;
    private HeroesViewModel viewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(inflater,container,false);

        viewModel = new ViewModelProvider(getActivity()).get(HeroesViewModel.class);

        viewModel.getMisHeroesItem().observe(getViewLifecycleOwner(),heroesRespuestaItems -> {
            binding.tvNameDetail.setText(heroesRespuestaItems.getName());
            if (heroesRespuestaItems.getBiography().getFullName().equals("")){
                binding.tvNameDetail.setText(heroesRespuestaItems.getName());
            }
            else {
                binding.tvNameRealDetail.setText(heroesRespuestaItems.getBiography().getFullName());
            }
            Picasso.get().load(heroesRespuestaItems.getImages().getLg()).into(binding.ivSuperDetail);
            binding.tvCombateDetail.setText(String.valueOf(heroesRespuestaItems.getPowerstats().getCombat()));
            binding.tvFuerzaDetail.setText(String.valueOf(heroesRespuestaItems.getPowerstats().getStrength()));
            binding.tvDurabilidadDetail.setText(String.valueOf(heroesRespuestaItems.getPowerstats().getDurability()));
            binding.tvInteligenciaDetail.setText(String.valueOf(heroesRespuestaItems.getPowerstats().getIntelligence()));
            binding.tvPoderDetail.setText(String.valueOf(heroesRespuestaItems.getPowerstats().getPower()));
            binding.tvVelocidadDetail.setText(String.valueOf(heroesRespuestaItems.getPowerstats().getSpeed()));
            });



        return binding.getRoot();
    }
}