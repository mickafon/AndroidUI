package project.festup.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Micka on 21/01/2018.
 */

public class Festival {
    protected int id;
    protected String name;
    protected Date begin;
    protected Date end;
    protected String description;
    protected String information;
    protected boolean valid;
    protected ArrayList<Media> medias;
    protected ArrayList<Scene> scenes;
    protected ArrayList<Artist> artists;
    protected ArrayList<Platform> platforms;
    protected ArrayList<Price> prices;
    protected Address address;

    public Festival() {
    }

    public Festival(int id, String name, Date begin, Date end, String description, String information, boolean valid, ArrayList<Media> medias, ArrayList<Scene> scenes, ArrayList<Artist> artists, ArrayList<Platform> platforms, ArrayList<Price> prices, Address address) {
        this.id = id;
        this.name = name;
        this.begin = begin;
        this.end = end;
        this.description = description;
        this.information = information;
        this.valid = valid;
        this.medias = medias;
        this.scenes = scenes;
        this.artists = artists;
        this.platforms = platforms;
        this.prices = prices;
        this.address = address;
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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<Platform> platforms) {
        this.platforms = platforms;
    }

    public ArrayList<Price> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Price> prices) {
        this.prices = prices;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
