package io.github.shardbytes.kesulaptimer;

/**
 * Created by Plasmoxy on 26.02.2018.
 */

public class CustomUtil {

    public static float map(float x, float in_min, float in_max, float out_min, float out_max)
    {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }


}
