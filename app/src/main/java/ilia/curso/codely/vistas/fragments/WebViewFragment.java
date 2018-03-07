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

import ilia.curso.codely.vistas.R;


/**
 * @author ilia
 *
 */
public class WebViewFragment extends Fragment {
	private String urlToView = "https://www.codely.tv";
	private WebView webview;

	public WebViewFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.webview, container, false);

		webview = (WebView) rootView.findViewById(R.id.webPage);
		webview.getSettings().setBuiltInZoomControls(false);
		webview.getSettings().setSupportZoom(false);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		webview.getSettings().setAllowFileAccess(true);
		webview.getSettings().setDomStorageEnabled(true);

		webview.loadUrl(urlToView);
		webview.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});

		return rootView;
	}
}
