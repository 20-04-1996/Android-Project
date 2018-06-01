package com.json.pankaj.jsonparsing.model;

public class Anim {

    private String name;
    private String description;
    private String rating;
    private String episode;
    private String catagories;
    private String studio;
    private String image_url;

    public Anim(){

    }

    public Anim(String name, String description, String rating, String episode, String catagories, String studio, String image_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.episode = episode;
        this.catagories = catagories;
        this.studio = studio;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getEpisode() {
        return episode;
    }

    public String getCatagories() {
        return catagories;
    }

    public String getStudio() {
        return studio;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public void setCatagories(String catagories) {
        this.catagories = catagories;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
