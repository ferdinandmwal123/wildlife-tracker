import dao.AnimalD;
import dao.EndangeredAnimalsD;
import dao.SightingD;
import models.Animal;
import models.EndangeredAnimals;
import models.Sighting;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.Spark.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectionString, "ferdinand", "  ");
        EndangeredAnimalsD endangeredAnimals = new EndangeredAnimalsD(sql2o);
        SightingD sighting = new SightingD(sql2o);
        AnimalD animal = new AnimalD(sql2o);
        Map<String, Object> model = new HashMap<>();

        //show all'
        get("/", (request, response) -> {
//            List<Sighting> sightings = sighting.getAll();
//            model.put("sightings",sightings);
//            List<Animal> animals = animal.getAll();
//            model.put("animals",animals);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //create sighting
        get("/sightings/new", (request, response) -> {
            List<Sighting> sightings = sighting.getAll();
            model.put("sightings", sightings);
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            String location = request.queryParams("location");
            String ranger_name = request.queryParams("ranger_name");
            String animal_name = request.queryParams("animal_name");
            Sighting newSighting = new Sighting(location, ranger_name, animal_name);
            sighting.add(newSighting);
            response.redirect("/sightings/all");
            return null;
        }, new HandlebarsTemplateEngine());



        get("/endangered/new", (request, response) -> {
            List<EndangeredAnimals> endangeredAnimals1 = endangeredAnimals.getAll();
            model.put("endangered_animals", endangeredAnimals1);
            return new ModelAndView(model, "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangered", (request, response) -> {
            String ranger_name = request.queryParams("ranger_name");
            String animal_name = request.queryParams("animal_name");
            String animal_age = request.queryParams("animal_age");
            String animal_health = request.queryParams("animal_health");
            String location = request.queryParams("location");
            EndangeredAnimals endangeredAnimals1 = new EndangeredAnimals(ranger_name,animal_name, animal_health, animal_age,location);
            endangeredAnimals.add(endangeredAnimals1);
            response.redirect("/endangered/all");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/sightings/all", (request, response) -> {
            List<Sighting> sightings = sighting.getAll();
            model.put("sightings", sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine() );

        get("/endangered/all", (request, response) -> {
            List<EndangeredAnimals> endangered = endangeredAnimals.getAll();
            model.put("endangered_animals", endangered);
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine() );


    }
}
