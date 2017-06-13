package com.example.alexg.uni_helper_aoo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // Dummy method
    public void goToDummyActivity(View view){
        Intent intent = new Intent(this, DummyActivity.class);  // Update the activity name
        startActivity(intent);
    }
/*
    // Starts the Profile Activity from the button pressed by the user
    public void goToProfileActivity(View view){
        Intent intent = new Intent(this, ProfileActivity.class);  // Update the activity name
        startActivity(intent);
    }

    // Starts the Timetable Activity from the button pressed by the user
    public void goToTimeTableActivity(View view){
        Intent intent = new Intent(this, TimetableActivity.class);      // Update the activity name
        startActivity(intent);
    }

    // Starts the Mailing Activity from the button pressed by the user
    public void goToMailingActivity(View view){
        Intent intent = new Intent(this, MailingActivity.class);        // Update the activity name
        startActivity(intent);
    }

    // Starts the Map Activity from the button pressed by the user
    public void goToMapActivity(View view){
        Intent intent = new Intent(this, MapActivity.class);        // Update the activity name
        startActivity(intent);
    }

    // Starts the Searching Activity from the button pressed by the user
    public void goToSearchActivity(View view){
        Intent intent = new Intent(this, SearchingActivity.class);      // Update the activity name
        startActivity(intent);
    }

    // Starts the User Settings Activity from the button pressed by the user
    public void goToUserSettingsActivity(View view){
        Intent intent = new Intent(this, UserSettingsActivity.class);   // Update the activity name
        startActivity(intent);
    }
    */
}
