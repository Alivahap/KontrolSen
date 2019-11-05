package com.example.programatik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tx;
Database db;
    puan p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx=findViewById(R.id.text);

  p = new puan("100");

 db.PuanEkle(p);
       // p.getPuan() )
//db.PuanOku(p);
int x=Integer.parseInt("15") ;
tx.setText(""+x);


    }
}
