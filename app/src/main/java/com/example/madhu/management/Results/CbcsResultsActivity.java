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
import com.example.madhu.management.UpdatesActivity;

public class CbcsResultsActivity extends AppCompatActivity {

    WebView webViewcbcs;
    String url = "http://results.vtu.ac.in/vitaviresultcbcs/index.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbcs_results);

        webViewcbcs = (WebView)findViewById(R.id.cbcsresultswebview);
        WebSettings webSettings = webViewcbcs.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //improve webView performance
        webViewcbcs.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webViewcbcs.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webViewcbcs.getSettings().setAppCacheEnabled(true);
        webViewcbcs.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);



        webViewcbcs.setWebViewClient(new CbcsResultsActivity.cbcsWebViewClient());
        webViewcbcs.loadUrl(url);

    }


    private class cbcsWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("http://results.vtu.ac.in/vitaviresultcbcs/index.php")) {
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
            pd = new ProgressDialog(CbcsResultsActivity.this);
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
                    if (webViewcbcs.canGoBack()) {
                        webViewcbcs.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
