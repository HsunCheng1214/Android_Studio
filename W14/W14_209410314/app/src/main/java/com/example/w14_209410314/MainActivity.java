package com.example.w14_209410314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText e1,e2; Button b1,b2; TextView rr,res; SharedPreferences sp; Date da;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.ed1);
        e2 = (EditText) findViewById(R.id.ed2);
        rr = (TextView) findViewById(R.id.rr);
        b1 = (Button) findViewById(R.id.b1); b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.b2); b2.setOnClickListener(this);
        sp = getSharedPreferences("test",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit(); da = new Date();
        String n = sp.getString("name", ""); int m = sp.getInt("money", 0);
        e1.setText(n); e2.setText(""+m);

        String dbname = "test", table="cust";
        res = (TextView) findViewById(R.id.res);
        SQLiteDatabase db=openOrCreateDatabase(dbname,MODE_PRIVATE, null);
        String sql="create table if not exists "+table+
                " (name varchar(32), phone varchar(16), "+"email varchar(32))";
        db.execSQL(sql);
        String ss = "db path:"+db.getPath()+"\ndb size:"+db.getMaximumSize()+"\ndb page size:"+
                db.getPageSize();
        res.setText(ss); db.close();
    }

    protected void onPause() { save(); super.onPause(); }
    protected void onResume() {
        SharedPreferences.Editor ed = sp.edit(); da = new Date();
        String n = sp.getString("name", ""); int m = sp.getInt("money", 0);
        e1.setText(n); e2.setText(""+m); rr.setText("date:" + da.toString());
        super.onResume();
    }

    public void save() {
        SharedPreferences.Editor ed=sp.edit();
        String s1=e1.getText().toString(), s2=e2.getText().toString();
        if(s1.length() > 0 && s2.length() > 0){
            String name=s1; int mon=Integer.parseInt(s2); da=new Date();
            ed.putString("name", name); ed.putInt("money", mon);
            if(ed.commit()) {
                Toast.makeText(this, getString(R.string.suc), Toast.LENGTH_SHORT).show();
                rr.setText(getString(R.string.str)+
                           getString(R.string.suc)+"\n"+ "date:" + da.toString()+"\n"+
                           getString(R.string.name)+":"+name+"\n"+
                           getString(R.string.money) +":"+s2);
            }
            else Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        if(view == b1) { save(); }
        if(view == b2){
            e1.setText(""); e2.setText(""); rr.setText(getString(R.string.str));
        }
    }
}