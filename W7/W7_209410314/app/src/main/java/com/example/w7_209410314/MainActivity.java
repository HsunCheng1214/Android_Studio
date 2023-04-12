package com.example.w7_209410314;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView rr; EditText e1,e2,sel; String cp="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rr=(TextView) findViewById(R.id.res);
        e1=(EditText)findViewById(R.id.ed1); registerForContextMenu(e1);
        e2=(EditText)findViewById(R.id.ed2); registerForContextMenu(e2);
    }

    void showset(){
        Intent it=new Intent(Settings.ACTION_SETTINGS);
        startActivity(it);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.my, menu); sel=(EditText)v;
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.copy) { cp=sel.getText().toString(); rr.setText(cp); }
        if (item.getItemId()==R.id.paste) { if(cp.length() > 0) sel.setText(cp); }
        return super.onContextItemSelected(item);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.yang) rr.setText(getString(R.string.yang));
        if(item.getItemId()==R.id.yu) rr.setText(getString(R.string.yu));
        if(item.getItemId()==R.id.tai) rr.setText(getString(R.string.tai));
        if(item.getItemId()==R.id.loc) rr.setText(getString(R.string.loc));
        if(item.getItemId()==R.id.set){
            rr.setText(getString(R.string.set)); showset();
        }
        if(item.getItemId()==R.id.exit) finish();

        return super.onOptionsItemSelected(item);
    }


}