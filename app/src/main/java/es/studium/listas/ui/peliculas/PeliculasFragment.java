package es.studium.listas.ui.peliculas;

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

public class PeliculasFragment extends Fragment implements Serializable {

    //Inicianizamos
    RecyclerView recyclerViewPeliculas;
    PeliculasAdapter peliculasAdapter;
    RecyclerView.LayoutManager layoutManager;

    //Inicializamos compartidos
    public static List<Peliculas> listaPeliculas;
    public static int posicion;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_peliculas, container, false);
        //Iniciamos la lista de las peliculas
        listaPeliculas = new ArrayList();
        cargarlista();

        //Optenemos el recicler
        recyclerViewPeliculas=view.findViewById(R.id.peliculasRecyclerView);

        //Usamos el LinearLayaut
        layoutManager = new LinearLayoutManager(getContext());
        recyclerViewPeliculas.setLayoutManager(layoutManager);

        //Adaptador
        peliculasAdapter = new PeliculasAdapter(listaPeliculas, new PeliculasInterface() {
            @Override
            public void onClick(View view, int pos) {
                if  (view.getId()==R.id.imagenPelicula){
                    posicion = pos;
                    Intent intent2 = new Intent(view.getContext(), CaratulasPeliculas.class);
                    //No Funciona
//                    Bundle bundle = new Bundle();
//                    intent.putExtra("peliculas", pelicula);
                    startActivity(intent2);
                }
                else {
                    posicion = pos;
                        Intent intent2 = new Intent(view.getContext(), DetallesPeliculas.class);
                        startActivity(intent2);
                }
            }
        });
        //Asignamos el adaptador
        recyclerViewPeliculas.setAdapter(peliculasAdapter);
        return view;
    }

            //Metodo para cargar la lista.
    public void cargarlista() {
        listaPeliculas.add(new Peliculas(R.drawable.deadpool, getString(R.string.nombrePelicula1),getString(R.string.directorPelicula1)
                , getString(R.string.repartoPelicula1),1,getString(R.string.sinopsisPelicula1)));
        listaPeliculas.add(new Peliculas(R.drawable.elseniordelosanillos, getString(R.string.nombrePelicula2),getString(R.string.directorPelicula2)
                , getString(R.string.repartoPelicula2),2,getString(R.string.sinopsisPelicula2)));
        listaPeliculas.add(new Peliculas(R.drawable.losvengadores, getString(R.string.nombrePelicula3),getString(R.string.directorPelicula3)
                , getString(R.string.repartoPelicula3),3,getString(R.string.sinopsisPelicula3)));
        listaPeliculas.add(new Peliculas(R.drawable.starwars, getString(R.string.nombrePelicula4),getString(R.string.directorPelicula4)
                , getString(R.string.repartoPelicula4),4,getString(R.string.sinopsisPelicula4)));
        listaPeliculas.add(new Peliculas(R.drawable.superman, getString(R.string.nombrePelicula5),getString(R.string.directorPelicula5)
                ,  getString(R.string.repartoPelicula5),5,getString(R.string.sinopsisPelicula5)));
    }
}