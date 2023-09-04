package com.example.w11_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TabHost tb; Button b1; TextView res; EditText e_h, e_w;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=(TabHost) findViewById(R.id.tbh); tb.setup();
        b1=(Button) findViewById(R.id.b1); b1.setOnClickListener(this);
        TabHost.TabSpec ss=tb.newTabSpec("tab1");
        ss.setContent(R.id.tab1); ss.setIndicator(getString(R.string.bmi));
        TabHost.TabSpec s1=tb.newTabSpec("tab2");
        s1.setContent(R.id.tab2); s1.setIndicator(getString(R.string.exp));
        tb.addTab(ss); tb.addTab(s1); tb.setCurrentTab(1);
    }
    public void onClick(View view) {
        e_h=(EditText) findViewById(R.id.ed_hi);
        e_w=(EditText) findViewById(R.id.ed_wei);
        res=(TextView) findViewById(R.id.res);
        String sh=e_h.getText().toString(),sw=e_w.getText().toString();
        if(sh.length()>0 && sw.length() > 0){
            double h=Double.parseDouble(sh)/100.0, w=Double.parseDouble(sw),bmi;
            bmi=w/(h*h); res.setText(getString(R.string.result)+String.format("%.2f", bmi));
        }
        else Toast.makeText(this, getString(R.string.err),Toast.LENGTH_SHORT).show();
    }
}