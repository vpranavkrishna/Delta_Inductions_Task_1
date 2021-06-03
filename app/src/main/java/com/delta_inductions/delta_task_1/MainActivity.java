package com.delta_inductions.delta_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   Button normal,hacker,hackerplus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        normal = findViewById(R.id.normal);
//        hacker = findViewById(R.id.hacker);
        hackerplus = findViewById(R.id.hackerplus);
//        normal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent( MainActivity.this , Normal.class);
//                startActivity(intent);
//            }
//        });
//        hacker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Hacker.class);
//                startActivity(intent);
//            }
//        });
        hackerplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Hackerplus.class);
                startActivity(intent);
            }
        });

    }
}