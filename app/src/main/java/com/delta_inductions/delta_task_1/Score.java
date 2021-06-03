
package com.delta_inductions.delta_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private TextView Highscore;
    private TextView Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Highscore = findViewById(R.id.highscore);
        Score = findViewById(R.id.currentscore);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);
        SharedPreferences prefs=getApplicationContext().getSharedPreferences("guess",MODE_PRIVATE);
        SharedPreferences.Editor editor =prefs.edit();
        int newhighscore = prefs.getInt("Highscore",score);
        if(score>=newhighscore)
        {
            editor.putInt("Highscore",score);
            editor.apply();
            Highscore.setText(String.valueOf(score));

        }

        else {
            Highscore.setText(String.valueOf(newhighscore));

        }
        Score.setText(String.valueOf(score));


    }
    @Override
    public void onBackPressed()
    {
       Intent intent = new Intent(this,MainActivity.class);
       startActivity(intent);
     }

    }

