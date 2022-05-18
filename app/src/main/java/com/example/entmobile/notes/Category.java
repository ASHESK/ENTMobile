package com.example.entmobile.notes;

/**
 * This is the Category class. It is part of the model used in the Notes section of the app.
 * It has a few constructor, getters, and setters.
 *
 * This class is in charge of storing the different Category objects, for their use in the Notes section.
 */
public class Category {
    /**
     * This variable is used to store the name of a category
     */
    private String name;

    /**
     * This variable is used to store whether or not a category is set to displayed.
     * If true, all the notes with this category will be visible.
     */
    private boolean displayed;

    /**
     * This is the constructor of this object. It takes two parameters.
     * @param name          The name is the variable used to store the name of a category
     * @param isDisplayed   Variable is used to store whether or not a category is set to displayed.
     */
    public Category(String name, Boolean isDisplayed) {
        this.name = name;
        this.displayed = isDisplayed;
    }

    /**
     * Getter used to when trying to know if a category is displayed or not.
     * @return true if the category is displayed
     */
    public boolean isDisplayed() {
        return displayed;
    }

    /**
     * Getter used to retrieve the name of a category.
     * @return the name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Setter used to set the name of a category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter used to set whether a category is displayed or not.
     */
    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }
}
