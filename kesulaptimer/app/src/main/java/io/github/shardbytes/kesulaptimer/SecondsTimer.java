package io.github.shardbytes.kesulaptimer;

import android.os.CountDownTimer;
import android.util.Log;

/**
 * Created by Plasmoxy on 16.02.2018.
 */

public class SecondsTimer extends CountDownTimer {

    private MainActivity activity;
    private int initSeconds;
    private boolean isFinished;

    public boolean isFinished() { return isFinished; }

    public SecondsTimer(MainActivity activity, int seconds) {
        super(seconds*1000, 100);
        this.activity = activity;
        this.initSeconds = seconds;
    }

    @Override
    public void onTick(long millisUntilFinished) {

        double complete = millisUntilFinished/(initSeconds*1000d);

        // start and end have to be fixed manually because timer of some weird bug

        if (complete != 0d || complete != 1d) {
            // uhhh the ceil is because we humants think about it like that, it tells us what is REMAINING
            activity.secondsTextView.setText(String.valueOf((int)Math.ceil(millisUntilFinished / 1000d)) + " s");
            activity.cProgress.setProgress((int) (100 * (1d - complete)));
            Log.e("ERROR BITCH", "TICC = " + String.valueOf(millisUntilFinished / 1000d / initSeconds * 100));
        }
    }

    @Override
    public void onFinish() {
        activity.secondsTextView.setText("FINISHED");
        activity.timerButton.setText("REFRESH");
        activity.cProgress.setProgress(100);
    }

    public void started() {

        activity.secondsTextView.setText("0 s");
        activity.cProgress.setProgress(0);

        activity.timerButton.setText("STOP");
        activity.secondsSeekBar.setEnabled(false);
    }

    public void finished() {

        activity.secondsTextView.setText(String.valueOf(initSeconds) + " s");
        activity.cProgress.setProgress(100);

        activity.timerButton.setText("START");
        activity.secondsSeekBar.setEnabled(true);

        activity.timer.cancel();
    }

}
