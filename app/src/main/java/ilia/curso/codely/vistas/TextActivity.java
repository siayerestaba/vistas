package ilia.curso.codely.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class TextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);

        TextView texto1 = findViewById(R.id.texto1);
        texto1.setText(R.string.register_legal);
        texto1.setMovementMethod(LinkMovementMethod.getInstance());
        Strip.stripUnderlines(texto1);

        TextView texto2 = findViewById(R.id.texto2);
        texto2.setText(Html.fromHtml("<H3>Los meses del año</H3>\n" +
                "<UL>\n" +
                "<LI>Los meses de primavera\n" +
                "<OL>\n" +
                "<LI>Abril</LI>\n" +
                "<LI>Mayo</LI>\n" +
                "<LI>Junio</LI>\n" +
                "</OL>\n" +
                "</LI>\n" +
                "<LI>Los meses de verano\n" +
                "<OL>\n" +
                "<LI>Julio</LI>\n" +
                "<LI>Agosto</LI>\n" +
                "<LI>Septiembre</LI>\n" +
                "</OL>\n" +
                "</LI>\n" +
                "</UL>\n" +
                "<BR>"));
    }
}
