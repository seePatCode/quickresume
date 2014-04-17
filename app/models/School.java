package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pat on 4/6/14.
 */
public class School {
    public String institution;
    public Address location;
    public String start;
    public String end;
    public String degree;

    public List<String> accomplishments;

    public School(){
        accomplishments = new ArrayList<String>();
    }

    public School(boolean initializeForJSON) {
        this();
        if(!initializeForJSON) {
            return;
        }
        location = new Address();
        accomplishments.add(new String());
    }

    public School(String institution, Address location, String start, String end, String degree, List<String> accomplishments) {
        this.institution = institution;
        this.location = location;
        this.start = start;
        this.end = end;
        this.degree = degree;
        this.accomplishments = accomplishments;
    }
}
