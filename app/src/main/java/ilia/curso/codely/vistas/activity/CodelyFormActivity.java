package ilia.curso.codely.vistas.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import ilia.curso.codely.vistas.R;
import ilia.curso.codely.vistas.commons.Validator;
import ilia.curso.codely.vistas.custom.FontLoader;
import ilia.curso.codely.vistas.custom.ImageService;
import ilia.curso.codely.vistas.custom.SGTypeFace;
import ilia.curso.codely.vistas.fragments.DatePickerFragment;

public class CodelyFormActivity extends Activity {

    private Spinner horas;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_style);

        Typeface typeface = SGTypeFace.initializeAppTypeface(this, "bite_chocolate.ttf");
        FontLoader.setDefaultFont(typeface);

        imagen = findViewById(R.id.image_course);

        String[] hoursGuide = getResources().getStringArray(R.array.courses_titles);
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item, hoursGuide);

        horas = findViewById(R.id.conf_spinner);
        horas.setAdapter(adaptador);
        horas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int id = getResources().getIdentifier("codely_" + i, "mipmap", getPackageName());

                Bitmap bitmap = ImageService.getCircleBitmap(BitmapFactory.decodeResource(getResources(), id));
                imagen.setImageBitmap(bitmap);
                imagen.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                imagen.setVisibility(View.GONE);
            }
        });

        TextView title = findViewById(R.id.title);
        FontLoader.applyDefault(title);

    }
}
