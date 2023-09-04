package com.example.w1_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {
    Spinner s1,s2,s3; TextView rr; Button b1,b2;
    String dr[]={"珍珠奶茶","波霸奶茶","仙草奶茶","檸檬汁"};
    String ice[]={"冰","去冰"}, wm[]={"冰","去冰","溫"};
    String sg1[]={"半糖","無糖"}, sg2[]={"一般","半糖"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.b1); b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.b2); b2.setOnClickListener(this);
        s1=(Spinner) findViewById(R.id.sp1); s1.setOnItemSelectedListener(this);
        s2=(Spinner) findViewById(R.id.sp2); s2.setOnItemSelectedListener(this);
        s3=(Spinner) findViewById(R.id.sp3); s3.setOnItemSelectedListener(this);
        rr=(TextView) findViewById(R.id.res);
    }

    public void onClick(View view) {
        if(view == b1)
            rr.setText(getString(R.string.res)+":"+
                    s1.getSelectedItem()+s2.getSelectedItem()+s3.getSelectedItem());
        if(view == b2) rr.setText(getString(R.string.res));
    }


    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView == s1){
            String tmp[] = {}, tmp2[]={};
            String ice[] = getResources().getStringArray(R.array.ice);
            String wm[] = getResources().getStringArray(R.array.wm);
            String sg1[] = getResources().getStringArray(R.array.sg1);
            String sg2[] = getResources().getStringArray(R.array.sg2);
            if(i == 3) {tmp = ice; tmp2=sg2;} else {tmp = wm; tmp2=sg1;}
            ArrayAdapter<String> ad=new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, tmp);
            s2.setAdapter(ad);
            ArrayAdapter<String> ad1=new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, tmp2);
            s3.setAdapter(ad1);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}