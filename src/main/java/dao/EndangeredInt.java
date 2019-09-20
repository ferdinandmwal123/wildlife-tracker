package dao;

import models.EndangeredAnimals;

import java.util.List;

public interface EndangeredInt {
    List<EndangeredAnimals> getAll();

    //CREATE
    void add(EndangeredAnimals endangeredAnimal);

    //READ
    EndangeredAnimals findById(int id);

    //UPDATE
    void update(int id, String animal_name, String animal_health, String animal_age, int sighting_id);

    //DELETE
    void deleteById(int id);
    void clearAllEndangeredAnimals();

}
