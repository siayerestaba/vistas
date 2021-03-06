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

import ilia.curso.codely.vistas.commons.Validator;
import ilia.curso.codely.vistas.fragments.DatePickerFragment;
import ilia.curso.codely.vistas.R;

public class FormActivity extends Activity {

    private EditText email;
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

        email = findViewById(R.id.inputText);
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
                if(email.getText() == null || email.getText().toString().equals("")) {
                    textLayout.setError(getString(R.string.error_empty));
                } else if (!Validator.isEmailValid(email.getText().toString())) {
                    textLayout.setError(getString(R.string.error_email));
                }
            }
        });

        Button showhide = findViewById(R.id.hideButton);
        showhide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fecha.getVisibility() == View.VISIBLE) {
                    fecha.setVisibility(View.GONE);
                } else {
                    fecha.setVisibility(View.VISIBLE);
                }
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
