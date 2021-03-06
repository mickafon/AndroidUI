package project.festup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Micka on 21/01/2018.
 */

public class Festival implements Serializable {
    protected int id;
    protected String name;
    protected String begin;
    protected String end;
    protected String description;
    protected String information;
    protected ArrayList<Media> medias;
    protected ArrayList<Scene> scenes;
    protected ArrayList<Artist> artists;
    protected ArrayList<Platform> platforms;
    protected ArrayList<Price> prices;
    protected Address address;

    public Festival() {
    }

    public Festival(int id, String name, String begin, String end, String description, String information, ArrayList<Media> medias, ArrayList<Scene> scenes, ArrayList<Artist> artists, ArrayList<Platform> platforms, ArrayList<Price> prices, Address address) {
        this.id = id;
        this.name = name;
        this.begin = begin;
        this.end = end;
        this.description = description;
        this.information = information;
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

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
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
