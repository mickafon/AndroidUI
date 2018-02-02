package project.festup.model;

import java.util.Date;

/**
 * Created by Micka on 31/01/2018.
 */

public class Timetable {
    protected int id;
    protected Date time;
    protected Festival festival;
    protected Scene scene;
    protected Artist artist;


    public Timetable() {
    }

    public Timetable(int id, Date time, Festival festival, Scene scene, Artist artist) {
        this.id = id;
        this.time = time;
        this.festival = festival;
        this.scene = scene;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
