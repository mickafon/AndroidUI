package project.festup.model;

/**
 * Created by aimee on 01/02/2018.
 */

public class Addresses {

    int id;
    String name;
    String additional;
    String street;
    String postal;
    String city;

    public Addresses(int id, String name, String additional, String street, String postal, String city) {
        this.id = id;
        this.name = name;
        this.additional = additional;
        this.street = street;
        this.postal = postal;
        this.city = city;
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

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name + ": " + additional + " " + street + " " + postal + " " + city;
    }
}
