package com.example.experience4_webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class MyBrowsActivity extends AppCompatActivity {
    private static final String TAG = "myTag";
    WebView webView;

    ImageButton imageButton_Go,imageButton_Home;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        inital();
        setTopClickListener();
        loadWebView(getUrl());
    }

    void inital(){
        editText = findViewById(R.id.editText);
        imageButton_Go = findViewById(R.id.imageButton_Go);
        imageButton_Home = findViewById(R.id.imageButton_Home);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    void setTopClickListener(){

        imageButton_Go.setOnClickListener(v -> {
            loadWebView(editText.getText().toString());
        });
        imageButton_Home.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

    }

    void loadWebView(String url) {


        //加载网页
        webView.loadUrl(url);
        //复写shouldOverrideUrlLoading()方法，使得打开网页时不调用系统浏览器， 而是在本WebView中显示
        webView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(String.valueOf(request.getUrl()));
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

        });
    }

    String getUrl(){
        Intent intent = getIntent();
        Uri uri = intent.getData();
        URL url = null;
        ////创建一个URL对象，注入协议，主机名，路径
        try {
            url = new URL(uri.getScheme(), uri.getHost(), uri.getPath());
            Log.d(TAG, "onCreate: "+url);
        } catch (Exception e) {
            Log.d(TAG, "onCreate: error");
        }
        return url.toString();
    }

}
