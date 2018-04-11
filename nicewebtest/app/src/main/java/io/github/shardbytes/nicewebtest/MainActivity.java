package io.github.shardbytes.nicewebtest;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    public WebView _webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _webview = (WebView) findViewById(R.id.web);

        WebSettings webSettings = _webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);
        //_webview.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null); // if bad background

        webSettings.setAppCacheEnabled(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        _webview.setWebViewClient(new WebViewClient());

        WebView.setWebContentsDebuggingEnabled(true);

        _webview.loadUrl("file:///android_asset/empty.html", null);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run()
            {
                _webview.loadUrl("https://alightinthevoid.fr.openode.io", null);
            }
        }, 500);



    }
}
