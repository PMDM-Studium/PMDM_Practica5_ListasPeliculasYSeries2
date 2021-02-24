package es.studium.listas.ui.peliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import es.studium.listas.R;

public class DetallesPeliculas extends AppCompatActivity implements View.OnClickListener {
    ImageView imagen;
    TextView nombre;
    TextView director;
    TextView reparto;
    RatingBar clasificacion;
    TextView sinopsis;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_peliculas);

        initViews();
        initValues();
    }
    private void initViews() {
        imagen = findViewById(R.id.imagen);
        nombre = findViewById(R.id.nombre);
        director = findViewById(R.id.director);
        reparto = findViewById(R.id.reparto);
        clasificacion = findViewById(R.id.ratingBar);
        sinopsis = findViewById(R.id.sinopsis);
    }

    private void initValues(){
        //No funciona el Bumble
//        peliculas = (Peliculas)getIntent().getExtras().getSerializable("pelicula");
//        imagen.setImageResource(peliculas.getImagenPelicula());
//        nombre.setText(peliculas.getNombrePelicula());
//        director.setText(peliculas.getDirectorPelicula());
//        reparto.setText(peliculas.getRepartoPelicula());
//        clasificacion.setRating(peliculas.getClasificacionPelicula());
//        sinopsis.setText(peliculas.getSinopsisPelicula());


        imagen.setImageResource(PeliculasFragment.listaPeliculas.get(PeliculasFragment.posicion).getImagenPelicula());
        nombre.setText(PeliculasFragment.listaPeliculas.get(PeliculasFragment.posicion).getNombrePelicula());
        director.setText(PeliculasFragment.listaPeliculas.get(PeliculasFragment.posicion).getDirectorPelicula());
        reparto.setText(PeliculasFragment.listaPeliculas.get(PeliculasFragment.posicion).getRepartoPelicula());
        clasificacion.setRating(PeliculasFragment.listaPeliculas.get(PeliculasFragment.posicion).getClasificacionPelicula());
        sinopsis.setText(PeliculasFragment.listaPeliculas.get(PeliculasFragment.posicion).getSinopsisPelicula());
        button = findViewById(R.id.botonPeliculas);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}