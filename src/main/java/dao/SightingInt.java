package dao;

import models.Animal;
import models.EndangeredAnimals;
import models.Sighting;

import java.util.List;

public interface SightingInt {

    List<Sighting> getAll();

    //CREATE
    void add(Sighting sighting);

    //READ
    Sighting findById(int id);
    List<Animal> getAllAnimalsBySighting(int sighting_id);
    List<EndangeredAnimals> getAllEndangeredAnimalsBySighting(int sighting_id);

    //UPDATE
    void update(int id, String animal_location, String ranger_name);

    //DELETE
    void deleteById(int id);
    void clearAllSightings();
}
