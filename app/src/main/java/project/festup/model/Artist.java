package project.festup.model;


import android.graphics.Bitmap;

import java.util.ArrayList;

public class Artist {
    protected int id;
    protected String name;
    protected String description;
    protected boolean valid;
    protected ArrayList<Media> medias;
    protected ArrayList<Platform> platforms;
    protected ArrayList<Festival> festivals;

    public Artist() {
    }

    public Artist(int id, String name, String description, boolean valid, ArrayList<Media> medias, ArrayList<Platform> platforms, ArrayList<Festival> festivals) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.valid = valid;
        this.medias = medias;
        this.platforms = platforms;
        this.festivals = festivals;
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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public ArrayList<Media> getMedias() {
        return medias;
    }

    public void setMedias(ArrayList<Media> medias) {
        this.medias = medias;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<Platform> platforms) {
        this.platforms = platforms;
    }

    public ArrayList<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(ArrayList<Festival> festivals) {
        this.festivals = festivals;
    }
}
