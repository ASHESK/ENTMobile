package com.example.entmobile.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.example.entmobile.R;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    Button button_tuto_edt;
    Button button_tuto_mails;
    Button button_tuto_notes;
    Button button_tuto_results;

    private PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        prefManager = new PrefManager(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.settings, new SettingsFragment()).commit();
        }

        //Finds the object's IDs and initializes local variables
        button_tuto_edt = findViewById(R.id.button_tuto_edt);
        button_tuto_mails = findViewById(R.id.button_tuto_mails);
        button_tuto_notes = findViewById(R.id.button_tuto_notes);
        button_tuto_results = findViewById(R.id.button_tuto_results);

        //Set a listener on the EDT Tutorial button
        button_tuto_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.setScheduleFirstTimeLaunch(true);
                openScheduleTutorial();
            }
        });

        //Set a listener on the Mails Tutorial button
        button_tuto_mails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.setMailsFirstTimeLaunch(true);
                openMailsTutorial();
            }
        });

        //Set a listener on the Notes Tutorial button
        button_tuto_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.setNotesFirstTimeLaunch(true);
                openNotesTutorial();
            }
        });

        //Set a listener on the Results Tutorial button
        button_tuto_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.setResultsFirstTimeLaunch(true);
                openResultsTutorial();
            }
        });
    }

    /**
     * Method used to open the Schedule page
     */
    private void openScheduleTutorial() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Schedule");
        startActivity(intent);
    }

    /**
     * Method used to open the Mail page
     */
    private void openMailsTutorial() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Mails");
        startActivity(intent);
    }

    /**
     * Method used to open the Note page
     */
    private void openNotesTutorial() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Notes");
        startActivity(intent);
    }

    /**
     * Method used to open the Results page
     */
    private void openResultsTutorial() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Results");
        startActivity(intent);
    }

    /**
     * Change the language of the app depending on a language in parameter
     *
     * @param resources The resources used to change the language
     * @param language  The language we want the app to display
     */
    public static void setLocale(Resources resources, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.settings_ui, rootKey);
        }
    }
}
