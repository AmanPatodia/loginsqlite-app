package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView wel;
    public static String nameextra="nameextra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         wel = (TextView) findViewById(R.id.welcome);
        String name= getIntent().getStringExtra(nameextra);
        wel.setText("Welcome you "+"\n"+name);

    }
}