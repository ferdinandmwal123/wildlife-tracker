import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Animal implements DatabaseManagement{
    public String animal_name;
    public int sighting_id;
    private int id;
    public String type;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return sighting_id == animal.sighting_id &&
                id == animal.id &&
                Objects.equals(animal_name, animal.animal_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal_name, sighting_id, id);
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public int getSighting_id() {
        return sighting_id;
    }

    public int getId() {
        return id;
    }

    public static List<Animal> all(){
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    @Override
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animal_name, squad_id, type) VALUES (:animal_name, :sighting_id, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_name", this.animal_name)
                    .addParameter("sighting_id", this.sighting_id)
                    .addParameter("type",this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    public List<Object> getAnimals() {
        List<Object> allAnimals = new ArrayList<Object>();

        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE sighting_id=:id AND type='endangered';";
            List<EndangeredAnimal> endangeredAnimals = con.createQuery(sql)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
            allAnimals.addAll(endangeredAnimals);

        }
            return allAnimals;
    }

    public List<Sightings> getSightings() {
        try(Connection con = DB.sql2o.open()){
            String joinQuery = "SELECT sighting_id FROM sightings_animals WHERE animal_id = :animal_id";
            List<Integer> sightingIds = con.createQuery(joinQuery)
                    .addParameter("animal_id", this.getId())
                    .executeAndFetch(Integer.class);

            List<Sightings> sightings = new ArrayList<Sightings>();

            for (Integer sighting_id : sightingIds) {
                String sightingQuery = "SELECT * FROM sightings WHERE id = :sighting_id";
                Sightings sighting = con.createQuery(sightingQuery)
                        .addParameter("sighting_id", sighting_id)
                        .executeAndFetchFirst(Sightings.class);
                sightings.add(sighting);
            }
            return sightings;
        }
    }

    public void leaveSighting(Sightings sightings){
        try(Connection con = DB.sql2o.open()){
            String joinRemovalQuery = "DELETE FROM sightings_animals WHERE sighting_id = :sighting_id AND animal_id = :animal_id;";
            con.createQuery(joinRemovalQuery)
                    .addParameter("sighting_id", sightings.getId())
                    .addParameter("animal_id", this.getId())
                    .executeUpdate();
        }
    }

    @Override
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
            String joinDeleteQuery = "DELETE FROM sightings_animals WHERE animal_id = :animal_id";
            con.createQuery(joinDeleteQuery)
                    .addParameter("animal_id", this.getId())
                    .executeUpdate();
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}