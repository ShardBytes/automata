package io.github.shardbytes.kesulaptimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class MainActivity extends AppCompatActivity {

    private TextView secondsTextView;
    private SeekBar secondsSeekBar;
    private SecondsPredefined secs;
    private CircleProgress cProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondsTextView = findViewById(R.id.secondsTextView);
        secondsSeekBar = findViewById(R.id.secondsSeekBar);
        cProgress = findViewById(R.id.circle_progress);
        secs = new SecondsPredefined();

        secondsSeekBar.setOnSeekBarChangeListener(new SecondsSeekBarListener(secondsSeekBar, secondsTextView, secs));

    }
}
