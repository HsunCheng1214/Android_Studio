package com.example.w4_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Compavg extends AppCompatActivity {

    Intent it; String id1="", na1=""; TextView rr1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compavg);
        it=getIntent();
        id1=it.getStringExtra("id");
        na1=it.getStringExtra("name");
        rr1=(TextView) findViewById(R.id.res1);
        String t1=getString(R.string.rev)+"\n"+
                getString(R.string.id)+":"+id1+"\n"+
                getString(R.string.na)+":"+na1+"\n";
        rr1.setText(t1);
        Toast.makeText(this, t1, Toast.LENGTH_SHORT).show();
    }
}