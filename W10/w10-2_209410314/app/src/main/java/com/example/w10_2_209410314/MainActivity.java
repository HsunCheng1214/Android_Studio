package com.example.w10_2_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    TabHost th; TextView r1, r2, r3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        th=(TabHost) findViewById(R.id.tabmenu);
        r1=(TextView) findViewById(R.id.r1);
        r2=(TextView) findViewById(R.id.r2);
        r3=(TextView) findViewById(R.id.r3);
        th.setup();
        th.addTab(th.newTabSpec("one").
                setIndicator(getString(R.string.red)).setContent(R.id.tab1));
        th.addTab(th.newTabSpec("two").
                setIndicator(getString(R.string.green)).setContent(R.id.tab2));
        th.addTab(th.newTabSpec("three").
                setIndicator(getString(R.string.blue)).setContent(R.id.tab3));
        th.setOnTabChangedListener(this);
    }

    public void onTabChanged(String s) {
        if(s.equals("one")) r1.setText(getString(R.string.r1)+getString(R.string.red));
        if(s.equals("two")) r2.setText(getString(R.string.r2)+getString(R.string.green));
        if(s.equals("three")) r3.setText(getString(R.string.r3)+getString(R.string.blue));
    }
}