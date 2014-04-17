package models;

import java.util.*;

import javax.validation.*;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.data.validation.Constraints.*;
import play.modules.mongodb.jackson.MongoDB;

public class Resume {

    @Id
    @ObjectId
    public String id;

    public String name;
    public String title;
    public Address address;
    public String website;
    public String email;
    public String phone;
    
    public List<Job> employment;
    public List<School> education;
    public List<Skill> skills;
    
    public Resume()
    {
        address=new Address();
        employment=new ArrayList<Job>();
        education = new ArrayList<School>();
        skills = new ArrayList<Skill>();
    }
    public Resume(boolean initializeForJSON)
    {
        this();
        if(!initializeForJSON) {
            return;
        }
        employment.add(new Job(initializeForJSON));
        education.add(new School(initializeForJSON));
        skills.add(new Skill(initializeForJSON));
    }

    public Resume(String name, String title, Address address, String website, String email, String phone, List<Job> employment, List<School> education, List<Skill> skills) {
        this.name = name;
        this.title = title;
        this.address = address;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.employment = employment;
        this.education = education;
        this.skills = skills;
    }
    public void save()
    {
        create(this);
    }
    public void delete()
    {
        delete(this.id);
    }

    private static JacksonDBCollection<Resume, String> coll = MongoDB.getCollection("resumes", Resume.class, String.class);

    public static List<Resume> all() {
        return Resume.coll.find().toArray();
    }
    public static void drop() {
        Resume.coll.drop();
    }
    public static void create(Resume resume) {
        Resume.coll.save(resume);
    }

    public static void delete(String id) {
        Resume resume = Resume.coll.findOneById(id);
        if (resume != null)
            Resume.coll.remove(resume);
    }
}