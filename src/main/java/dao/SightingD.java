package dao;

import models.Animal;
import models.EndangeredAnimals;
import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class SightingD implements SightingInt {
    private final Sql2o sql2o;

    public SightingD(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public List<Sighting> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Sighting.class);
        }
    }

//    @Override
//    public List<Sighting> getAll() {
//        return null;
//    }

    @Override
    public void add(Sighting sighting) {
        String sql = "INSERT INTO sightings (location, ranger_name, animal_name) VALUES (:location, :ranger_name , :animal_name)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(sighting)
                    .executeUpdate()
                    .getKey();
            sighting.setId(id);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public Sighting findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM sightings WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
    }

    @Override
    public List<Animal> getAllAnimalsBySighting(int sighting_id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animals WHERE sighting_id = :sighting_id")
                    .addParameter("sighting_id", sighting_id)
                    .executeAndFetch(Animal.class);
        }
    }

    @Override
    public List<EndangeredAnimals> getAllEndangeredAnimalsBySighting(int sighting_id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered_animals WHERE sighting_id = :sighting_id")
                    .addParameter("sighting_id", sighting_id)
                    .executeAndFetch(EndangeredAnimals.class);
        }
    }

    @Override
    public void update(int id, String location, String ranger_name) {
        String sql = "UPDATE sightings SET location = :location, ranger_name = :ranger_name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("location", location)
                    .addParameter("ranger_name", ranger_name)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from sightings WHERE id=:id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllSightings() {
        String sql = "DELETE from sightings"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
