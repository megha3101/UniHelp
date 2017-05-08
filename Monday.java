package com.example.davecomia.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Monday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        //CLASS NAME
        final EditText etCN1 = (EditText) findViewById(R.id.etCN1);
        final EditText etCN2 = (EditText) findViewById(R.id.etCN2);
        final EditText etCN3 = (EditText) findViewById(R.id.etCN3);
        final EditText etCN4 = (EditText) findViewById(R.id.etCN4);
        final EditText etCN5 = (EditText) findViewById(R.id.etCN5);
        final EditText etCN6 = (EditText) findViewById(R.id.etCN6);

        //ROOM NUMBER
        final EditText etRN1 = (EditText) findViewById(R.id.etRN1);
        final EditText etRN2 = (EditText) findViewById(R.id.etRN2);
        final EditText etRN3 = (EditText) findViewById(R.id.etRN3);
        final EditText etRN4 = (EditText) findViewById(R.id.etRN4);
        final EditText etRN5 = (EditText) findViewById(R.id.etRN5);
        final EditText etRN6 = (EditText) findViewById(R.id.etRN6);

        final Button bsMonday = (Button) findViewById(R.id.bsMonday);

        bsMonday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent monIntent = new Intent (Monday.this, MainActivity.class);
                Monday.this.startActivity(monIntent);
            }
        });


    }
}
