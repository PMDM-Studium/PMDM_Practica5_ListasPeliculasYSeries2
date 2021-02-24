package es.studium.listas.ui.series;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import es.studium.listas.R;

public class DetallesSeries extends AppCompatActivity implements View.OnClickListener{
    ImageView imagen;
    TextView nombre;
    TextView director;
    TextView reparto;
    RatingBar clasificacion;
    TextView temporadas;
    TextView sinopsis;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_series);

        initViews();
        initValues();
    }
    private void initViews() {
        imagen = findViewById(R.id.imagen);
        nombre = findViewById(R.id.nombre);
        director = findViewById(R.id.director);
        reparto = findViewById(R.id.reparto);
        clasificacion = findViewById(R.id.ratingBar);
        temporadas = findViewById(R.id.temporadas);
        sinopsis = findViewById(R.id.sinopsis);
    }

    private void initValues(){
        imagen.setImageResource(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getImagenSerie());
        nombre.setText(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getNombreSerie());
        director.setText(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getDirectorSerie());
        reparto.setText(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getRepartoSerie());
        clasificacion.setRating(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getClasificacionSerie());
        temporadas.setText(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getTemporadasSerie());
        sinopsis.setText(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getSinopsisSerie());

        button = findViewById(R.id.botonSeries);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}

