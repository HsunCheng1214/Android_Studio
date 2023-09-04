package com.example.w11_209410314_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp; Button b_start, b_stop, b_rest, b_pau;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//水平
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//垂直
        //mp=MediaPlayer.create(this,R.raw.welcome);
        //mp.setLooping(true);
        //mp.start();
        mp=new MediaPlayer(); prep();
        b_start=(Button) findViewById(R.id.b1); b_start.setOnClickListener(this);
        b_pau=(Button)   findViewById(R.id.b2); b_pau  .setOnClickListener(this);
        b_rest=(Button)  findViewById(R.id.b3); b_rest .setOnClickListener(this);
        b_stop=(Button)  findViewById(R.id.b4); b_stop .setOnClickListener(this);
    }
    void prep(){
        try{
            Uri u= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.welcome);
            mp.setDataSource(this,u); mp.prepare();
            Toast.makeText(this,getPackageName(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) { System.out.println("error"); }
    }
    public void onClick(View view) {
        if(view == b_start) { mp.start(); }
        if(view == b_pau) { mp.pause(); }
        if(view == b_rest) { prep(); mp.start(); }
        if(view == b_stop) { mp.stop(); mp.reset(); prep(); }
    }

    protected void onPause() { super.onPause(); }
    protected void onResume() { super.onResume(); }
    protected void onDestroy() { super.onDestroy(); /*mp.stop(); mp.release();*/ }

}