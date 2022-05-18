package com.example.entmobile.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Gère les SharedPreferences
 */
public class PrefManager {
    private SharedPreferences pref_tuto;
    private SharedPreferences.Editor editor_tuto;

    // Nom des SharedPreferences

    private static final String IS_MAILS_FIRST_TIME_LAUNCH = "IsMailsFirstTimeLaunch";
    private static final String IS_SCHEDULE_FIRST_TIME_LAUNCH = "IsScheduleFirstTimeLaunch";
    private static final String IS_NOTES_FIRST_TIME_LAUNCH = "IsNotesFirstTimeLaunch";
    private static final String IS_RESULTS_FIRST_TIME_LAUNCH = "IsResultsFirstTimeLaunch";

    public PrefManager(Context context) {
        // shared pref mode
        pref_tuto = PreferenceManager.getDefaultSharedPreferences(context);
        editor_tuto = pref_tuto.edit();
        editor_tuto.apply();
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setMailsFirstTimeLaunch(boolean isFirstTime) {
        editor_tuto.putBoolean(IS_MAILS_FIRST_TIME_LAUNCH, isFirstTime);
        editor_tuto.commit();
    }

    public boolean isMailsFirstTimeLaunch() {
        return pref_tuto.getBoolean(IS_MAILS_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setScheduleFirstTimeLaunch(boolean isFirstTime) {
        editor_tuto.putBoolean(IS_SCHEDULE_FIRST_TIME_LAUNCH, isFirstTime);
        editor_tuto.commit();
    }

    public boolean isScheduleFirstTimeLaunch() {
        return pref_tuto.getBoolean(IS_SCHEDULE_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setNotesFirstTimeLaunch(boolean isFirstTime) {
        editor_tuto.putBoolean(IS_NOTES_FIRST_TIME_LAUNCH, isFirstTime);
        editor_tuto.commit();
    }

    public boolean isNotesFirstTimeLaunch() {
        return pref_tuto.getBoolean(IS_NOTES_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setResultsFirstTimeLaunch(boolean isFirstTime) {
        editor_tuto.putBoolean(IS_RESULTS_FIRST_TIME_LAUNCH, isFirstTime);
        editor_tuto.commit();
    }

    public boolean isResultsFirstTimeLaunch() {
        return pref_tuto.getBoolean(IS_RESULTS_FIRST_TIME_LAUNCH, true);
    }

}