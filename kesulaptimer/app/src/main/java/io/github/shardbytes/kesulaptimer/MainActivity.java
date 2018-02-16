package io.github.shardbytes.kesulaptimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class MainActivity extends AppCompatActivity {

    TextView secondsTextView;
    SeekBar secondsSeekBar;
    CircleProgress cProgress;
    Button timerButton;

    SecondsTimer timer; // let the reference be null when no timer is currently active=attached

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link views
        secondsTextView = findViewById(R.id.secondsTextView);
        secondsSeekBar = findViewById(R.id.secondsSeekBar);
        cProgress = findViewById(R.id.circle_progress);
        timerButton = findViewById(R.id.timerButton);

        secondsSeekBar.setOnSeekBarChangeListener(new SecondsSeekBarListener(this));
        timerButton.setOnClickListener(new TimerButtonListener(this));

    }
}
