package project.festup.model;

/**
 * Created by Micka on 17/01/2018.
 */

public class Media {
    protected int id;
    protected String name;
    protected String url;

    public Media() {
    }

    public Media(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
