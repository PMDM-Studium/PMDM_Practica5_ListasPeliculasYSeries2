package es.studium.listas.ui.series;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import es.studium.listas.R;

public class CaratulasSeries extends AppCompatActivity implements View.OnClickListener{
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caratulas_series);
        imagen = findViewById(R.id.CaratulasSeries);
        imagen.setImageResource(SeriesFragment.listaSeries.get(SeriesFragment.posicion).getImagenSerie());
        imagen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}