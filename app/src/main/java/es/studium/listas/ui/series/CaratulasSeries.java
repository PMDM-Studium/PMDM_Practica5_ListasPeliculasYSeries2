package es.studium.listas.ui.series;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import es.studium.listas.R;

public class CaratulasSeries extends AppCompatActivity {
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caratulas_series);
        imagen = findViewById(R.id.CaratulasSeries);
        imagen.setImageResource(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getImagenSerie());

    }

}