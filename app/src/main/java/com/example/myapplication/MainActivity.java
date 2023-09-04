package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
    PopupMenu.OnMenuItemClickListener{

    TextView r1,r2; Button b1; EditText e1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=(TextView) findViewById(R.id.res1);
        r2=(TextView) findViewById(R.id.res2);
        b1=(Button) findViewById(R.id.b1);
        e1=(EditText) findViewById(R.id.ed1);
        b1.setOnClickListener(this);
    }

    public void onClick(View view) {
        PopupMenu pop=new PopupMenu(this, b1);
        MenuInflater me=pop.getMenuInflater();
        me.inflate(R.menu.popup, pop.getMenu());
        pop.setOnMenuItemClickListener(this);
        pop.show();
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        String ss=e1.getText().toString();
        if(ss.length() > 0){
            if(menuItem.getItemId()==R.id.dis1) r1.setText(ss);
            if(menuItem.getItemId()==R.id.dis2) r2.setText(ss);
        }
        return true;
    }
}