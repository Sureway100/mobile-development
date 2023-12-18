package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView myText;
    EditText myEdit;
    Button myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textView
        //editText
        //button

        myText = findViewById(R.id.textView);
        myEdit = findViewById(R.id.editText);
        myBtn = findViewById(R.id.button);

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = myEdit.getText().toString();
                Toast.makeText(MainActivity.this, "Good day " + name + " welcome to my first app", Toast.LENGTH_LONG).show();
            }
        });

    }
}