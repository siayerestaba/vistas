package ilia.curso.codely.vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonText = findViewById(R.id.button_text);
        buttonText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, TextActivity.class);
                startActivity(mainIntent);
            }
        });

        Button buttonImage = findViewById(R.id.button_image);
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(mainIntent);
            }
        });

        Button buttonButtons = findViewById(R.id.button_buttons);
        buttonButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, ButtonsActivity.class);
                startActivity(mainIntent);
            }
        });

        Button buttonList = findViewById(R.id.button_list);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(mainIntent);
            }
        });

        Button buttonListStyled = findViewById(R.id.button_listStyled);
        buttonListStyled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, ListWithStyleActivity.class);
                startActivity(mainIntent);
            }
        });

        Button buttonGrid = findViewById(R.id.button_grid);
        buttonGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(mainIntent);
            }
        });

        Button buttonGridStyled = findViewById(R.id.button_gridStyled);
        buttonGridStyled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, GridWithStyleActivity.class);
                startActivity(mainIntent);
            }
        });

        Button buttonRecycler = findViewById(R.id.button_recycler);
        buttonRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
