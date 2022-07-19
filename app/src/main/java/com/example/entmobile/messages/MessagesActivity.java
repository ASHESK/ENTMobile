package com.example.entmobile.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.entmobile.R;
import com.example.entmobile.notes.Category;
import com.example.entmobile.notes.Note;
import com.example.entmobile.notes.NoteEditorActivity;
import com.example.entmobile.notes.NoteItemTouchHelper;
import com.example.entmobile.notes.NotesAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MessagesActivity extends AppCompatActivity implements NoteItemTouchHelper.RecyclerItemTouchHelperListener {

    /**
     * TextView used to show the user the amount of notes saved and available
     */
    public TextView notes_counter;

    public TextView messagesTextView;

    public TextView no_notes_hint;

    /**
     * ImageButton used to launch the openNoteSettings() method
     */
    public ImageButton messages_sort_az;

    public ImageButton messages_sort_date;

    /**
     * ImageButton used to launch the createNewNote() method
     */

    public RecyclerView note_recycler_view;

    public MessagesAdapter messagesAdapter;

    private CoordinatorLayout coordinatorLayout;

    final int NOTE_EDITION_DONE = 1;

    private final List<Note> noteList = new ArrayList<Note>();

    private final List<Category> categoriesList = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        //Finds the object's IDs and initializes local variables
        notes_counter = findViewById(R.id.notes_counter);
        no_notes_hint = findViewById(R.id.no_notes_hint);
        messages_sort_az = findViewById(R.id.messages_sort_az);
        messages_sort_date = findViewById(R.id.messages_sort_date);
        note_recycler_view = findViewById(R.id.note_recycler_view);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        messagesTextView = findViewById(R.id.messages_text_view);

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
            messagesAdapter.removeItem(position);

            //Updates the notes_counter EditText with the current amount of notes
            notes_counter.setText(Integer.toString(noteList.size()));

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "\"" + name + getString(R.string.notes_was_deleted), Snackbar.LENGTH_LONG);
            snackbar.setAction(getString(R.string.undo), new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    messagesAdapter.restoreItem(deletedItem, deletedIndex);

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

    private void sortByName() {

    }

    private void sortByDate() {

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
        messagesAdapter = new MessagesAdapter(this, noteList);
        note_recycler_view.setAdapter(messagesAdapter);
    }

    /**
     * Method used to set up the buttons' listeners.
     */
    private void setupButtonsListeners() {
        //Set a listener on the Settings button
        messages_sort_az.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortByName();
            }
        });

        //Set a listener on the Settings button
        messages_sort_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortByDate();
            }
        });

        //Set a listener on each of the notes
        messagesAdapter.setClickListener(new MessagesAdapter.ItemClickListener() {
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
            messagesTextView.setText(R.string.message_et);
        } else {
            messagesTextView.setText(R.string.messages_et);
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