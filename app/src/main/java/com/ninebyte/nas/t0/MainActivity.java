package com.ninebyte.nas.t0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //hhhhhhhhhhhhhhhhhhhhhhh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.getCount();

        Button btn = new Button(this);
    }
}
