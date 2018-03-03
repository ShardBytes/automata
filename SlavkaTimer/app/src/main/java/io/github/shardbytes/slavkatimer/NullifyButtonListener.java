package io.github.shardbytes.slavkatimer;

import android.view.View;

/**
 * Created by Plasmoxy on 13.02.2018.
 */

public class NullifyButtonListener implements View.OnClickListener {

    private MainActivity activity;

    public NullifyButtonListener(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.presetSeconds = 0;
        activity.updateSecondsView(activity.presetSeconds);
    }
}
