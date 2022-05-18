package com.example.entmobile.notes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entmobile.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity implements NoteItemTouchHelper.RecyclerItemTouchHelperListener {

    /**
     * TextView used to show the user the amount of notes saved and available
     */
    public TextView notes_counter;

    public TextView noteTextView;

    public TextView no_notes_hint;

    /**
     * ImageButton used to launch the openNoteSettings() method
     */
    public ImageButton notes_settings_button;

    public ImageButton notes_trash_button;

    /**
     * ImageButton used to launch the createNewNote() method
     */
    public ImageButton add_note_button;

    public RecyclerView note_recycler_view;

    public NotesAdapter notesAdapter;

    private CoordinatorLayout coordinatorLayout;

    final int NOTE_EDITION_DONE = 1;

    private final List<Note> noteList = new ArrayList<Note>();

    private final List<Category> categoriesList = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //Finds the object's IDs and initializes local variables
        notes_counter = findViewById(R.id.notes_counter);
        no_notes_hint = findViewById(R.id.no_notes_hint);
        add_note_button = findViewById(R.id.save_note_button);
        notes_settings_button = findViewById(R.id.notes_settings_button);
        notes_trash_button = findViewById(R.id.notes_trash_button);
        note_recycler_view = findViewById(R.id.note_recycler_view);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        noteTextView = findViewById(R.id.notes_text_view);

        //loads all saved data in the activity
        loadAll();

        //Swipe
        NoteItemTouchHelper noteItemTouchHelper = new NoteItemTouchHelper(0, ItemTouchHelper.LEFT, this);

        //attaching the touch helper to recycler view
        new ItemTouchHelper(noteItemTouchHelper).attachToRecyclerView(note_recycler_view);

        //Loads everything loadable
        reloadAll();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NOTE_EDITION_DONE) {
            loadAll();
            reloadAll();
        }
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

        if (viewHolder instanceof NotesAdapter.ViewHolder) {
            // get the removed item name to display it in snack bar
            String name = noteList.get(position).getTitle();

            // backup of removed item for undo purpose
            final Note deletedItem = noteList.get(position);
            final int deletedIndex = position;

            // remove the item from recycler view
            notesAdapter.removeItem(position);

            //Updates the notes_counter EditText with the current amount of notes
            notes_counter.setText(Integer.toString(noteList.size()));

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "\"" + name + getString(R.string.notes_was_deleted), Snackbar.LENGTH_LONG);
            snackbar.setAction(getString(R.string.undo), new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    notesAdapter.restoreItem(deletedItem, deletedIndex);

                    //Updates the notes_counter EditText with the current amount of notes
                    notes_counter.setText(Integer.toString(noteList.size()));

                    saveNotesInSharedPreferences();
                    reloadAll();
                }
            });
            snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
            snackbar.show();
        }
        saveNotesInSharedPreferences();
        reloadAll();
    }

    /**
     * Method used to create a new note.
     */
    private void newNote() {
        Intent intent = new Intent(this, NoteEditorActivity.class);
        startActivityForResult(intent, NOTE_EDITION_DONE);
    }

    /**
     * Opens the Note Editor and passes through the Extras the number of the Note that will be edited.
     * @param pos String containing the number of the note
     */
    private void editNote(int pos) {
        Intent intent = new Intent(this, NoteEditorActivity.class);
        intent.putExtra("note_edit", pos);
        startActivityForResult(intent, NOTE_EDITION_DONE);
    }

    private void createNote(String category, String Title, String Content) {
        //Creates a new Note using the data retrieved from the SharedPreferences
        Note newNote = new Note(category, Title, Content);

        //Adds that note to the noteList Array List
        noteList.add(newNote);
    }

    /**
     * Method used to open the notes settings.
     */
    private void ShowNotesSettingsDialog() {
        //Setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Sets the dialog's title
        builder.setTitle(getString(R.string.notes_displayed_cat));// add a checkbox list

        //Initializes the tables
        String[] categoriesNames = new String[categoriesList.size()];
        boolean[] checkedItems = new boolean[categoriesList.size()];

        //Sets up the tables for them to be displayed in the MultiChoiceItems dialog
        for (int i=0;i<categoriesList.size();i++) {
            categoriesNames[i] = categoriesList.get(i).getName();
            checkedItems[i] = categoriesList.get(i).isDisplayed();
        }

        //Fills the dialog with CheckBoxes
        builder.setMultiChoiceItems(categoriesNames, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                categoriesList.get(which).setDisplayed(isChecked);
            }
        });

        //When the OK button is pressed
        builder.setNeutralButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveCategoriesInSharedPreferences();
                loadNotesFromSharedPreferences();
                reloadAll();
            }
        });

        //When the Add button is pressed
        builder.setPositiveButton(getString(R.string.add), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveCategoriesInSharedPreferences();
                loadNotesFromSharedPreferences();
                reloadAll();
                ShowAddNewCategoriesDialog();
            }
        });

        //When the Remove button is pressed
        builder.setNegativeButton(getString(R.string.remove), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveCategoriesInSharedPreferences();
                loadNotesFromSharedPreferences();
                reloadAll();
                if (!categoriesList.isEmpty()) {
                    ShowRemoveCategoriesDialog();
                }
                else {
                    ShowAlertNoCategories();
                }
            }
        });

        //Creates and shows the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void ShowRemoveCategoriesDialog() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.notes_remove_cat));// add a radio button list

        //Initializes the tables
        int[] checkedItem = {0};

        String[] categoriesNames = new String[categoriesList.size()];

        if (!categoriesList.isEmpty()) {
            for (int i=0; i<categoriesList.size(); i++) {
                categoriesNames[i] = categoriesList.get(i).getName();
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
            public void onClick(DialogInterface dialog, int which) {

                for (int i = 0; i<noteList.size(); i++) {
                    if (noteList.get(i).getCategory().matches(categoriesNames[checkedItem[0]])) {
                        noteList.get(i).setCategory("None");
                    }
                }
                categoriesList.remove(checkedItem[0]);
                saveAll();
                reloadAll();
            }
        });

        builder.setNegativeButton(getString(R.string.cancel), null);// create and show the alert dialog

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void ShowAddNewCategoriesDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.notes_new_cat));

        // set the custom layout
        final View categories_display = getLayoutInflater().inflate(R.layout.categories_display, null);

        builder.setView(categories_display);

        // add a button
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the AlertDialog to the Activity
                EditText editText = categories_display.findViewById(R.id.editText);
                addNewCategory(editText.getText().toString());
            }
        });

        //When the Cancel button is pressed
        builder.setNegativeButton(getString(R.string.cancel), null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void ShowAlertNoCategories() {
        Toast.makeText(this, getString(R.string.notes_no_cat), Toast.LENGTH_LONG).show();
    }

    private void showDeleteAllAlert() {
        android.app.AlertDialog alerte = new android.app.AlertDialog.Builder(this).create();
        alerte.setTitle(getString(R.string.warning));
        alerte.setMessage(getString(R.string.notes_delete_all_wrng_msg_1)+"\n\n"+getString(R.string.wrng_continue));

        alerte.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                noteList.clear();
                saveAll();
                reloadAll();
            }
        });
        alerte.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alerte.show();
    }

    private void addNewCategory(String name) {
        Category newCategory = new Category(name, true);
        categoriesList.add(newCategory);
        saveCategoriesInSharedPreferences();
    }

    /**
     * This method is used to recreate all of the Note objects contained in the SharedPreferences and then stores them in the noteList Array List.
     */
    private void loadNotesFromSharedPreferences() {
        //Initializes the SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences

        //Retrieves the number of notes from the SharedPreferences
        int nb_notes = preferences.getInt("nb_notes", 0); //Gets the amount of notes saved in the SharedPreferences

        //Saves the number of notes of the last time the notes were loaded
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("old_nb_notes", nb_notes);
        editor.apply();

        //Clears the current noteList
        noteList.clear();

        for (int i=1; i<=nb_notes; i++) {
            //Prepares the Keys that will be used to retrieve the Note's attributes
            String categoryKey = "note_" + i + "_category";
            String titleKey = "note_" + i + "_title";
            String contentKey = "note_" + i + "_content";

            //Retrieves each of the Note's attributes from the SharedPreferences
            String newNoteCategory = preferences.getString(categoryKey, ""); //Gets the amount of notes saved in the SharedPreferences
            String newNoteTitle = preferences.getString(titleKey, ""); //Gets the amount of notes saved in the SharedPreferences
            String newNoteContent = preferences.getString(contentKey, ""); //Gets the amount of notes saved in the SharedPreferences

            for(Category category : categoriesList) {
                if (newNoteCategory.matches(category.getName())) {
                    if (category.isDisplayed()) {
                        createNote(newNoteCategory, newNoteTitle, newNoteContent);
                    }
                }
            }
            if (newNoteCategory.matches("None")) {
                createNote(newNoteCategory, newNoteTitle, newNoteContent);
            }
        }
        setupNoteCounter();
        setupNoNoteHint();
    }

    /**
     * This method is used to recreate all of the Note objects contained in the SharedPreferences and then stores them in the noteList Array List.
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

    private void saveNotesInSharedPreferences() {
        //Initializes the SharedPreferences and initializes the SharedPreferences' editor
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        // If the noteList Array List isn't empty
        if (!noteList.isEmpty()) {

            int nb_notes = noteList.size();

            editor.putInt("nb_notes", nb_notes);

            //For each Note in the noteList
            for (int i = 0; i< noteList.size(); i++) {
                //Prepares the Keys that will be used to save the Note's attributes

                String categoryKey = "note_" + (i + 1) + "_category";
                String titleKey = "note_" + (i + 1) + "_title";
                String contentKey = "note_" + (i + 1) + "_content";

                //Prepares the Values that will be used to save the Note's attributes
                String noteCategory = noteList.get(i).getCategory();
                String noteTitle = noteList.get(i).getTitle();
                String noteContent = noteList.get(i).getContent();

                //Saves each of the Note's attributes in the SharedPreferences
                editor.putString(categoryKey, noteCategory);
                editor.putString(titleKey, noteTitle);
                editor.putString(contentKey, noteContent);
            }
        }
        else {
            //Retrieves the number of notes of the last time note were loaded from the SharedPreferences
            int old_nb_notes = preferences.getInt("old_nb_notes", 0); //Gets the amount of notes saved in the SharedPreferences

            editor.putInt("nb_notes", 0);

            notes_counter.setText(Integer.toString(0));

            for (int i=0; i<old_nb_notes; i++) {
                String name_to_delete = "note_" + i + "_name";
                String category_to_delete = "note_" + i + "_category";
                String content_to_delete = "note_" + i + "_content";

                editor.remove(name_to_delete); // will delete key key_name4
                editor.remove(category_to_delete); // will delete key key_name4
                editor.remove(content_to_delete); // will delete key key_name4
            }
        }
        //Applies the changes
        editor.apply();
    }

    private void saveCategoriesInSharedPreferences() {
        //Initializes the SharedPreferences and initializes the SharedPreferences' editor
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        // If the noteList Array List isn't empty
        if (!categoriesList.isEmpty()) {

            int nb_categories = categoriesList.size();

            editor.putInt("nb_categories", nb_categories);

            //For each Note in the noteList
            for (int i=0; i<categoriesList.size(); i++) {
                //Prepares the Keys that will be used to save the Note's attributes

                String categoryNameKey = "note_category_" + (i + 1) + "_name";
                String categoryDisplayedKey = "note_category_" + (i + 1) + "_displayed";

                //Prepares the Values that will be used to save the Note's attributes
                String categoryNameValue = categoriesList.get(i).getName();
                Boolean categoryDisplayedValue = categoriesList.get(i).isDisplayed();

                //Saves each of the Note's attributes in the SharedPreferences
                editor.putString(categoryNameKey, categoryNameValue);
                editor.putBoolean(categoryDisplayedKey, categoryDisplayedValue);
            }
        }
        else {
            editor.putInt("nb_categories", 0);

            for (int i=0; i<1; i++) {

                String categoryNameKey = "note_category_" + (i + 1) + "_name";
                String categoryDisplayedKey = "note_category_" + (i + 1) + "_displayed";

                editor.remove(categoryNameKey); // will delete key key_name4
                editor.remove(categoryDisplayedKey); // will delete key key_name4
            }
        }

        //Applies the changes
        editor.apply();
    }

    private void reloadRecycleView() {
        note_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NotesAdapter(this, noteList);
        note_recycler_view.setAdapter(notesAdapter);
    }

    /**
     * Method used to set up the buttons' listeners.
     */
    private void setupButtonsListeners() {
        //Set a listener on the Add Note button
        add_note_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newNote();
            }
        });

        //Set a listener on the Settings button
        notes_settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowNotesSettingsDialog();
            }
        });

        //Set a listener on the Settings button
        notes_trash_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteAllAlert();
            }
        });

        //Set a listener on each of the notes
        notesAdapter.setClickListener(new NotesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Note editedNote = noteList.get(position);

                noteList.remove(editedNote);
                noteList.add(0, editedNote);

                saveNotesInSharedPreferences();

                editNote(1);
            }
        });
    }

    private void setupNoteCounter() {
        //Initializes the SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //Initializes the SharedPreferences

        //Retrieves the number of notes from the SharedPreferences
        int nb_notes = preferences.getInt("nb_notes", 0); //Gets the amount of notes saved in the SharedPreferences

        //Updates the notes_counter EditText with the current amount of notes
        notes_counter.setText(Integer.toString(nb_notes));

        if(nb_notes==1) {
            noteTextView.setText(R.string.note_et);
        } else {
            noteTextView.setText(R.string.notes_et);
        }
    }

    private void setupNoNoteHint() {
        if (noteList.isEmpty()) {
            no_notes_hint.setVisibility(View.VISIBLE);
        }
        else {
            no_notes_hint.setVisibility(View.GONE);
        }
    }

    private void reloadAll() {
        reloadRecycleView();
        setupButtonsListeners();
        setupNoNoteHint();
        setupNoteCounter();
    }

    private void saveAll() {
        saveCategoriesInSharedPreferences();
        saveNotesInSharedPreferences();
    }

    private void loadAll() {
        loadCategoriesFromSharedPreferences();
        loadNotesFromSharedPreferences();
    }
}