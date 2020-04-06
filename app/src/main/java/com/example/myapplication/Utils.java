package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_MARGINSMALL = 0;
    public final static int THEME_MARGINSMIDDLE= 1;
    public final static int THEME_MARGINLARGE = 2;


    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_MARGINSMALL:
                activity.setTheme(R.style.MarginS);
                break;
            case THEME_MARGINSMIDDLE:
                activity.setTheme(R.style.MarginM);
                break;
            case THEME_MARGINLARGE:
                activity.setTheme(R.style.Margin1L);
                break;
        }
    }
}
