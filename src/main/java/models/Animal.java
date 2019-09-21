package models;

import java.util.Objects;

public class Animal extends MainAnimal{

    private int id;
    private String type;


    public Animal(String animal_name, int sighting_id) {
        this.animal_name = animal_name;
        this.sighting_id = sighting_id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                Objects.equals(type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getSighting_id() {
        return sighting_id;
    }

    public void setSighting_id(int sighting_id) {
        this.sighting_id = sighting_id;
    }
}
