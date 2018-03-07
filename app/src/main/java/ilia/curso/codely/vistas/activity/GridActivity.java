package ilia.curso.codely.vistas.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import ilia.curso.codely.vistas.R;

/**
 * Created by Perez on 05/03/2018.
 */

public class GridActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        String[] hoursGuide = getResources().getStringArray(R.array.courses_titles);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, hoursGuide);

        GridView grid = findViewById(R.id.channel_gridView);
        grid.setAdapter(adaptador);
    }
}
