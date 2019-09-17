import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sightings implements DatabaseManagement{
    private String ranger_name;
    private String location;
    private int id;

    public Sightings(String ranger_name, String location) {
        this.ranger_name = ranger_name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id &&
                Objects.equals(ranger_name, sightings.ranger_name) &&
                Objects.equals(location, sightings.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranger_name, location, id);
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    @Override
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (ranger_name, location) VALUES (:ranger_name, :location)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("ranger_name", this.ranger_name)
                    .addParameter("location", this.location)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings";
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }

    public static Sightings find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";

            Sightings sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sightings;
        }
    }

    public List<Animal> getAnimals() {
        try(Connection con = DB.sql2o.open()){
            String joinQuery = "SELECT animal_id FROM sightings_animals WHERE sighting_id = :sighting_id";
            List<Integer> animalIds = con.createQuery(joinQuery)
                    .addParameter("sighting_id", this.getId())
                    .executeAndFetch(Integer.class);

            List<Animal> animals = new ArrayList<Animal>();

            for (Integer animal_id : animalIds) {
                String animalQuery = "SELECT * FROM animals WHERE id = :animal_id";
                Animal animal = con.createQuery(animalQuery)
                        .addParameter("animal_id",animal_id)
                        .executeAndFetchFirst(Animal.class);
                animals.add(animal);
            }
            return animals;
        }
    }

    public void addAnimal(Animal animal){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings_animals (sighting_id, animal_id) VALUES (:sighting_id, :animal_id)";
            con.createQuery(sql)
                    .addParameter("sighting_id",this.getId())
                    .addParameter("animal_id", animal.getId())
                    .executeUpdate();
        }
    }

    @Override
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
            String joinDeleteQuery = "DELETE FROM sightings_animals WHERE sighting_id = :sighting_id";
            con.createQuery(joinDeleteQuery)
                    .addParameter("sighting_id",this.getId())
                    .executeUpdate();

        }
    }

    public void removeAnimal(Animal animal){
        try(Connection con = DB.sql2o.open()){
            String joinRemovalQuery = "DELETE FROM sightings_animals WHERE sighting_id = :sighting_id AND animal_id = :animal_id;";
            con.createQuery(joinRemovalQuery)
                    .addParameter("sighting_id", this.getId())
                    .addParameter("animal_id", animal.getId())
                    .executeUpdate();
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}
