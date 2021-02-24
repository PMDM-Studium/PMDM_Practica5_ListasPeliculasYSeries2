package es.studium.listas.ui.peliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import es.studium.listas.R;

public class CaratulasPeliculas extends AppCompatActivity {
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caratula_peliculas);
        imagen = findViewById(R.id.CaratulasPeliculas);
        imagen.setImageResource(PeliculasFragment.listaPeliculas.get(PeliculasFragment.posicion).getImagenPelicula());
    }
}