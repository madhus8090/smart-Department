package com.example.madhu.management.Results;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.madhu.management.R;

public class RevalNonCbcsResultsActivity extends AppCompatActivity {

    WebView webViewrevalnoncbcs;
    String url = "http://results.vtu.ac.in/vitavirevalresultnoncbcs/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reval_non_cbcs_results);

        webViewrevalnoncbcs = (WebView)findViewById(R.id.revalnoncbcswebview);
        WebSettings webSettings = webViewrevalnoncbcs.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //improve webView performance
        webViewrevalnoncbcs.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webViewrevalnoncbcs.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webViewrevalnoncbcs.getSettings().setAppCacheEnabled(true);
        webViewrevalnoncbcs.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);

        webViewrevalnoncbcs.setWebViewClient(new RevalNonCbcsResultsActivity.revalnoncbcsWebViewClient());
        webViewrevalnoncbcs.loadUrl(url);

    }


    private class revalnoncbcsWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("http://results.vtu.ac.in/vitavirevalresultnoncbcs/index.php")) {
                //open url contents in webview
                return false;
            } else {
                //here open external links in external browser or app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

        }

        //ProgressDialogue
        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pd = new ProgressDialog(RevalNonCbcsResultsActivity.this);
            pd.setTitle("Please Wait..");
            pd.setMessage("Loading Results..");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);
        }
    }
    //goto previous page when pressing back button

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webViewrevalnoncbcs.canGoBack()) {
                        webViewrevalnoncbcs.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
