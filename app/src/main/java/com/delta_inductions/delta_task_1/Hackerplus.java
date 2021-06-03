package com.delta_inductions.delta_task_1;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Hackerplus extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Hackerplus";
    private int no_of_times =1;
    private int what_color = 0;
    private ProgressBar progressbar;
    private TextView timer;
    private TextView wrong,correct;
    private CountDownTimer countDownTimer;
    private static final long START_IN_MILLIS = 30000;
    private long Timeleftinmillis = START_IN_MILLIS;
    private boolean isTimerRunning = false;
    private TextView date;
    private View view;
    private String day;
    private Button b1, b2, b3, b4;
    private String dateon;
    private String[] options = new String[4];
    private int score = 0;
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        date = findViewById(R.id.date);
        view = this.getWindow().getDecorView();
        Shuffle();
        progressbar= findViewById(R.id.progressbar);
        timer = findViewById(R.id.timer);
        wrong = findViewById(R.id.wrong);
        correct = findViewById(R.id.correct);
        progressbar.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        wrong.setVisibility(View.VISIBLE);
        correct.setVisibility(View.VISIBLE);
        progressbar.setMax(30);
        progressbar.setBackgroundColor(ContextCompat.getColor(this,R.color.theme));

        if(savedInstanceState!=null)
        {
            Timeleftinmillis = savedInstanceState.getLong("millisleft");
            isTimerRunning = savedInstanceState.getBoolean("millisleft");
            dateon = savedInstanceState.getString("date");
            date.setText(String.valueOf(dateon));
            day = savedInstanceState.getString("day");
            options = savedInstanceState.getStringArray("options");
            b1.setText(options[0]);
            b2.setText(options[1]);
            b3.setText(options[2]);
            b4.setText(options[3]);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = b1.getText().toString();
                    if (buttonText.equals(day)) {
                        score++;
                        shakeIt(50, -1);
                        view.setBackgroundResource(R.color.green);
                        Log.d(TAG, "onClick: score " + score);
                        Shuffle();

                    } else {

                        score--;
                        shakeIt(300, 10);
                        view.setBackgroundResource(R.color.red);
                        Shuffle();
                    }
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = b2.getText().toString();
                    if (buttonText.equals(day)) {
                        score++;
                        shakeIt(50, -1);
                        view.setBackgroundResource(R.color.green);
                        Log.d(TAG, "onClick: score " + score);
                        Shuffle();

                    } else {

                        score--;
                        shakeIt(300, 10);
                        view.setBackgroundResource(R.color.red);
                        Shuffle();
                    }
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = b3.getText().toString();
                    if (buttonText.equals(day)) {
                        score++;
                        shakeIt(50, -1);
                        view.setBackgroundResource(R.color.green);
                        Log.d(TAG, "onClick: score " + score);
                        Shuffle();

                    } else {

                        score--;
                        shakeIt(300, 10);
                        view.setBackgroundResource(R.color.red);
                        Shuffle();
                    }
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = b3.getText().toString();
                    if (buttonText.equals(day)) {
                        score++;
                        shakeIt(50, -1);
                        view.setBackgroundResource(R.color.green);
                        Log.d(TAG, "onClick: score " + score);
                        Shuffle();

                    } else {

                        score--;
                        shakeIt(300, 10);
                        view.setBackgroundResource(R.color.red);
                        Shuffle();
                    }
                }
            });


            }

        if(isTimerRunning)
        {
            pauseTimer();
        }
        else
        {
            startTimer(0);
        }
        updateTimer();
        }

    //function to get random date and to get the corresponding day
    public void Shuffle() {

        RandomDate.randomDate();
        dateon = RandomDate.getDate();
        day = RandomDate.getDay();
        date.setText(dateon);
        Integer[] arr = new Integer[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Collections.shuffle(Arrays.asList(arr));
        ArrayList<String> arl = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            if (!day.equals(days[i])) {
                arl.add(days[i]);
            }
        }

        Log.d(TAG, "Shuffle: date and day are   " + " " +dateon + " "+  day);


        for (int i = 0; i < options.length; i++) {
            options[i] = arl.get(i);
            if (i == 3) {
                options[i] = day;
            }
        }

        Collections.shuffle((Arrays.asList(options)));

        Log.d(TAG, "options" + Arrays.toString(options));
        b1 = findViewById(R.id.B1);
        b2 = findViewById(R.id.B2);
        b3 = findViewById(R.id.B3);
        b4 = findViewById(R.id.B4);

        b1.setText(options[0]);
        b2.setText(options[1]);
        b3.setText(options[2]);
        b4.setText(options[3]);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    //on click listener
    public void onClick(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        if (buttonText.equals(day)) {
            score++;
            shakeIt(50,-1);
            view.setBackgroundResource(R.color.green);
            Log.d(TAG, "onClick: score " + score);
            Shuffle();

        }
        else
            {

            score--;
            shakeIt(300,10);
            view.setBackgroundResource(R.color.red);
            Shuffle();
            pauseTimer();
            startTimer(5000);
            }


        }

// function for haptic touch response
        private void shakeIt(int time,int amp)
        {
            if (Build.VERSION.SDK_INT >= 26) {
                ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(time,amp));
            } else {
                ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(time);
            }
        }


    private void startTimer(int loss)

    {
        countDownTimer = new CountDownTimer(Timeleftinmillis-loss,1000) {
            @Override

            public void onTick(long millisUntilFinished) {
                Timeleftinmillis = millisUntilFinished;
                updateTimer();
                if(Timeleftinmillis == 0)
                    no_of_times =2;
            }

            @Override
            public void onFinish() {
                timer.setText("TIME UP");
                progressbar.setProgress(0);
                    if(no_of_times==1) {
                        Intent intent = new Intent(Hackerplus.this, Score.class);
                        intent.putExtra("score", score);
                        startActivity(intent);
                        finish();
                    }

            }
        }.start();

}
 private void updateTimer()
 {
     timer.setText("TIME REMAINING" + Timeleftinmillis/1000);
     progressbar.setProgress((int) Timeleftinmillis/1000);
 }
 private void pauseTimer()
 {
     countDownTimer.cancel();
     isTimerRunning = false;
 }
 private void resetTimer()
 {
     Timeleftinmillis = START_IN_MILLIS;
     updateTimer();
 }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("date",dateon);
        //outState.getBundle("color",ContextCompat.getColor(this,R.color.red))
        outState.putString("day",day);
        outState.putStringArray("options",options);
        outState.putBoolean("timerRunning",isTimerRunning);
        outState.putLong("millisleft",Timeleftinmillis);
    }

}

