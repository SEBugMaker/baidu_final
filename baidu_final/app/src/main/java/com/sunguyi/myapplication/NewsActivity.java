package com.sunguyi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends Activity {

    private Button backButton;

    private WebView webView;

    private Bundle bundle;

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        bundle = this.getIntent().getExtras();
        title = findViewById(R.id.textView11);
        title.setText(bundle.getString("news_title"));
        String url = bundle.getString("src");

        backButton = findViewById(R.id.button4_back);
        webView = findViewById(R.id.webView1);


        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                intent=new Intent(NewsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
