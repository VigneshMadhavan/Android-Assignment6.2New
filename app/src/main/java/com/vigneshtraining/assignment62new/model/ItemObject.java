package com.vigneshtraining.assignment62new.model;

/**
 * Created by vimadhavan on 4/6/2017.
 */

public class ItemObject {

    private String title;
    private String description;

    public ItemObject(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ItemObject() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
