package com.example.p1pg1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtVer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        txtVer = (TextView)findViewById(R.id.txt_Ver);

        String dato = getIntent().getStringExtra("dato");

        txtVer.setText("Hola "+dato);
    }
}