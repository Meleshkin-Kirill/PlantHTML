// MainActivity.java
package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.test.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webview);
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://192.168.4.1");
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            if (url.equals("http://192.168.4.1/save")) {
                // Переходим на следующую сцену
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                return true; // Возвращаем true, чтобы предотвратить дальнейшую загрузку.
            }
            return false; // Продолжаем загрузку других URL.
        }
    }
}