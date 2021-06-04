package com.delta_inductions.delta_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   Button hackerplus;
   TextView highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hackerplus = findViewById(R.id.hackerplus);
        highscore = findViewById(R.id.highscorelayout);
        SharedPreferences prefs=getApplicationContext().getSharedPreferences("guess",MODE_PRIVATE);
        SharedPreferences.Editor editor =prefs.edit();
        highscore.setText("HIGHSCORE:"+" "+ prefs.getInt("Highscore",0));
        hackerplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Hackerplus.class);
                startActivity(intent);
            }
        });

    }
}