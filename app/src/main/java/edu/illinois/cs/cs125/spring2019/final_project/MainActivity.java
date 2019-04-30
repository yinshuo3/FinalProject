package edu.illinois.cs.cs125.spring2019.final_project;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.EditText;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Final Project";

    private long timer = 0;
    private long timeleft = 0;
    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        EditText input_window = findViewById(R.id.input_window);
        TextView study = findViewById(R.id.textView);
        study.setVisibility(View.INVISIBLE);
        TextView giveup = findViewById(R.id.textView2);
        giveup.setVisibility(View.INVISIBLE);
        Button button4 = findViewById(R.id.button4);
        ProgressBar bar = findViewById(R.id.progressBar1);
        bar.setMax(100);
        bar.setProgress(100);
        bar.setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setVisibility(View.VISIBLE);
        final Button cancel = findViewById(R.id.button5);
        cancel.setVisibility(View.INVISIBLE);
        button1.setOnClickListener((v) -> {
            timer = 900000;
            study.setVisibility(View.VISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            giveup.setVisibility(View.INVISIBLE);
            cancel.setVisibility(View.VISIBLE);
            startTimer();
        });
        button2.setOnClickListener((v) -> {
            timer = 1200000;
            study.setVisibility(View.VISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            giveup.setVisibility(View.INVISIBLE);
            cancel.setVisibility(View.VISIBLE);
            startTimer();
        });
        button3.setOnClickListener((v) -> {
            timer = 1800000;
            study.setVisibility(View.VISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            giveup.setVisibility(View.INVISIBLE);
            cancel.setVisibility(View.VISIBLE);
            startTimer();
        });
       button4.setOnClickListener((v) -> {
          Long time = Long.parseLong(input_window.getText().toString());
          timer = time * 1000 * 60;
          study.setVisibility(View.VISIBLE);
           button1.setVisibility(View.INVISIBLE);
           button2.setVisibility(View.INVISIBLE);
           button3.setVisibility(View.INVISIBLE);
           button4.setVisibility(View.INVISIBLE);
           giveup.setVisibility(View.INVISIBLE);
           cancel.setVisibility(View.VISIBLE);
          startTimer();
        });
    }
    public void startTimer() {
        if (timeleft != 0) {
            return;
        }
        final ProgressBar bar = findViewById(R.id.progressBar1);
        final TextView textView = findViewById(R.id.textView);
        textView.setVisibility(View.VISIBLE);
        final Button cancel = findViewById(R.id.button5);
        bar.setMax((int) timer);
        timeleft = new Long(timer);
        final CountDownTimer countDownTimer = new CountDownTimer(timer, 1000) {
            @Override
            public void onTick(long l) {
                timeleft-=1000;
                bar.setProgress((int) timeleft);
            }
            @Override
            public void onFinish() {
                vibrate();
                Button button1 = findViewById(R.id.button1);
                Button button2 = findViewById(R.id.button2);
                Button button3 = findViewById(R.id.button3);
                Button button4 = findViewById(R.id.button4);
                textView.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
            }
        }.start();
        cancel.setOnClickListener((v) -> {
            bar.setProgress(100);
            TextView giveup = findViewById(R.id.textView2);
            giveup.setVisibility(View.VISIBLE);
            Button button1 = findViewById(R.id.button1);
            Button button2 = findViewById(R.id.button2);
            Button button3 = findViewById(R.id.button3);
            Button button4 = findViewById(R.id.button4);
            textView.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            return;
        });
    }
    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }
    public void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        return;
    }




}
