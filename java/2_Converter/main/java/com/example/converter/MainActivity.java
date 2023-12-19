package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView header1, header2;
    Button btn, btm;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header1 = findViewById(R.id.headerTitle);
        header2 = findViewById(R.id.textView2);
        btn = findViewById(R.id.button);
        btm = findViewById(R.id.buttom);
        editText = findViewById(R.id.editText);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input = editText.getText().toString();
                    double finalType = Double.parseDouble(input);
                    double getAns = calcKm(finalType);
                    header2.setText("" + getAns);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "input is empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input = editText.getText().toString();
                    double finalType = Double.parseDouble(input);
                    double getAns = calcM(finalType);
                    header2.setText("" + getAns);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "input is empty", Toast.LENGTH_LONG).show();
                }

            }
        });



    }

    public double calcKm(double km){
        return 1.60934 * km;
    }
    public double calcM(double m){
        return 1609.34 * m;
    }
}