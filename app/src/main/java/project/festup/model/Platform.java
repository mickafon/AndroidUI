package project.festup.model;

/**
 * Created by Micka on 31/01/2018.
 */

public class Platform {
    protected int id;
    protected String name;
    protected String url;
    protected Type type;

    public Platform() {
    }

    public Platform(int id, String name, String url, Type type) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

