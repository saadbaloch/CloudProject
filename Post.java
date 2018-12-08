package com.example.saad.traveljournal;

/**
 * Created by saad on 09/12/2018.
 */

public class Post {

    private String url;
    private String description;
    private String location;
    private Float rating;

    public Post() {

    }

    public Post(String url, String description, String location, Float rating) {
        this.url = url;
        this.description = description;
        this.location = location;
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
