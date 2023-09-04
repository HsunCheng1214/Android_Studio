package com.example.w3_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Third3 extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third3);
        setTitle(getString(R.string.act3_title));
        Log.d("test", "Third_onCreate");
        Button b4=(Button) findViewById(R.id.b4);
        b4.setOnClickListener(this);
    }
    public void onClick(View view) {
        finish();
    }
    protected void onStart(){
        super.onStart(); Log.d("test","Third3_onStart");
    }
    protected void onResume(){
        super.onResume(); Log.d("test","Third3_onResume");
    }
    protected void onPause(){
        super.onPause(); Log.d("test","Third3_onPause");
    }
    protected void onStop(){
        super.onStop(); Log.d("test","Third3_onStop");
    }
    protected void onDestroy(){
        super.onDestroy(); Log.d("test","Third_onDestroy");
    }
}