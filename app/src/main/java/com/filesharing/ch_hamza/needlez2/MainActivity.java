package com.filesharing.ch_hamza.needlez2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    boolean loadingFinished = true;
    boolean redirect = false;
    private ProgressBar progress;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        progress = (ProgressBar) findViewById(R.id.progressBar);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://needlezbyshalimar.com/");
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                    tvNoInternet.setVisibility(View.VISIBLE);
                progress.setVisibility(View.VISIBLE);
                setTitle("Loading....");
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                    tvNoInternet.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);
                setTitle(view.getTitle());
            }
        });

//        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
//
//        webView.setWebViewClient(new MyWebViewClient());
//        String url = "http://www.needlezbyshalimar.com/";
//       // View.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(url);
//        loadingFinished= true;

    }

//        private class MyWebViewClient extends WebViewClient {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                loadingFinished= true;
//                return true;
//            }
//
//
//    }
}
