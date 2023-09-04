package com.example.w3_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class Second2 extends AppCompatActivity implements View.OnClickListener{
    Button b2, b3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        Log.d("test","Second2_onCreate");
        setTitle(getString(R.string.act2_title));
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        Intent it=getIntent();
        int no=it.getIntExtra("編號",0);
        String id=it.getStringExtra("身分");
        String f[]=it.getStringArrayExtra("愛吃");
        TextView r1=(TextView) findViewById(R.id.textView);
        String ss="接收資料如右:編號:"+no+",愛吃:", s1="";
        for(int i=0 ; i<f.length ; i++) if (i==0) s1=f[i]; else s1+="、"+f[i];
        r1.setText(ss+s1);
    }

    public void onClick(View view) {
        if(view == b2) {
            Intent it=new Intent(this, Third3.class); startActivity(it);
        }
        if(view == b3) finish();
    }

    protected void onStart(){
        super.onStart(); Log.d("test","Second2_onStart");
    }
    protected void onResume(){
        super.onResume(); Log.d("test","Second2_onResume");
    }
    protected void onPause(){
        super.onPause(); Log.d("test","Second2_onPause");
    }
    protected void onStop(){
        super.onStop(); Log.d("test","Second2_onStop");
    }
    protected void onDestroy(){
        super.onDestroy(); Log.d("test","Second2_onDestroy");
    }
}