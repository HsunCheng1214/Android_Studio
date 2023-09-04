package com.example.w12_209410314_mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener, View.OnClickListener {
    TextView rr; Button bt_pau,bt_st; CheckBox ck; MediaPlayer mp; Uri u, u_v;
    VideoView vv;
    MediaController mc; int pos=0, tot=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rr=(TextView) findViewById(R.id.res);
        bt_pau=(Button) findViewById(R.id.b1);
        bt_st=(Button) findViewById(R.id.b2);
        ck=(CheckBox) findViewById(R.id.ch1); ck.setChecked(false);
        mp=new MediaPlayer(); mp.setOnCompletionListener(this);
        mp.setOnPreparedListener(this); mp.setOnErrorListener(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);橫置
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//直置
        u= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.welcome);
        try{
            mp.setDataSource(this, u); mp.start();
        } catch (Exception e){
            Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
        }
        String ss="android.resource://"+getPackageName()+"/R.raw.welcome";
        rr.setText(getString(R.string.play)+ss); prep(); Log.d("test","after pre()");
        //bt_pau.setOnClickListener(this); bt_st.setOnClickListener(this);

        //video section
        vv=(VideoView) findViewById(R.id.video1);
        mc = new MediaController(this); vv.setMediaController(mc);

        u_v=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        try{
            vv.setVideoURI(u_v); tot=vv.getCurrentPosition();
            String s1="android.resource://"+getPackageName()+"/R.raw.video"+",total length="+tot;
            rr.setText(getString(R.string.play)+s1);
            vv.start();
//            Toast.makeText(this,"")
        } catch (Exception e){
            Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
        }
    }

    protected void onPause() {
        super.onPause();
        pos=vv.getCurrentPosition(); vv.stopPlayback();
    }

    protected void onResume() {
        super.onResume();
        vv.seekTo(pos); vv.start();
    }

    public void onClick(View view) {
        if(view == bt_pau){
//            if(mp.isPlaying()){
//                mp.pause(); bt_pau.setText(getString(R.string.cont));
//            } else {
//                mp.start(); bt_pau.setText(getString(R.string.pau));
//                bt_st.setEnabled(true);
//            }
//            vv.getCurrentPosition(); vv.setcurr; vv.seekTo(0); vv.start();
            pos = 0; onResume();
        }
        if(view == bt_st){
            //mp.pause(); mp.seekTo(0);
            //bt_pau.setText(getString(R.string.pl)); bt_st.setEnabled(false);
            onPause();
        }
        if(ck==view){
            if (ck.isChecked()) mp.setLooping(true); else mp.setLooping(false);
        }
    }
    void prep(){
        bt_pau.setText(getString(R.string.pl)); bt_pau.setEnabled(false); bt_st.setEnabled(false);
        try{
            mp.reset(); mp.setDataSource(this, u); mp.setLooping(ck.isChecked());
            mp.prepareAsync();
        } catch (Exception e){
            Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mp.seekTo(0); bt_pau.setText(getString(R.string.pl)); bt_st.setEnabled(false);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        Toast.makeText(this, getString(R.string.err),Toast.LENGTH_SHORT).show();
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) { bt_pau.setEnabled(true); }
}