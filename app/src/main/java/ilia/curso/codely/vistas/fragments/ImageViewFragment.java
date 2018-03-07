/**
 *
 */
package ilia.curso.codely.vistas.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import ilia.curso.codely.vistas.R;


/**
 * @author ilia
 */
public class ImageViewFragment extends Fragment {

    public ImageViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.imageview, container, false);

        int id = 0;
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getInt("idImage");
        }

        ImageView imagen = rootView.findViewById(R.id.imagen);
        imagen.setImageResource(id);

        return rootView;
    }
}
