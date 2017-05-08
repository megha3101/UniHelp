package com.example.davecomia.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Friday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);

        //CLASS NAME
        final EditText etCN25 = (EditText) findViewById(R.id.etCN25);
        final EditText etCN26 = (EditText) findViewById(R.id.etCN26);
        final EditText etCN27 = (EditText) findViewById(R.id.etCN27);
        final EditText etCN28 = (EditText) findViewById(R.id.etCN28);
        final EditText etCN29 = (EditText) findViewById(R.id.etCN29);
        final EditText etCN30 = (EditText) findViewById(R.id.etCN30);

        //ROOM NUMBER
        final EditText etRN25 = (EditText) findViewById(R.id.etRN25);
        final EditText etRN26 = (EditText) findViewById(R.id.etRN26);
        final EditText etRN27 = (EditText) findViewById(R.id.etRN27);
        final EditText etRN28 = (EditText) findViewById(R.id.etRN28);
        final EditText etRN29 = (EditText) findViewById(R.id.etRN29);
        final EditText etRN30 = (EditText) findViewById(R.id.etRN30);

        final Button bsFriday = (Button) findViewById(R.id.bsFriday);

        bsFriday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent friIntent = new Intent (Friday.this, MainActivity.class);
                Friday.this.startActivity(friIntent);
            }
        });
    }
}
