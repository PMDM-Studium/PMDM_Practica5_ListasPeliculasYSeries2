package es.studium.listas.ui.series;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import es.studium.listas.R;
import es.studium.listas.ui.peliculas.Peliculas;
import es.studium.listas.ui.peliculas.PeliculasInterface;

public class SeriesAdapter extends RecyclerView.Adapter<es.studium.listas.ui.series.SeriesAdapter.SeriesViewHolder>{
    private List<Series> items;
    private static SeriesInterface seriesInterface;

    public static class SeriesViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        // Inicializamos
        public ImageView imagenSerie;
        public TextView nombreSerie;
        public TextView directorSerie;


        public SeriesViewHolder(@NonNull View view){
            super(view);
            imagenSerie = (ImageView) view.findViewById(R.id.imagenSerie);
            nombreSerie = (TextView) view.findViewById(R.id.nombreSerie);
            directorSerie = (TextView) view.findViewById(R.id.directorSerie);

            imagenSerie.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            seriesInterface.onClick(view, getAdapterPosition());
        }
    }

    public SeriesAdapter(List<Series> items, SeriesInterface seriesInterface){

        this.items =items;
        this.seriesInterface = seriesInterface;
    }

    @Override
    public es.studium.listas.ui.series.SeriesAdapter.SeriesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.series_card, viewGroup, false);

        return new es.studium.listas.ui.series.SeriesAdapter.SeriesViewHolder(v);
    }


    @Override
    public void onBindViewHolder(es.studium.listas.ui.series.SeriesAdapter.SeriesViewHolder seriesViewHolder, int i) {
        seriesViewHolder.imagenSerie.setImageResource(items.get(i).getImagenSerie());
        seriesViewHolder.nombreSerie.setText(items.get(i).getNombreSerie());
        seriesViewHolder.directorSerie.setText(items.get(i).getDirectorSerie());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}