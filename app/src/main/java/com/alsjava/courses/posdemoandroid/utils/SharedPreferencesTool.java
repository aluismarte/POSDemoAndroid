package com.alsjava.courses.posdemoandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aluis on 11/2/19.
 */
public class SharedPreferencesTool {

    private static final String INTRO = "INTRO";
    private static final String PRIVACY = "PRIVACY";

    private SharedPreferences uiTools;

    public SharedPreferencesTool(Context context) {
        uiTools = context.getSharedPreferences("UITools", Context.MODE_PRIVATE);
    }

    public boolean getShowIntro() {
        return uiTools.getBoolean(INTRO, true);
    }

    public void setShowIntro(boolean showIntro) {
        uiTools.edit().putBoolean(INTRO, showIntro).apply();
    }

    public boolean getShowPrivacy() {
        return uiTools.getBoolean(PRIVACY, true);
    }

    public void setShowPrivacy(boolean showIntro) {
        uiTools.edit().putBoolean(PRIVACY, showIntro).apply();
    }

}
