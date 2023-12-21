package com.example.gridviewcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText sphere_radius;
    TextView title, result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sphere_radius = findViewById(R.id.editText_sphere);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                int receivedNumber = intent.getIntExtra("position", 0); // 0 is the default value if the key is not found


                String radius = sphere_radius.getText().toString();
                int r = Integer.parseInt(radius);
                double volume = 0;
                int number = receivedNumber;
                switch (number) {
                    case 0:
                        // V = (4/3) * pi * r^3
                        Toast.makeText(MainActivity2.this, "sphere", Toast.LENGTH_SHORT).show();
                        volume = (4/3) * 3.14159 * r*r*r;
                        break;
                    case 1:
                        //V=πr2h
                        //H will be constant for now
                        Toast.makeText(MainActivity2.this, "cylinder", Toast.LENGTH_SHORT).show();
                        volume = 3.14159 * r * r * 10;
                        break;
                    case 2:
                        Toast.makeText(MainActivity2.this, "cube", Toast.LENGTH_SHORT).show();
                        volume = r * r * r;
                        break;
                    case 3:
                        volume = r;
                        Toast.makeText(MainActivity2.this, "prism", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        System.out.println("Invalid day of the week");
                }
                // Display the number in the TextView
                result.setText("V = " + volume+" m^3");
            }
        });
    }
}