package org.launchcode.cheesemvc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Matt on 5/25/2017.
 */
public class Cheese {
    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;

    private CheeseType type;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    private int cheeseId;
    private static int nextId = 1;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }
    public void setName(String aName) {
        name = aName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public int getCheeseId() {return cheeseId;}
    public void setCheeseId(int cheeseId) {this.cheeseId = cheeseId;}

    public CheeseType getType() {return type;}
    public void setType(CheeseType type) {this.type = type;}

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}
}
