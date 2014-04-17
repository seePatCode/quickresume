package models;

/**
 * Created by pat on 4/6/14.
 */
public class Skill {
    public String name;
    public String description;

    public Skill(){}

    public Skill(boolean initializeForJSON) {
        this();
    }

    public Skill(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }
}
