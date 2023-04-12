package com.example.w5_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    EditText e1,e2; TextView rr; Button b1; ListView lv;
    String memo[]={"1.點一下修改","2.長按清除","3.","4.","5.","6."};
    ArrayAdapter<String> ad;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.ed1);
        e2=(EditText) findViewById(R.id.ed2);
        b1=(Button) findViewById(R.id.b1); b1.setOnClickListener(this);
        rr=(TextView) findViewById(R.id.tv1);
        Intent it=getIntent();
        String tt=it.getStringExtra("avg");
        Toast.makeText(this, "tt="+tt,Toast.LENGTH_SHORT).show();
        if(tt != null) rr.setText(getString(R.string.rr)+"\n"+tt);
        lv=(ListView) findViewById(R.id.lv);
        ad=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, memo);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        setTitle(getString(R.string.m1));
        Intent it=new Intent(this, Comp.class);
        it.putExtra("memo", memo[i]);
        startActivity(it);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        setTitle(getString(R.string.m1));
        memo[i]=(i+1)+"."; ad.notifyDataSetChanged(); return true;
    }

    public void onClick(View view) {
        if(view == b1){
            Intent it = new Intent(this, Comp.class);
            String id=e1.getText().toString(), name=e2.getText().toString();
            if(id.length() > 0 && name.length() > 0){
                it.putExtra("id", id);
                it.putExtra("na", name);
                startActivity(it);
            }
            else Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
        }
    }


}