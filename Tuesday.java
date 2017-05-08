package com.example.davecomia.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tuesday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);

        //CLASS NAME
        final EditText etCN7 = (EditText) findViewById(R.id.etCN7);
        final EditText etCN8 = (EditText) findViewById(R.id.etCN8);
        final EditText etCN9 = (EditText) findViewById(R.id.etCN9);
        final EditText etCN10 = (EditText) findViewById(R.id.etCN10);
        final EditText etCN11 = (EditText) findViewById(R.id.etCN11);
        final EditText etCN12 = (EditText) findViewById(R.id.etCN12);

        //ROOM NUMBER
        final EditText etRN7 = (EditText) findViewById(R.id.etRN7);
        final EditText etRN8 = (EditText) findViewById(R.id.etRN8);
        final EditText etRN9 = (EditText) findViewById(R.id.etRN9);
        final EditText etRN10 = (EditText) findViewById(R.id.etRN10);
        final EditText etRN11 = (EditText) findViewById(R.id.etRN11);
        final EditText etRN12 = (EditText) findViewById(R.id.etRN12);

        final Button bsTuesday = (Button) findViewById(R.id.bsTuesday);

        bsTuesday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tueIntent = new Intent (Tuesday.this, MainActivity.class);
                Tuesday.this.startActivity(tueIntent);
            }
        });
    }
}
