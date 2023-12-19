package com.example.sharerandomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    //textView2
    //textView3
    //btm

    TextView textView2, textView3;
    Button btm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        btm = findViewById(R.id.btm);

        //how to receive intents
        Intent intention = getIntent();
        String username = intention.getStringExtra("name");

        //show the random number
        int yourLuckyNum = generateRandom();
        textView3.setText(""+yourLuckyNum);

        //share result to email by clicking button
        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareDate(username, yourLuckyNum);
            }
        });
    }
    public int generateRandom(){
        Random random = new Random();
        int maxNum = 10000;
        int getNum = random.nextInt(maxNum);
        return getNum;
    }
    public void shareDate(String username, int luckyNum){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: " + luckyNum);
        startActivity(Intent.createChooser(i, "choose a platform"));
    }
}