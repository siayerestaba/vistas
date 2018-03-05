package ilia.curso.codely.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

//        ImageView imagen = findViewById(R.id.imagen_android);
//        Picasso.with(this).load("http://img.ibxk.com.br//2015/12/11/11162542936659-t1200x480.jpg").placeholder(R.mipmap.giro).into(imagen);
//
//        ImageView imagen2 = findViewById(R.id.imagen_android2);
//        Glide.with(this).load("https://tr2.cbsistatic.com/hub/i/r/2017/01/31/7e355c52-c68f-4389-825f-392f2dd2ac19/resize/770x/d19d6c021f770122da649e2a77bd1404/androiddatahero.jpg").fitCenter().into(imagen2);
    }
}
