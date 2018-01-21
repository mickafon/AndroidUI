package project.festup.model;


import android.graphics.Bitmap;

public class Artist {
    protected int id;
    protected String thumb;
    protected String title;
    protected String resource_url;

    public Artist() {
    }

    public Artist(int id, String thumb, String title, String resource_url) {
        this.id = id;
        this.thumb = thumb;
        this.title = title;
        this.resource_url = resource_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }

    /*protected int id;
    protected String name;
    protected String description;
    protected String facebook;
    protected String twitter;
    protected String wikipedia;
    protected String youtube;
    protected Media media;


    public Artist() {
    }

    public Artist(int id, String name, String description, String facebook, String twitter, String wikipedia, String youtube, Media media) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.facebook = facebook;
        this.twitter = twitter;
        this.wikipedia = wikipedia;
        this.youtube = youtube;
        this.media = media;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }*/
}
