package com.example.w3_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String f[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test","Main_onCreate");
        Button b1=(Button)findViewById(R.id.b1); b1.setOnClickListener(this);
        f=new String[3]; f=getResources().getStringArray(R.array.eat);
        String ss="傳送資料如右:編號:2，身分:學生，愛吃:", s1="";
        for(int i=0 ; i<f.length ; i++)
            if(i==0) s1=f[i]; else s1+="、"+f[i];
        TextView rr=(TextView) findViewById(R.id.res); rr.  setText(ss+s1);
//        Toast.makeText(this, ""+f.length, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        Intent it=new Intent(this, Second2.class); startActivity(it);
        it.putExtra("編號",2);
        it.putExtra("身分","學生");
        it.putExtra("愛吃",f); startActivity(it);
    }

    protected void onStart(){
        super.onStart(); Log.d("test","Main_onStart");
    }
    protected void onResume(){
        super.onResume(); Log.d("test","Main_onResume");
    }
    protected void onPause(){
        super.onPause(); Log.d("test","Main_onPause");
    }
    protected void onStop(){
        super.onStop(); Log.d("test","Main_onStop");
    }
    protected void onDestroy(){
        super.onDestroy(); Log.d("test","Main_onDestroy");
    }
}