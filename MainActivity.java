package com.example.davecomia.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bMonday = (Button) findViewById(R.id.bMonday);
        final Button bTuesday = (Button) findViewById(R.id.bTuesday);
        final Button bWednesday = (Button) findViewById(R.id.bWednesday);
        final Button bThursday = (Button) findViewById(R.id.bThursday);
        final Button bFriday = (Button) findViewById(R.id.bFriday);

        bMonday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent monIntent = new Intent (MainActivity.this, Monday.class);
                MainActivity.this.startActivity(monIntent);
            }
        });

        bTuesday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tueIntent = new Intent (MainActivity.this, Tuesday.class);
                MainActivity.this.startActivity(tueIntent);
            }
        });

        bWednesday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent wedIntent = new Intent (MainActivity.this, Wednesday.class);
                MainActivity.this.startActivity(wedIntent);
            }
        });

        bThursday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent thuIntent = new Intent (MainActivity.this, Thursday.class);
                MainActivity.this.startActivity(thuIntent);
            }
        });

        bFriday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent FriIntent = new Intent (MainActivity.this, Friday.class);
                MainActivity.this.startActivity(FriIntent);
            }
        });


    }
}
