package com.example.entmobile.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Gère les SharedPreferences
 */
public class PrefManager {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor sharedPreferencesEditor;

    // Nom des SharedPreferences
    private static final String IS_MAILS_FIRST_TIME_LAUNCH = "IsMailsFirstTimeLaunch";
    private static final String IS_SCHEDULE_FIRST_TIME_LAUNCH = "IsScheduleFirstTimeLaunch";
    private static final String IS_NOTES_FIRST_TIME_LAUNCH = "IsNotesFirstTimeLaunch";
    private static final String IS_RESULTS_FIRST_TIME_LAUNCH = "IsResultsFirstTimeLaunch";
    private static final String IS_MESSAGES_FIRST_TIME_LAUNCH = "IsMessagesFirstTimeLaunch";

    public PrefManager(Context context) {
        // shared pref mode
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.apply();
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setMailsFirstTimeLaunch(boolean isFirstTime) {
        sharedPreferencesEditor.putBoolean(IS_MAILS_FIRST_TIME_LAUNCH, isFirstTime);
        sharedPreferencesEditor.commit();
    }

    public boolean isMailsFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_MAILS_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setScheduleFirstTimeLaunch(boolean isFirstTime) {
        sharedPreferencesEditor.putBoolean(IS_SCHEDULE_FIRST_TIME_LAUNCH, isFirstTime);
        sharedPreferencesEditor.commit();
    }

    public boolean isScheduleFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_SCHEDULE_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setNotesFirstTimeLaunch(boolean isFirstTime) {
        sharedPreferencesEditor.putBoolean(IS_NOTES_FIRST_TIME_LAUNCH, isFirstTime);
        sharedPreferencesEditor.commit();
    }

    public boolean isNotesFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_NOTES_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setResultsFirstTimeLaunch(boolean isFirstTime) {
        sharedPreferencesEditor.putBoolean(IS_RESULTS_FIRST_TIME_LAUNCH, isFirstTime);
        sharedPreferencesEditor.commit();
    }

    public boolean isResultsFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_RESULTS_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Change les SharedPreferences
     * @param isFirstTime le boolean du premier lancement
     */
    public void setMessagesFirstTimeLaunch(boolean isFirstTime) {
        sharedPreferencesEditor.putBoolean(IS_MESSAGES_FIRST_TIME_LAUNCH, isFirstTime);
        sharedPreferencesEditor.commit();
    }

    public boolean isMessagesFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_MESSAGES_FIRST_TIME_LAUNCH, true);
    }
}