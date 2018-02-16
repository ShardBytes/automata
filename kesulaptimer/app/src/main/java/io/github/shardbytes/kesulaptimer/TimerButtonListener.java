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
        if (activity.timer == null) { // if no timer

            int seconds = activity.secondsSeekBar.getProgress(); // linked directly to progress
            activity.timer = new SecondsTimer(activity, seconds);
            activity.timer.start();
            activity.timer.started();

        } else { // if there is a timer
            activity.timer.finished();
            activity.timer = null;
        }
    }
}
