package com.example.my_application_w15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String db_name="test", db_table="custom"; TextView rr; SQLiteDatabase db;
    String[] field={"name","phone","email"}; EditText na,ph,em; Button b1,b2,b3,b4; Cursor cur=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rr=(TextView) findViewById(R.id.rr);
        b1=(Button) findViewById(R.id.b1); b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.b2); b2.setOnClickListener(this);
        b3=(Button) findViewById(R.id.b3); b3.setOnClickListener(this);
        b4=(Button) findViewById(R.id.b4); b4.setOnClickListener(this);
         na=(EditText) findViewById(R.id.ed_na);
        ph=(EditText) findViewById(R.id.ed_ph);
        em=(EditText) findViewById(R.id.ed_em);
        db=openOrCreateDatabase(db_name, MODE_PRIVATE, null);
        String sql="create table if not exists "+db_table+
                "("+field[0]+" varchar(16), "+field[1]+" varchar(16), "+field[2]+" varchar(32));";
        db.execSQL(sql);
        String tmp=db.getPath()+"\n"+db.getMaximumSize()+"\n"+db.getPageSize();
        rr.setText(tmp);
        disp_data();
    }
    public void disp_data(){
        String sql = "select * from " + db_table;
        cur = db.rawQuery(sql,null);
        int cnt = cur.getCount(), i=0; String t1="";
        t1=getString(R.string.tot)+cur.getCount()+getString(R.string.data)+"\n";
        t1+= cur.getColumnName(0)+"\t\t\t"+cur.getColumnName(1)+
                                     "\t\t\t"+cur.getColumnName(2)+"\n";
        t1+="--------------------------------------------------------------\n";
        if(cur.moveToFirst()){
            do{
                t1+=cur.getString(0)+"\t\t\t"+
                        cur.getString(1)+"\t\t\t"+
                        cur.getString(2)+"\n";
                t1+="--------------------------------------------------------------\n";
            } while (cur.moveToNext());
        }
        else Toast.makeText(this, getString(R.string.err), Toast.LENGTH_SHORT).show();
        rr.setText(t1);
    }

    public void add_data(String n, String p, String e){
        ContentValues cv=new ContentValues(3);
        cv.put(field[0], n); cv.put(field[1], p); cv.put(field[2],e);
        db.insert(db_table, null, cv); disp_data();
        Toast.makeText(this,getString(R.string.succ),Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        if(view == b4){
            String sql="create table if not exists "+db_table+
                "("+field[0]+" varchar(16), "+field[1]+" varchar(16), "+field[2]+" varchar(32));";
            db.execSQL(sql); disp_data();
        }
        if(view == b3){
            String sql="drop table if exists "+db_table; db.execSQL(sql);
        }
        if(view == b2){ db.close(); finish(); }
        if(view == b1){
            String sn=na.getText().toString(),
                    sp=ph.getText().toString(),
                    se=em.getText().toString();
            if(sn.length()>0 && sp.length()>0 && se.length()>0){
                add_data(sn, sp, se);
            }
            else Toast.makeText(this,getString(R.string.err),Toast.LENGTH_SHORT).show();
        }
    }
}