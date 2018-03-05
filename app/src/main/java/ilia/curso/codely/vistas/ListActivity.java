package ilia.curso.codely.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Perez on 05/03/2018.
 */

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        String[] hoursGuide = getResources().getStringArray(R.array.guide_hour);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, hoursGuide);

        ListView lista = findViewById(R.id.menu_listview);
        lista.setAdapter(adaptador);
    }
}
