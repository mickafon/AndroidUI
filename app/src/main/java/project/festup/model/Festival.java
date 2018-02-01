package project.festup.model;

import java.util.Date;

/**
 * Created by aimee on 27/01/2018.
 */

public class Festival {

    //TODO : All

    String name;
    Date startDate;
    Date endDate;
    String location;

    public Festival(String name, String location) {
        this.name = name;
        this.startDate = new Date(2018, 03, 8);
        this.endDate = new Date(2018, 03, 10);
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
