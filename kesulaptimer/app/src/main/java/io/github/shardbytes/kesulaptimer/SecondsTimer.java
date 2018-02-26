package io.github.shardbytes.kesulaptimer;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by Plasmoxy on 16.02.2018.
 */

public class SecondsTimer extends CountDownTimer {

    private MainActivity activity;
    private long initSeconds;

    public SecondsTimer(MainActivity activity, long seconds) {
        super(seconds*1000, 100); // cound every 100ms so its at least a bit authentic
        this.activity = activity;
        this.initSeconds = seconds;
    }

    private void updateProgressColor() {
        float newHSV[] = {
                (CustomUtil.map( activity.cProgress.getProgress(), 0, 100, 0, 359 ) + 324) % 360 ,
                0.82f,
                0.94f
        }; // +324 = purple color offset
        activity.cProgress.setFinishedColor(Color.HSVToColor(newHSV));
    }

    @Override
    public void onTick(long millisUntilFinished) {

        double complete = millisUntilFinished/(initSeconds*1000d);

        // start and end have to be fixed manually because timer of some weird bug

        if (complete != 0d || complete != 1d) {
            // uhhh the ceil is because we humans think about it like that, it tells us what is REMAINING
            activity.updateSecondsView((int)Math.ceil(millisUntilFinished / 1000d));
            activity.cProgress.setProgress((int) (100 * (1d - complete)));
            updateProgressColor();
            // Log.e("ERROR BITCH", "TICC = " + String.valueOf(millisUntilFinished / 1000d / initSeconds * 100));
        }
    }

    @Override
    public void onFinish() {
        if (!activity.alarm.isPlaying())
            activity.alarm.start();
        activity.secondsTextView.setText("FINISHED");
        activity.timerButton.setText("REFRESH");
        activity.cProgress.setProgress(100);
        updateProgressColor();
    }

    public void started() {

        for (Button b : activity.modButtons) {
            b.setEnabled(false);
        }

        activity.cProgress.setProgress(0);
        updateProgressColor();
        activity.timerButton.setText("STOP");
    }

    public void stopped() {
        if (activity.alarm.isPlaying()) {
            activity.alarm.pause();
            activity.alarm.seekTo(0);
        }

        for (Button b : activity.modButtons) {
            b.setEnabled(true);
        }

        activity.updateSecondsView(activity.presetSeconds);
        activity.cProgress.setProgress(0);

        activity.timerButton.setText("START");

        activity.timer.cancel();
    }

}
