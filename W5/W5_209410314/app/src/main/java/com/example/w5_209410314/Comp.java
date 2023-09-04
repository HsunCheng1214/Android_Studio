package com.example.w5_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Comp extends AppCompatActivity implements View.OnClickListener {

    TextView tv1; EditText ch,en,ed3; Button b2,bs,bc; String id,name,mo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp);
        tv1=(TextView) findViewById(R.id.tv1);
        Intent it=getIntent();
        id=it.getStringExtra("id");
        name=it.getStringExtra("na");
        mo=it.getStringExtra("memo");
        if(mo != null) setTitle(getString(R.string.m2));
        tv1.setText(getString(R.string.rr)+"\n" +
                    getString(R.string.id)+id+"\n" +
                    getString(R.string.na) + name + "\n");
        ch=(EditText)findViewById(R.id.ed_ch);
        en=(EditText)findViewById(R.id.ed_en);
        ed3=(EditText)findViewById(R.id.ed_memo); ed3.setText(mo);
        b2=(Button) findViewById(R.id.b2); b2.setOnClickListener(this);
        bs=(Button) findViewById(R.id.b_sure); bs.setOnClickListener(this);
        bc=(Button) findViewById(R.id.b_can); bc.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view == bc) finish();
        if(view == bs);
        if(view == b2){
            Intent it = new Intent(this, MainActivity.class);
            String ch_s = ch.getText().toString(),
                   en_s = en.getText().toString();
            if(ch_s.length() > 0 && en_s.length() > 0){
                double ch_n=Double.parseDouble(ch_s),
                       en_n=Double.parseDouble(en_s),
                        avg; avg=(ch_n + en_n)/2.0;
                String tmp = getString(R.string.id)+id+"\n"+
                             getString(R.string.na)+name+"\n"+
                             getString(R.string.ch)+ch_s+"\n"+
                             getString(R.string.en)+en_s+"\n"+
                             getString(R.string.av_s)+avg+"\n";
                Toast.makeText(this,tmp, Toast.LENGTH_SHORT).show();
                it.putExtra("avg", tmp); startActivity(it);
            } else Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
        }
    }
}