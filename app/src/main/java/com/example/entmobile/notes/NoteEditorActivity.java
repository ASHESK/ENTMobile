package com.example.entmobile.notes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.entmobile.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteEditorActivity extends AppCompatActivity {

    Button save_note_button;
    Button cancel_note_button;

    EditText note_title_edit_text;
    EditText note_content_edit_text;

    ImageButton category_button;

    TextView category;

    String currentNoteCategory = "None";

    private final List<Category> categoriesList = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        //Finds the object's IDs and initializes local variables
        save_note_button = findViewById(R.id.save_note_button);
        cancel_note_button = findViewById(R.id.cancel_note_button);
        category_button = findViewById(R.id.category_button);
        note_title_edit_text = findViewById(R.id.note_title_edit_text);
        note_content_edit_text = findViewById(R.id.note_content_edit_text);
        category = findViewById(R.id.category);

        //If the Editor was opened to edit a note, then it loads that note
        if (isEditedNote()) {
            setupEditedNote(getEditedNote());
        }
        else {
            category.setText(currentNoteCategory);
        }

        //Sets the Button Listeners
        setupButtonsListeners();

        //Sets the categories
        loadCategoriesFromSharedPreferences();
    }

    /**
     * Sets up all of the buttons listeners as well as the listeners for each Note
     */
    private void setupButtonsListeners() {
        save_note_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewNote();
            }
        });

        cancel_note_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        category_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoriesSelector();
            }
        });
    }

    /**
     * Method used to know if a current note is an edited or a new one
     * @return Boolean indicating if the note is an edited one.
     */
    private boolean isEditedNote() {
        Intent intent = getIntent();
        int edit_note = intent.getIntExtra("note_edit", -1);

        return edit_note != -1;
    }

    /**
     * Method used to retrive the number of the note currently edited
     * @return Int containing the number of the note currently edited
     */
    private int getEditedNote() {
        Intent intent = getIntent();

        return intent.getIntExtra("note_edit", -1);
    }

    /**
     * Method used to set up the Note Editor
     * @param edit_note Int containing the number of the note that will be loaded in the Note Editor
     */
    private void setupEditedNote(int edit_note) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences

        String categoryKey = "note_" + edit_note + "_category";
        String titleKey = "note_" + edit_note + "_title";
        String contentKey = "note_" + edit_note + "_content";

        //Retrieves each of the Note's attributes from the SharedPreferences
        String editedNoteCategory = preferences.getString(categoryKey, ""); //Gets the amount of notes saved in the SharedPreferences
        String editedNoteTitle = preferences.getString(titleKey, ""); //Gets the amount of notes saved in the SharedPreferences
        String editedNoteContent = preferences.getString(contentKey, ""); //Gets the amount of notes saved in the SharedPreferences

        note_title_edit_text.setText(editedNoteTitle);
        note_content_edit_text.setText(editedNoteContent);
        currentNoteCategory = editedNoteCategory;
        category.setText(currentNoteCategory);
    }

    /**
     * Method used to show the Categories Selector
     */
    private void showCategoriesSelector() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.notes_editor_choose_cat));// add a radio button list

        int[] checkedItem = {0};

        String[] categoriesNames = new String[categoriesList.size()+1];

        categoriesNames[0] = "None";

        if (!categoriesList.isEmpty()) {
            for (int i=0; i<categoriesList.size(); i++) {
                if (currentNoteCategory.matches(categoriesList.get(i).getName())) {
                    checkedItem[0] = i;
                }
                categoriesNames[i+1] = categoriesList.get(i).getName();
            }
        }

        builder.setSingleChoiceItems(categoriesNames, checkedItem[0], new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkedItem[0] = which;
            }
        });

        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int selectedCategory) {

                if (!categoriesList.isEmpty()) {
                    currentNoteCategory = categoriesNames[checkedItem[0]];
                    category.setText(currentNoteCategory);
                }
            }
        });

        builder.setNegativeButton(getString(R.string.cancel), null);// create and show the alert dialog

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Method used to save the current Note's data in the Shared Preferences
     */
    private void saveNewNote() {

        if (!note_title_edit_text.getText().toString().equals("")) {
            if (!note_content_edit_text.getText().toString().equals("")) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences
                SharedPreferences.Editor editor = preferences.edit(); //Initializes the SharedPreferences' editor

                Intent intent_origin = getIntent();
                int edit_note = intent_origin.getIntExtra("note_edit", -1);

                int new_nb_notes;
                int new_note_pos;

                if (edit_note != -1) {
                    new_nb_notes = preferences.getInt("nb_notes", 0);
                    new_note_pos = intent_origin.getIntExtra("note_edit", -1);
                }
                else {
                    new_nb_notes = preferences.getInt("nb_notes", 0) + 1; //Gets the amount of notes saved in the SharedPreferences and adds one
                    new_note_pos = preferences.getInt("nb_notes", 0) + 1;
                }

                editor.putInt("nb_notes", new_nb_notes);

                //Prepares the Keys that will be used to save the Note's attributes
                String categoryKey = "note_" + new_note_pos + "_category";
                String titleKey = "note_" + new_note_pos + "_title";
                String contentKey = "note_" + new_note_pos + "_content";

                //Prepares the Values that will be used to save the Note's attributes
                String categoryValue = currentNoteCategory;
                String titleValue = note_title_edit_text.getText().toString();
                String contentValue = note_content_edit_text.getText().toString();

                //Saves each of the Note's attributes in the SharedPreferences
                editor.putString(categoryKey, categoryValue);
                editor.putString(titleKey, titleValue);
                editor.putString(contentKey, contentValue);

                editor.apply(); //Applies the changes

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
            else {
                note_content_edit_text.setError(getString(R.string.notes_editor_fill_note)); //Shows an error message indicating that the password isn't correct
            }
        }
        else {
            note_title_edit_text.setError(getString(R.string.notes_editor_set_title)); //Shows an error message indicating that the password isn't correct
        }
    }

    /**
     * This method is used to recreate all of the Category objects contained in the SharedPreferences and then stores them in the categoriesList Array List.
     */
    private void loadCategoriesFromSharedPreferences() {
        //Initializes the SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences

        //Retrieves the number of notes from the SharedPreferences
        int nb_categories = preferences.getInt("nb_categories", 0); //Gets the amount of notes saved in the SharedPreferences

        //Clears the current noteList
        categoriesList.clear();

        for (int i=1; i<=nb_categories; i++) {
            //Prepares the Keys that will be used to retrieve the Note's attributes
            String categoryNameKey = "note_category_" + i + "_name";
            String categoryDisplayedKey = "note_category_" + i + "_displayed";

            //Retrieves each of the Note's attributes from the SharedPreferences
            String categoryNameValue = preferences.getString(categoryNameKey, "error"); //Gets the amount of notes saved in the SharedPreferences
            Boolean categoryDisplayedValue = preferences.getBoolean(categoryDisplayedKey, true); //Gets the amount of notes saved in the SharedPreferences

            //Creates a new Note using the data retrieved from the SharedPreferences
            Category newCategory = new Category(categoryNameValue, categoryDisplayedValue);

            //Adds that note to the noteList Array List
            categoriesList.add(newCategory);
        }
    }
}