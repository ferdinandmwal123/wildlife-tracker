package dao;

import models.*;

import java.util.List;

public interface AnimalInt {

    List<Animal> getAll();

    void add(Animal animal);

    Animal findById(int id);
    List<EndangeredAnimals> getAllEndangeredAnimalsByAnimal(int animal_id);


    void update(int id, int sighting_id, String animal_name);

    void clearAllAnimals();

}
