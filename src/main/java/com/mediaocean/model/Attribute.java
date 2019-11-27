package com.mediaocean.model;

public class Attribute {
    private String title;
    private String summary;
    private String visibility;
    private String createdAt;
    private String modifiedAt;


    // Getter Methods

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    // Setter Methods

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}