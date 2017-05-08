package com.example.davecomia.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Thursday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);

        //CLASS NAME
        final EditText etCN19 = (EditText) findViewById(R.id.etCN19);
        final EditText etCN20 = (EditText) findViewById(R.id.etCN20);
        final EditText etCN21 = (EditText) findViewById(R.id.etCN21);
        final EditText etCN22 = (EditText) findViewById(R.id.etCN22);
        final EditText etCN23 = (EditText) findViewById(R.id.etCN23);
        final EditText etCN24 = (EditText) findViewById(R.id.etCN24);

        //ROOM NUMBER
        final EditText etRN19 = (EditText) findViewById(R.id.etRN19);
        final EditText etRN20 = (EditText) findViewById(R.id.etRN20);
        final EditText etRN21 = (EditText) findViewById(R.id.etRN21);
        final EditText etRN22 = (EditText) findViewById(R.id.etRN22);
        final EditText etRN23 = (EditText) findViewById(R.id.etRN23);
        final EditText etRN24 = (EditText) findViewById(R.id.etRN24);

        final Button bsThursday = (Button) findViewById(R.id.bsThursday);

        bsThursday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent thuIntent = new Intent (Thursday.this, MainActivity.class);
                Thursday.this.startActivity(thuIntent);
            }
        });
    }
}
