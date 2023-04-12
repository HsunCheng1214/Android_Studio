package com.example.w2_209410314;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogInterface.OnClickListener, DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener,
        DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener{

    Toast tos; Button b1; int i = 1; TextView rr, dt, tt; int yy=0,mm=0,dd=0,hh=0,m1=0; Time t;
    DatePicker dp; TimePicker tp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=new Time(); t.setToNow(); yy=t.year; mm=t.month; dd=t.monthDay; hh=t.hour; m1=t.minute;
        tos = Toast.makeText(this, getString(R.string.disp), Toast.LENGTH_SHORT);
        b1 = (Button) findViewById(R.id.b1); tos.show();
        b1.setOnClickListener(this);
        rr = (TextView) findViewById(R.id.res);
        dt = (TextView) findViewById(R.id.dt);
        tt = (TextView) findViewById(R.id.tt);
        dt.setOnClickListener(this);
        tt.setOnClickListener(this);
        new AlertDialog.Builder(this).setTitle(getString(R.string.qu)).
                setMessage(getString(R.string.ms)).setIcon(android.R.drawable.star_big_on)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.lk), this)
                .setNegativeButton(getString(R.string.ht), this)
                .setNeutralButton(getString(R.string.no), this)
                .show();
        dp = (DatePicker) findViewById(R.id.dp);
        tp = (TimePicker) findViewById(R.id.tp);
        dp.setOnDateChangedListener(this);
        tp.setOnTimeChangedListener(this);
    }

    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
        dt.setText(getString(R.string.dt)+ i +"/"+ (i1+1) +"/"+ i2);
    }

    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        tt.setText(getString(R.string.tt)+ i +":"+ i1);
    }

    public void onClick(View view) {
//        tos.setText("i="+(i++));
//        tos.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 50);
//        tos.show();
//        new AlertDialog.Builder(this).setTitle(getString(R.string.qu)).
//                setMessage(getString(R.string.ms)).setIcon(android.R.drawable.star_big_on)
//                .setCancelable(true)
//                .setPositiveButton(getString(R.string.lk), this)
//                .setNegativeButton(getString(R.string.ht), this)
//                .setNeutralButton(getString(R.string.no), this)
//                .show();
        if(view == b1){
            tos.setText("i=" + (i++));
            tos.setGravity(Gravity.TOP | Gravity.RIGHT,0,50);
            tos.show();
        }
        if(view == dt) new DatePickerDialog(this, this, yy,mm,dd).show();
        if(view == dt) new TimePickerDialog(this, this,  hh, m1,true).show();
    }

    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        dt.setText(getString(R.string.dt)+ i +"/"+ (i1+1) +"/"+ i2);
    }

    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        tt.setText(getString(R.string.tt)+ i +":"+ i1);
    }


    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == DialogInterface.BUTTON_POSITIVE)
            rr.setText(getString(R.string.ch) + getString(R.string.lk));
        if(i == DialogInterface.BUTTON_NEGATIVE)
            rr.setText(getString(R.string.ch) + getString(R.string.ht));
        if(i == DialogInterface.BUTTON_NEUTRAL)
            rr.setText(getString(R.string.ch) + getString(R.string.no));
    }
}