package prado.com.Rnews.layout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import prado.com.Rnews.R;

public class FragmentWeb extends Fragment {

    private String URL;

    @SuppressLint("ValidFragment")
    public FragmentWeb(String URL) {
        this.URL = URL;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        WebView webView = (WebView) view.findViewById(R.id.webView);
        webView.loadUrl(URL);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
