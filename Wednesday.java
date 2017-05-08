package com.example.davecomia.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Wednesday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);

        //CLASS NAME
        final EditText etCN13 = (EditText) findViewById(R.id.etCN13);
        final EditText etCN14 = (EditText) findViewById(R.id.etCN14);
        final EditText etCN15 = (EditText) findViewById(R.id.etCN15);
        final EditText etCN16 = (EditText) findViewById(R.id.etCN16);
        final EditText etCN17 = (EditText) findViewById(R.id.etCN17);
        final EditText etCN18 = (EditText) findViewById(R.id.etCN18);

        //ROOM NUMBER
        final EditText etRN13 = (EditText) findViewById(R.id.etRN13);
        final EditText etRN14 = (EditText) findViewById(R.id.etRN14);
        final EditText etRN15 = (EditText) findViewById(R.id.etRN15);
        final EditText etRN16 = (EditText) findViewById(R.id.etRN16);
        final EditText etRN17 = (EditText) findViewById(R.id.etRN17);
        final EditText etRN18 = (EditText) findViewById(R.id.etRN18);

        final Button bsWednesday = (Button) findViewById(R.id.bsWednesday);

        bsWednesday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent wedIntent = new Intent (Wednesday.this, MainActivity.class);
                Wednesday.this.startActivity(wedIntent);
            }
        });
    }
}
