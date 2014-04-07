package models;

import java.util.List;

/**
 * Created by pat on 4/6/14.
 */
public class Job {
    public String employer;
    public Address location;
    public String start;
    public String end;
    public String title;

    public List<String> accomplishments;

    public Job(){}

    public Job(String employer, Address location, String start, String end, String title, List<String> accomplishments) {
        this.employer = employer;
        this.location = location;
        this.start = start;
        this.end = end;
        this.title = title;
        this.accomplishments = accomplishments;
    }
}
