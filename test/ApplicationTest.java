import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import org.junit.*;

import play.Logger;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    FakeApplication app;

    @Before
    public void setUp() throws Exception {
        Map<String, String> config = new HashMap<String, String>();
        config.put("ehcacheplugin", "disabled");
        config.put("mongodbJacksonMapperCloseOnStop", "disabled");
        config.put("mongodb.database", "resumes");
        app = fakeApplication(config);
        running(app, new Runnable() {
            public void run() {
                Resume.drop();
            }
        });
    }

    @Test
    public void createOneModel() {

        running(app, new Runnable() {
            public void run() {
                System.out.println("in runnable...");
                State state = new State("NY");
                Address home = new Address("1 Main St", "Albany", state, "12205");
                Address srHome = new Address("235 Western Ave", "Albany", state, "12205");
                Address workAddr = new Address("1 Fuller Rd.", "Albany", state, "12205");
                List<Skill> skills = new ArrayList<Skill>();
                skills.add(new Skill("Web Design", "HTML5, CSS3, JS, Knockout, AngularJS"));
                skills.add(new Skill("Martial Arts", "Nunchuk, Bow Staff, Flying Crane Kick"));
                List<String> accomplishments = new ArrayList<String>();
                accomplishments.add("Top 5% of class");
                accomplishments.add("Cross Country Team Captain");
                accomplishments.add("Threw the coolest parties!");
                List<School> schools = new ArrayList<School>();
                schools.add(new School("College of Saint Rose", srHome,
                        "Sept 2004", "May 2008", "B.S.C.S.", accomplishments));
                List<Job> jobs = new ArrayList<Job>();
                List<String> accomplishments2 = new ArrayList<String>();
                accomplishments2.add("Best Worker Award");
                accomplishments2.add("Project Manager of Lunch Breaks");
                jobs.add(new Job("GE", home, "May 2008", "June 2012", "Chief Technology Sciencer", accomplishments));
                jobs.add(new Job("IBM", workAddr, "June 2012", "Present", "Lead Destructor", accomplishments));
                Resume resume = new Resume("See PatCode", "Super Developer", home, "seepatcode.com", "pat@seepatcode.com",
                        "(518)867-5309", jobs, schools, skills) ;
                resume.save();
                assertThat(Resume.all().size()).isEqualTo(1);
            }
        });
    }


}
