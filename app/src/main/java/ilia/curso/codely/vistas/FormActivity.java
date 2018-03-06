package ilia.curso.codely.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FormActivity extends Activity {

    private TextInputLayout textLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        String[] hoursGuide = getResources().getStringArray(R.array.guide_hour);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item, hoursGuide);

        Spinner horas = findViewById(R.id.conf_spinner);
        horas.setAdapter(adaptador);

        EditText codigo = findViewById(R.id.inputText);
        textLayout = findViewById(R.id.TiLayout);

        Button send = findViewById(R.id.conf_saveButton);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textLayout.setError(getString(R.string.error_codigo));
            }
        });
    }
}
