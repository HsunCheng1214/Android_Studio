package com.example.w13_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar pb; int k=0; EditText ed; WebView wb; Button b1; String url="";
    TextView tv; SharedPreferences sp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=(ProgressBar) findViewById(R.id.pb1);
        ed=(EditText) findViewById(R.id.ed1);
        b1=(Button) findViewById(R.id.b1); b1.setOnClickListener(this);
        wb=(WebView) findViewById(R.id.wv);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setSupportZoom(true); wb.invokeZoomPicker();
        //pb.setVisibility(View.GONE);
        pb.setOnClickListener(this);
        wb.setWebChromeClient(wcc); wb.setWebViewClient(wvc);
        tv=(TextView) findViewById(R.id.tv1);
        sp=getSharedPreferences("test",MODE_PRIVATE);
        url=sp.getString("URL","https://www.tku.edu.tw"); ed.setText(url);
    }

    public WebViewClient wvc=new WebViewClient(){
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pb.setVisibility(view.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }

        public void onPageFinished(WebView view, String url) {
            pb.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    };
    public WebChromeClient wcc=new WebChromeClient(){
        public void onProgressChanged(WebView view, int newProgress) {
            pb.setProgress(newProgress); tv.setText(""+newProgress);
            pb.setVisibility(newProgress < 100 ? View.VISIBLE : View.GONE);
            super.onProgressChanged(view, newProgress);
        }
    };

    @Override
    public void onBackPressed() {
        if(wb.canGoBack()) { wb.goBack(); return; }
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view == b1) {
            String ss=ed.getText().toString();
            if (ss.length()>0) {
                wb.loadUrl(ss); url=ss; sp.edit().putString("URL", url).commit();
                Toast.makeText(this,url, Toast.LENGTH_SHORT).show();
            }
        }
        if(view == pb){
            k+=10; pb.setProgress(k); tv.setText(""+k);
            pb.setVisibility(k < 100 ? View.VISIBLE : View.GONE);
        }
    }
}