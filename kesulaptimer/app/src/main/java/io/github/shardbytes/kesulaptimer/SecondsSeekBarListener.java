package io.github.shardbytes.kesulaptimer;

import android.widget.SeekBar;

/**
 * Created by Plasmoxy on 13.02.2018.
 */

public class SecondsSeekBarListener implements SeekBar.OnSeekBarChangeListener {

    private MainActivity activity; // reference to activity

    private int progressBefore;

    public SecondsSeekBarListener(MainActivity a) {
        this.activity = a;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (progress != progressBefore) {
            activity.secondsTextView.setText(String.valueOf(progress) + " s");
            activity.cProgress.setProgress(progress*100/120);
            progressBefore = progress;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
