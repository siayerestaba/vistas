package ilia.curso.codely.vistas.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import ilia.curso.codely.vistas.fragments.DatePickerFragment;
import ilia.curso.codely.vistas.R;

public class FormActivity extends Activity {

    private EditText fecha;
    private TextInputLayout textLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        String[] hoursGuide = getResources().getStringArray(R.array.courses_titles);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item, hoursGuide);

        Spinner horas = findViewById(R.id.conf_spinner);
        horas.setAdapter(adaptador);

        EditText codigo = findViewById(R.id.inputText);
        textLayout = findViewById(R.id.TiLayout);

        fecha = findViewById(R.id.etPlannedDate);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seleccionarFecha();
            }
        });

        Button send = findViewById(R.id.conf_saveButton);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textLayout.setError(getString(R.string.error_codigo));
            }
        });
    }

    public void seleccionarFecha() {
        DatePickerFragment datePickerFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                fecha.setText(selectedDate);
            }
        });

        datePickerFragment.show(getFragmentManager(), "datePicker");
    }
}
