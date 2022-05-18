package com.example.entmobile.notes;

/**
 * This is the Note class. It is part of the model used in the Notes section of the app.
 * It has a few constructor, getters, and setters.
 *
 * This class is in charge of storing the different Note objects, for their use in the Notes section.
 */
public class Note {
    /**
     *
     */
    private String category;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String content;

    /**
     *
     * @param newNoteCategory
     * @param newNoteTitle
     * @param newNoteContent
     */
    public Note(String newNoteCategory, String newNoteTitle, String newNoteContent) {
        this.category = newNoteCategory;
        this.title = newNoteTitle;
        this.content = newNoteContent;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
