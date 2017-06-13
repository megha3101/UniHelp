package com.davecomia.sdpunihelpg5;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenu extends AppCompatActivity {
    private static final String TAG = "MainMenu";
    private TextView tvWelcome;
    private TextView tvID;
    private Button bSearch;
    private Button bChat;
    private Button bPlanner;
    private Button bMap;
    private Button bLogout;
    private Button bSettings;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvID = (TextView) findViewById(R.id.tvID);
        bSearch = (Button) findViewById(R.id.bSearch);
        bChat = (Button) findViewById(R.id.bChat);
        bPlanner = (Button) findViewById(R.id.bPlanner);
        bMap = (Button) findViewById(R.id.bMap);
        bLogout = (Button) findViewById(R.id.bLogout);
        bSettings = (Button) findViewById(R.id.bSettings);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            tvWelcome.append(" " + name);
            tvID.append("Email: " + user.getEmail());
        }

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainMenu.this, "Search! Please code me!", Toast.LENGTH_LONG).show();
            }
        });

        bChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainMenu.this, "Chat! Please code me!", Toast.LENGTH_LONG).show();
            }
        });

        bPlanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainMenu.this, "Planner! Please code me!", Toast.LENGTH_LONG).show();
            }
        });

        bMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(MainMenu.this, MapMain.class);
                MainMenu.this.startActivity(mapIntent);
            }
        });

        bSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainMenu.this, "Settings! Please code me!", Toast.LENGTH_LONG).show();
            }
        });

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainMenu.this, "Logout! Please code me!", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
