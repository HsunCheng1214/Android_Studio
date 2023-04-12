package com.example.w4_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6; TextView rr; EditText e1,e2,e3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rr=(TextView) findViewById(R.id.res);
        b1=(Button) findViewById(R.id.b1); b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3); b4=(Button) findViewById(R.id.b4);
        b5=(Button) findViewById(R.id.b5); b6=(Button) findViewById(R.id.b6);
        e1=(EditText) findViewById(R.id.ed1);
        e2=(EditText) findViewById(R.id.ed2);
        e3=(EditText) findViewById(R.id.ed3);
        b1.setOnClickListener(this); b2.setOnClickListener(this);
        b3.setOnClickListener(this); b4.setOnClickListener(this);
        b5.setOnClickListener(this); b6.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent it=new Intent(); Uri u=null; String ss=e1.getText().toString();
        if(view == b6){
            it.setClass(this, Compavg.class);
            //EditText e2=(EditText) findViewById(R.id.ed2);
            //EditText e3=(EditText) findViewById(R.id.ed3);
            String s1=e2.getText().toString(), s2=e3.getText().toString();
            if(s1.length() > 0 && s2.length() > 0){
                Toast.makeText(this, s1, Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(this, getString(R.string.er), Toast.LENGTH_SHORT).show();
        }

        if(ss.length() > 0){
            it.setAction(Intent.ACTION_VIEW);
            if(view == b1){
                it.setAction(Intent.ACTION_DIAL);
                u = Uri.parse("tel:"+ss);
            }
            if(view == b2) u = Uri.parse("http://"+ss);
            if(view == b3) u = Uri.parse("sms:"+ss+"?body=hello");
            if(view == b4) u = Uri.parse("geo"+ss);
            //TKU: 25.1740706, 121.4451121
            //北車: 25.04633, 121.51393
            if(view == b5){
                it.setAction(Intent.ACTION_WEB_SEARCH);
                it.putExtra(SearchManager.QUERY, ss);
            }
            it.setData(u); startActivity(it);
        }
        else Toast.makeText(this, getString(R.string.er), Toast.LENGTH_SHORT).show();
    }
}