package project.festup.model;

import java.util.Date;

/**
 * Created by aimee on 27/01/2018.
 */

public class Festival {

    int ID;
    String Name;
    Date start;
    Date end;
    Addresses address;
    String info;
    String description;

    public Festival(int ID, String name, Date start, Date endDate, Addresses address, String info, String description) {
        this.ID = ID;
        this.Name = name;
        this.start = start;
        this.end = endDate;
        this.address = address;
        this.info = info;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
