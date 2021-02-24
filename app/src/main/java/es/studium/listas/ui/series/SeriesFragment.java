package es.studium.listas.ui.series;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import es.studium.listas.R;

public class SeriesFragment extends Fragment implements Serializable {

    //Inicianizamos
    RecyclerView recyclerViewSeries;
    SeriesAdapter seriesAdapter;
    RecyclerView.LayoutManager layoutManager;

    //Inicializamos compartidos
    public static List<Series> listaSeries;
    public static int posicion;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_series, container, false);
        //Iniciamos la lista de las series
        listaSeries = new ArrayList();
        cargarlista();

        //Optenemos el recicler
        recyclerViewSeries=view.findViewById(R.id.seriesRecyclerView);

        //Usamos el LinearLayaut
        layoutManager = new LinearLayoutManager(getContext());
        recyclerViewSeries.setLayoutManager(layoutManager);

        //Adaptador
        seriesAdapter = new SeriesAdapter(listaSeries, new SeriesInterface() {
            @Override
            public void onClick(View view, int pos) {

                if  (view.getId()==R.id.imagenSerie){
                    posicion = pos;
                    Intent intent = new Intent(view.getContext(), CaratulasSeries.class);
                    startActivity(intent);
                }
                else {
                    posicion = pos;
                    Intent intent = new Intent(view.getContext(), DetallesSeries.class);
                    startActivity(intent);
                }
            }
        });
        //Asignamos el adaptador
        recyclerViewSeries.setAdapter(seriesAdapter);
        return view;
    }

    //Metodo para cargar la lista.
    public void cargarlista() {
        listaSeries.add(new Series(R.drawable.mandalorian, getString(R.string.nombreSerie1), getString(R.string.directorSerie1),
                getString(R.string.repartoSerie1),1,getString(R.string.temporadasSerie1),getString(R.string.sinopsisSerie1)));
        listaSeries.add(new Series(R.drawable.doctorwho, getString(R.string.nombreSerie2), getString(R.string.directorSerie2),
                getString(R.string.repartoSerie2),2,getString(R.string.temporadasSerie2),getString(R.string.sinopsisSerie2)));
        listaSeries.add(new Series(R.drawable.flash, getString(R.string.nombreSerie3), getString(R.string.directorSerie3),
                getString(R.string.repartoSerie3),3,getString(R.string.temporadasSerie3),getString(R.string.sinopsisSerie3)));
        listaSeries.add(new Series(R.drawable.merlin, getString(R.string.nombreSerie4), getString(R.string.directorSerie4),
                getString(R.string.repartoSerie4),4,getString(R.string.temporadasSerie4),getString(R.string.sinopsisSerie4)));
        listaSeries.add(new Series(R.drawable.heroes, getString(R.string.nombreSerie5), getString(R.string.directorSerie5),
                getString(R.string.repartoSerie5),5,getString(R.string.temporadasSerie5),getString(R.string.sinopsisSerie5)));
    }
}