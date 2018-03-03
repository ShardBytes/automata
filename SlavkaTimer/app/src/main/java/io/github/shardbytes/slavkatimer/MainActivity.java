package io.github.shardbytes.slavkatimer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MediaPlayer alarm;

    TextView secondsTextView;
    CircleProgress cProgress;
    Button timerButton;

    Button buttonPlus, buttonPlusTen, buttonMinus, buttonMinusTen;
    Button buttonPlusMinute, buttonMinusMinute, buttonPlusFiveMinutes, buttonMinusFiveMinutes;

    List<Button> modButtons;

    long presetSeconds = 0;

    SecondsTimer timer; // let the reference be null when no timer is currently active=attached

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // load player
        alarm = MediaPlayer.create(this, R.raw.modernalarm);
        alarm.setLooping(true);

        // link views
        secondsTextView = findViewById(R.id.secondsTextView);
        cProgress = findViewById(R.id.circle_progress);
        timerButton = findViewById(R.id.timerButton);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlusTen = findViewById(R.id.buttonPlusTen);
        buttonMinusTen = findViewById(R.id.buttonMinusTen);

        buttonPlusMinute = findViewById(R.id.buttonPlusMinute);
        buttonMinusMinute = findViewById(R.id.buttonMinusMinute);
        buttonPlusFiveMinutes = findViewById(R.id.buttonPlusFiveMinutes);
        buttonMinusFiveMinutes = findViewById(R.id.buttonMinusFiveMinutes);

        // create and link to arraylist
        modButtons = new ArrayList<>(Arrays.asList(buttonPlus, buttonPlusTen, buttonMinus, buttonMinusTen,
                buttonPlusMinute, buttonMinusMinute, buttonPlusFiveMinutes, buttonMinusFiveMinutes));

        // set tint of buttons
        for (Button b : modButtons) {

        }

        // attach listeners
        timerButton.setOnClickListener(new TimerButtonListener(this));

        buttonPlus.setOnClickListener(new ModSecondsButtonListener(this, 1));
        buttonPlusTen.setOnClickListener(new ModSecondsButtonListener(this, 10));
        buttonMinus.setOnClickListener(new ModSecondsButtonListener(this, -1));
        buttonMinusTen.setOnClickListener(new ModSecondsButtonListener(this, -10));

        buttonPlusMinute.setOnClickListener(new ModSecondsButtonListener(this, 60));
        buttonMinusMinute.setOnClickListener(new ModSecondsButtonListener(this, -60));
        buttonPlusFiveMinutes.setOnClickListener(new ModSecondsButtonListener(this, 5*60));
        buttonMinusFiveMinutes.setOnClickListener(new ModSecondsButtonListener(this, -5*60));

    }

    @Override
    protected void onDestroy() {
        alarm.stop();
        super.onDestroy();
    }

    public void updateSecondsView(long seconds) {
        long hours = seconds/60/60;
        long minutes = seconds/60 - hours*60;
        long secs = seconds - hours*60*60 - minutes*60;
        secondsTextView.setText(
                ( hours > 0 ? String.valueOf(hours) + " h " : "")
                        +( minutes > 0 ? String.valueOf(minutes) + " min " : "")
                        + String.valueOf(secs) + " s"
        );
    }
}
