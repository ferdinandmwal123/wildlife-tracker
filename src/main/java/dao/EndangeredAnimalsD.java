package dao;

import models.EndangeredAnimals;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class EndangeredAnimalsD implements  EndangeredInt{

    private final Sql2o sql2o;

    public EndangeredAnimalsD(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<EndangeredAnimals> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered_animals")
                    .executeAndFetch(EndangeredAnimals.class);
        }
    }

    @Override
    public void add(EndangeredAnimals endangeredAnimals) {
        String sql = "INSERT INTO endangered_animals (ranger_name,animal_name, animal_health, animal_age, location) VALUES (:ranger_name, :animal_name, :animal_health, :animal_age, :location)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(endangeredAnimals)
                    .executeUpdate()
                    .getKey();
            endangeredAnimals.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public EndangeredAnimals findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered_animalss WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimals.class);
        }
    }

    @Override
    public void update(int id, String animal_name, String animal_health, String animal_age, int sighting_id) {
        String sql = "UPDATE endangered_animals SET animal_name = :animal_name, animal_health = :animal_health, animal_age = :animal_age, sighting_id = :sighting_id WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("animal_name", animal_name)
                    .addParameter("animal_health", animal_health)
                    .addParameter("animal_age", animal_age)
                    .addParameter("sighting_id", sighting_id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void clearAllEndangeredAnimals() {
        String sql = "DELETE FROM endangered_animals";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM endangered_animals WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
