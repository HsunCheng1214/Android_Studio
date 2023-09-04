package com.example.w2_209410314_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogInterface.OnClickListener {

    Toast tos; Button b1; int i=1; TextView rr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tos = Toast.makeText(this, getString(R.string.disp), Toast.LENGTH_SHORT);
        b1=(Button) findViewById(R.id.b1); tos.show(); b1.setOnClickListener(this);
        rr=(TextView) findViewById(R.id.res);
        new AlertDialog.Builder(this).setTitle(getString(R.string.qu)).
            setMessage(getString(R.string.ms)).setIcon(android.R.drawable.star_big_on).
            setCancelable(false).setPositiveButton(getString(R.string.lk), this).
            setNegativeButton(getString(R.string.ht), this).
            setNeutralButton(getString(R.string.no), this).
            show();
    }

    public void onClick(View view) {
        tos.setText("i+"+(i++));
        tos.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 50); tos.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if(i==DialogInterface.BUTTON_POSITIVE)
            rr.setText(getString(R.string.ch)+getString(R.string.lk));
        if(i==DialogInterface.BUTTON_NEGATIVE)
            rr.setText(getString(R.string.ch)+getString(R.string.ht));
        if(i==DialogInterface.BUTTON_NEUTRAL)
            rr.setText(getString(R.string.ch)+getString(R.string.no));
    }
}