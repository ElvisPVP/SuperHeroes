package cl.desafiolatam.superheroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.superheroes.R;
import cl.desafiolatam.superheroes.databinding.ItemLayoutListBinding;

import cl.desafiolatam.superheroes.modelo.HeroesRespuestaItem;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.CustomViewHolder>{

    private List<HeroesRespuestaItem> lista = new ArrayList<>();
    private MiOnClickListener listener;

    public void setLista(List<HeroesRespuestaItem> lista){
        this.lista = lista;
        notifyDataSetChanged();
    }

    public void setListener(MiOnClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_list,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindData(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        private ItemLayoutListBinding binding;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemLayoutListBinding.bind(itemView);

        }

        public void bindData (HeroesRespuestaItem heroesRespuestaItem){
            Picasso.get().load(heroesRespuestaItem.getImages().getLg()).into(binding.ivSuper);
            binding.tvName.setText(heroesRespuestaItem.getName());
            binding.tvSlug.setText(heroesRespuestaItem.getSlug());
            itemView.setOnClickListener(v -> {
                listener.onClickListener(heroesRespuestaItem);
            });
        }
    }

    public interface MiOnClickListener{
        void onClickListener(HeroesRespuestaItem heroesRespuestaItem);
    }


}
