package com.example.hwt3314.maps;

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

        Button north_campus = (Button)findViewById (R.id.top);
        Button city_campus = (Button)findViewById(R.id.up);
        Button south_campus = (Button)findViewById(R.id.all);


        north_campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in1 = new Intent(MainActivity.this, NORTH_CAMPUS.class);
                startActivity(in1);

            }
        });
        city_campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in2 = new Intent(MainActivity.this, CITY_CAMPUS.class);
                startActivity(in2);

            }
        });

        south_campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in3 = new Intent(MainActivity.this, SOUTH_CAMPUS.class);
                startActivity(in3);

            }
        });



    }


}
