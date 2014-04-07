package models;

import java.util.*;

import javax.validation.*;

import play.data.validation.Constraints.*;

public class Resume {

    public String name;
    public String title;
    public Address address;
    public String website;
    public String email;
    public String phone;
    
    public List<Job> employment;
    public List<School> education;
    public List<Skill> skills;
    
    public Resume() {}
    
}