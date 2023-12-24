package com.example.myfirstfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Load FragmentA by default
        loadFragment(new FragmentA());
//        loadFragment(new FragmentA());

        // Button to switch to FragmentA
        Button btnFragmentA = findViewById(R.id.btnFragmentA);
        btnFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FragmentA());
            }
        });

        // Button to switch to FragmentB
        Button btnFragmentB = findViewById(R.id.btnFragmentB);
        btnFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FragmentB());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // Replace the current fragment with the new one
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}