package io.github.shardbytes.slavkatimer;

import android.view.View;
import android.widget.Button;

/**
 * Created by Plasmoxy on 17.02.2018.
 */

public class ModSecondsButtonListener implements Button.OnClickListener {

    private int modSeconds;
    private MainActivity activity;

    public ModSecondsButtonListener(MainActivity activity, int modSeconds) {
        this.modSeconds = modSeconds;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.presetSeconds += modSeconds;
        if (activity.presetSeconds <= 0) activity.presetSeconds = 0;
        activity.updateSecondsView(activity.presetSeconds);
        // Log.e("SECONDS : ", String.valueOf(activity.presetSeconds));
    }
}
