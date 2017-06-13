package com.davecomia.sdpunihelpg5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MapMain extends AppCompatActivity {
    private Button bNorth;
    private Button bCentral;
    private Button bSouth;
    private ImageView imCampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_main);

        bNorth = (Button) findViewById(R.id.bNorth);
        bCentral = (Button) findViewById(R.id.bCentral);
        bSouth = (Button) findViewById(R.id.bSouth);
        imCampus = (ImageView) findViewById(R.id.imCampus);

        bNorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imCampus.setImageResource(R.drawable.north);
            }
        });
        bCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imCampus.setImageResource(R.drawable.city);
            }
        });
        bSouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imCampus.setImageResource(R.drawable.south);
            }
        });
    }
}
