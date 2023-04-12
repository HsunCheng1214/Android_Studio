package com.example.w6_209410314;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    String mem[]={"1.按下編輯備忘錄","2.長案可以清除備忘錄","3.","4.","5.","6."};
    ListView lv; TextView rr; ArrayAdapter<String> ad; String tt="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv); rr=(TextView) findViewById(R.id.res);
        lv.setOnItemClickListener(this); lv.setOnItemLongClickListener(this);
        ad=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mem);
        lv.setAdapter(ad);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, Menu.FIRST,0,getString(R.string.opt1));
        menu.add(0, Menu.FIRST+1,0,getString(R.string.opt2));
        menu.add(0, Menu.FIRST+2,1,getString(R.string.opt3));
        menu.add(0, Menu.FIRST+3,2,getString(R.string.opt4));
        menu.add(0, Menu.FIRST+4,3,getString(R.string.exit));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int i=item.getItemId();
        switch (i) {
            case Menu.FIRST: rr.setText(getString(R.string.sel)+getString(R.string.opt1)); break;
            case Menu.FIRST+1: rr.setText(getString(R.string.sel)+getString(R.string.opt2)); break;
            case Menu.FIRST+2: rr.setText(getString(R.string.sel)+getString(R.string.opt3)); break;
            case Menu.FIRST+3: rr.setText(getString(R.string.sel)+getString(R.string.opt4)); break;
            case Menu.FIRST+4: finish(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent it=new Intent(this, Edit.class); it.putExtra("內容",mem[i]);
        tt=mem[i]; rr.setText(getString(R.string.sel)+tt);
        startActivityForResult(it, i);
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            mem[requestCode]=data.getStringExtra("內容");
            ad.notifyDataSetChanged(); rr.setText(getString(R.string.sel)+mem[requestCode]);
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        mem[i]=(i+1)+"."; ad.notifyDataSetChanged(); return true;
    }
}