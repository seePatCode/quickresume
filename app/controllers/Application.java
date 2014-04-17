package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Resume;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result testing() {
        return ok(resume.render());
    }
    public static Result getResume() {
        //This will only work if you ran test already to populate your DB with a resume
        Resume temp;
       // temp = Resume.all().get(0);
        temp = new Resume(true);
        ObjectNode result = Json.newObject();
        return ok(toJson(temp));
    }
}
