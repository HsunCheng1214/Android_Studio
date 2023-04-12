package com.example.w6_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity implements View.OnClickListener {

    EditText e1; Button b_s, b_c; Intent it; String tmp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        e1=(EditText) findViewById(R.id.ed1);
        b_s=(Button) findViewById(R.id.b_sure); b_s.setOnClickListener(this);
        b_c=(Button) findViewById(R.id.b_can); b_c.setOnClickListener(this);
        it=getIntent(); String tmp=it.getStringExtra("內容");
        e1.setText(tmp);
    }

    public void onClick(View view) {
        if(view == b_c) { setResult(RESULT_CANCELED); finish();}
        if(view == b_s) {
            Intent it1=new Intent(); tmp=e1.getText().toString();
            it1.putExtra("內容",tmp);
            setResult(RESULT_OK, it1); finish();
        }
    }
}