package com.example.entmobile.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entmobile.R;

import java.util.Locale;

public class Login extends AppCompatActivity {

    private Button button_login; // Button used to launch the "openMainMenu()" method.
    private Button button_createAccount; // Button used to launch the "openCreateAccountMenu()" method.
    private EditText TextIL_username; // Button used to launch the "openMainMenu()" method.
    private EditText TextIL_password; // Button used to launch the "openMainMenu()" method.
    private Switch switch_autofill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences
        String current_lang = preferences.getString("loc", ""); // prefered language

        // if language is not same as in preferences
        if (!current_lang.equals(Locale.getDefault().toString())) {
            // change to language in preferences
            Settings.setLocale(getResources(), current_lang);
            recreate();
        }

        //Finds the object's IDs and initializes local variables
        button_login = findViewById(R.id.button_login);
        button_createAccount = findViewById(R.id.button_createAccount);
        TextIL_username = findViewById(R.id.TextIL_username);
        TextIL_password = findViewById(R.id.TextIL_password);
        switch_autofill = findViewById(R.id.switch_autofill);

        if (preferences.getBoolean("autofill", false)) {
            switch_autofill.setChecked(true);
            TextIL_username.setText(preferences.getString("username", "")); //Gets the username from the SharedPreferences and put it in the user name space
        } else {
            switch_autofill.setChecked(false);
        }

        // Set a listener on the Log-In button
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_in();
            }
        });

        // Set a listener on the Create Account button
        button_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateAccountMenu();
            }
        });
        // Set a listener on the Autofill switch
        switch_autofill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeAutofillPolicy(isChecked);
            }
        });
    }

    private void changeAutofillPolicy(Boolean policy) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences
        SharedPreferences.Editor editor = preferences.edit(); //Initializes the SharedPreferences' editor

        //Saves the autofill policy in the SharedPreferences
        editor.putBoolean("autofill", policy);

        editor.apply(); //Applies the changes
    }

    /**
     * Method used to open check the log-in credentials and opens the Main Menu if they are correct.
     */
    private void log_in() {
        String username = TextIL_username.getText().toString(); //Gets the username typed by the user in the EditText
        String password = TextIL_password.getText().toString(); //Gets the password typed by the user in the EditText

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences

        String user_username = preferences.getString("username", ""); //Gets the username from the SharedPreferences
        String user_pass = preferences.getString("password", ""); //Gets the password from the SharedPreferences

        // Compares the log-in credentials entered with the ones saved
        if ((username.equals(user_username)) && (!username.equals(""))) { //if the username is correct
            if (password.equals(user_pass) && (!password.equals(""))) { //if the password is correct
                openMainMenu();
            } else { //If the password isn't correct
                TextIL_password.setError(getString(R.string.wrong_pass_error)); //Shows an error message indicating that the password isn't correct
            }
        } else { //If the username isn't correct
            TextIL_username.setError(getString(R.string.wrong_username_error)); //Shows an error message indicating that the username isn't correct
        }
    }

    /**
     * Method used to open the Main Menu.
     */
    private void openMainMenu() {
        Intent intent = new Intent(this, MainMenu.class); //Prepares a new activity
        startActivity(intent); //Opens the new activity
    }

    /**
     * Method used to open the CreateAccount Menu.
     */
    private void openCreateAccountMenu() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    /**
     * Method uses to open an Alert Dialog when back button is pressed
     */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.exit))
                .setMessage(getString(R.string.exit_msg))
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.yes, (arg0, arg1) -> {
                    setResult(RESULT_OK, new Intent().putExtra("EXIT", true));
                    finish();
                }).create().show();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}