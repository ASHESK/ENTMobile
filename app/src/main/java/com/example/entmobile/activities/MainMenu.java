package com.example.entmobile.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entmobile.R;
import com.example.entmobile.mails.MailViewerActivity;
import com.example.entmobile.notes.NotesActivity;
import com.example.entmobile.results.ResultsActivity;
import com.example.entmobile.schedule.Schedule;

import java.util.Locale;

public class MainMenu extends AppCompatActivity {

    private final static String Url_ENT = "http://mon-ent-etudiant.univ-lemans.fr/fr/index.html"; //String containing the URL to the ENT website
    private final static String Url_UMTICE = "http://umtice.univ-lemans.fr/my/"; //String containing the URL to the UMTICE website

    private ImageButton button_log_off; //Button used to launch the "openLogInMenu()" method.
    private ImageButton button_settings; //Button used to launch the "openSettings()" method.

    private Button button_umtice; //Button used to launch the "openENTinBrowser()" method.
    private Button button_ent; //Button used to launch the "openUMTICEinBrowser()" method.
    private Button button_schedule; //Button used to launch the "openSchedule()" method.
    private Button button_mails; //Button used to launch the "openMails()" method.
    private Button button_notes; //Button used to launch the "openNotes()" method.
    private Button button_results; //Button used to launch the "openResults()" method.

    private final static int EXIT_CODE = 100; // code used to finish this activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Finds the object's IDs and initializes local variables
        button_log_off = findViewById(R.id.button_log_off);
        button_settings = findViewById(R.id.button_settings);
        button_schedule = findViewById(R.id.button_schedule);
        button_mails = findViewById(R.id.button_mails);
        button_notes = findViewById(R.id.button_notes);
        button_results = findViewById(R.id.button_results);
        button_umtice = findViewById(R.id.button_umtice);
        button_ent = findViewById(R.id.button_ent);

        //Set a listener on the Log-Off button
        button_log_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogInMenu();
            }
        });

        //Set a listener on the Settings button
        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        //Set a listener on the Schedule button
        button_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSchedule();
            }
        });

        //Set a listener on the Mail button
        button_mails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMails();
            }
        });

        //Set a listener on the Notes button
        button_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotes();
            }
        });

        //Set a listener on the Results button
        button_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResults();
            }
        });

        //Set a listener on the ENT button
        button_umtice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUMTICEinBrowser();
            }
        });

        //Set a listener on the UMTICE button
        button_ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openENTinBrowser();
            }
        });
    }

    /**
     * Method used to launch the openLogInMenu() method when the back button is pressed
     */
    @Override
    public void onBackPressed() {
        openLogInMenu();
    }

    /**
     * This method is used to alert the user that he's about to leave the app.
     */
    private void openLogInMenu() {
        AlertDialog alerte = new AlertDialog.Builder(this).create();
        alerte.setTitle(getString(R.string.exit));
        alerte.setMessage("\n"+ getString(R.string.exit_msg));

        alerte.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alerte.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alerte.show();
    }

    /**
     * Method used to open the Settings page.
     */
    private void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /**
     * Method used to open the Schedule page
     */
    private void openSchedule() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Schedule");
        intent.putExtra("Launch", true);
        startActivity(intent);
    }

    /**
     * Method used to open the Mail page
     */
    private void openMails() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Mails");
        intent.putExtra("Launch", true);
        startActivity(intent);
    }

    /**
     * Method used to open the Note page
     */
    private void openNotes() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Notes");
        intent.putExtra("Launch", true);
        startActivity(intent);
    }

    /**
     * Method used to open the Results page
     */
    private void openResults() {
        Intent intent = new Intent(this, TutoActivity.class);
        intent.putExtra("Name", "Results");
        intent.putExtra("Launch", true);
        startActivity(intent);
    }

    /**
     * Method used to open a browser intent to the ENT website.
     */
    private void openENTinBrowser() {
        openInBrowser(Url_ENT);
    }

    /**
     * Method used to open a browser intent to the UMTICE website.
     */
    private void openUMTICEinBrowser() {
        openInBrowser(Url_UMTICE);
    }

    /**
     * This method takes an url and open it in a web browser
     *
     * @param url The string url of the web page
     */
    private void openInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW); //Creates a new intent of type Action_View
        intent.setData(Uri.parse(url)); //Set the intent's data to the parsed UMTICE URL
        startActivity(intent); //Starts a new activity with the intent
    }

    /**
     * Method used to finish the MainMenu Activity and disabled the back pressed button
     *
     * @param requestCode the request code of this activity
     * @param resultCode  the result of the Login Activity to finish the MainMenu Activity
     * @param data        the boolean to finish the MainMenu Activity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EXIT_CODE) {
            if (resultCode == RESULT_OK) {
                if (data.getBooleanExtra("EXIT", true)) {
                    finish();
                }
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences
        String current_lang = preferences.getString("loc", ""); // prefered language

        // if language is not same as in preferences
        if (!current_lang.equals(Locale.getDefault().toString())) {
            // change to language in preferences
            Settings.setLocale(getResources(), current_lang);
            recreate();
        }
    }
}