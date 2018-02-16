package io.github.shardbytes.kesulaptimer;

import android.os.CountDownTimer;

/**
 * Created by Plasmoxy on 16.02.2018.
 */

public class SecondsTimer extends CountDownTimer {

    public SecondsTimer(int seconds) {
        super(seconds*1000, 1000);
    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {

    }
}
