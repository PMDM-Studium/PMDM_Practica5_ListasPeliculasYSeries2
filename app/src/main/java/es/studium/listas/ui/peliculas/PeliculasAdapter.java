package es.studium.listas.ui.peliculas;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import es.studium.listas.R;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>{
    private List<Peliculas> items;
    private static PeliculasInterface peliculasInterface;

    public static class PeliculasViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        // Inicializamos
        public ImageView imagenPelicula;
        public TextView nombrePelicula;
        public TextView directorPeliculas;


        public PeliculasViewHolder(@NonNull View view){
            super(view);
            imagenPelicula = (ImageView) view.findViewById(R.id.imagenPelicula);
            nombrePelicula = (TextView) view.findViewById(R.id.nombrePelicula);
            directorPeliculas = (TextView) view.findViewById(R.id.directorPelicula);

            imagenPelicula.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            peliculasInterface.onClick(view, getAdapterPosition());
        }
    }

    public PeliculasAdapter(List<Peliculas> items, PeliculasInterface peliculasInterface){

        this.items =items;
        this.peliculasInterface = peliculasInterface;
    }

    @Override
    public PeliculasViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.peliculas_card, viewGroup, false);

        return new PeliculasViewHolder(v);
    }


    @Override
    public void onBindViewHolder(PeliculasViewHolder peliculasViewHolder, int i) {
        peliculasViewHolder.imagenPelicula.setImageResource(items.get(i).getImagenPelicula());
        peliculasViewHolder.nombrePelicula.setText(items.get(i).getNombrePelicula());
        peliculasViewHolder.directorPeliculas.setText(items.get(i).getDirectorPelicula());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

