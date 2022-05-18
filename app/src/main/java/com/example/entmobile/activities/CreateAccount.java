package com.example.entmobile.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entmobile.R;

public class CreateAccount extends AppCompatActivity {

    private Button button_validate; // Button used to launch the "openMainMenu()" method.
    private Button button_login; // Another button used to launch the "openMainMenu()" method.
    private EditText username; // EditText where the user sets his username
    private EditText password; // EditText where the user sets his password
    private EditText password_check; // EditText where the user sets his group

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //Finds the object's IDs and initializes local variables
        button_validate = findViewById(R.id.button_validate);
        button_login = findViewById(R.id.button_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        password_check = findViewById(R.id.password_check);

        // Set a listener on the Create Account button
        button_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

        // Set a listener on the Log In button
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogInMenu();
            }
        });
    }

    /**
     * Method used when the user is done validating his data.
     *
     * This method takes each field entered by the user, and saves them in the shared preferences.
     */
    private void createAccount() {
        // Retreives the fields entered by the user
        final String usernametext = username.getText().toString();
        final String passwordtext = password.getText().toString();
        final String passwordchecktext = password_check.getText().toString();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences
        String existing_username = preferences.getString("username", ""); //Gets the username from the SharedPreferences

        // Checks if the fields are valid
        if (!usernametext.equals("")) { //if the username is correct
            if (passwordtext.equals(passwordchecktext)) { //if the password is correct
                if ((!passwordtext.equals("")) && (!passwordchecktext.equals(""))) { //if the mail is correct
                    if (!existing_username.equals("")) {
                        AlertDialog alerte = new AlertDialog.Builder(this).create();
                        alerte.setTitle(getString(R.string.warning));
                        alerte.setMessage(getString(R.string.create_acc_wrng_msg_1)+"\n\n" + getString(R.string.create_acc_wrng_msg_2)+"\n\n" + getString(R.string.wrng_continue));

                        alerte.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.ok), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.clear();
                                editor.apply();
                                saveAccount(usernametext, passwordtext);
                            }
                        });
                        alerte.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.cancel), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        alerte.show();
                    }
                    else {
                        saveAccount(usernametext, passwordtext);
                    }
                }
                else { //If the password isn't correct
                    password.setError(getString(R.string.create_acc_missing_pass)); //Shows an error message indicating that the password isn't correct
                }
            }
            else { //If the password isn't correct
                password_check.setError(getString(R.string.create_acc_pass_mismatch)); //Shows an error message indicating that the password isn't correct
            }
        }
        else { //If the username isn't correct
            username.setError(getString(R.string.create_acc_missing_username)); //Shows an error message indicating that the username isn't correct
        }
    }

    /**
     * Method used to save an account in the Shared Preferences
     * @param usernametext String containing the username of the account that will be saved
     * @param passwordtext String containing the password of the account that will be saved
     */
    private void saveAccount(String usernametext, String passwordtext) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences
        SharedPreferences.Editor editor = preferences.edit(); //Initializes the SharedPreferences' editor

        //Saves each field in the SharedPreferences
        editor.putString("username", usernametext);
        editor.putString("password", passwordtext);

        editor.apply(); //Applies the changes

        openLogInMenu(); //Opens the Log-In menu
    }

    /**
     * Method used to open the Main Menu.
     *
     * It sets a flag "FLAG_ACTIVITY_NO_HISTORY" so that the user cannot press the back button and go back to the Account Creation page.
     */
    private void openLogInMenu() {
        Intent intent = new Intent(this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

}