package ilia.curso.codely.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);

        String[] hoursGuide = getResources().getStringArray(R.array.guide_hour);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item, hoursGuide);


        Spinner horas = findViewById(R.id.conf_spinner);
        horas.setAdapter(adaptador);
    }
}
