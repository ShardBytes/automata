package io.github.shardbytes.kesulaptimer;

import android.view.View;

/**
 * Created by Plasmoxy on 13.02.2018.
 */

public class TimerButtonListener implements View.OnClickListener {

    private MainActivity activity;

    public TimerButtonListener(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) { // switching dependent on timer
        if (activity.timer == null) { // start timer

            int seconds = activity.secondsSeekBar.getProgress();

            activity.timerButton.setText("STOP");
            activity.secondsSeekBar.setEnabled(false);
            activity.timer = new SecondsTimer(seconds);

        } else { // stop timer
            activity.timer.cancel();
            activity.timer = null; // deref
        }
    }
}
