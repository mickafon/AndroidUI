package project.festup.model;

/**
 * Created by Micka on 31/01/2018.
 */

public class Price {
    protected int id;
    protected String name;
    protected float amount;

    public Price() {
    }

    public Price(int id, String name, float amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
