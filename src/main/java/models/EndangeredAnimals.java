package models;

import java.util.Objects;

public class EndangeredAnimals extends MainAnimal{

    private int id;
    private String ranger_name;

    private String animal_health;
    private String animal_age;

    private String location;

    public EndangeredAnimals(String ranger_name,String animal_name, String animal_health, String animal_age, String location) {
        this.animal_name = animal_name;
        this.animal_health = animal_health;
        this.animal_age = animal_age;
        this.location= location;
        this.ranger_name = ranger_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimals that = (EndangeredAnimals) o;
        return id == that.id &&
                Objects.equals(ranger_name, that.ranger_name) &&
                Objects.equals(animal_health, that.animal_health) &&
                Objects.equals(animal_age, that.animal_age) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ranger_name, animal_health, animal_age, location);
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public void setRanger_name(String ranger_name) {
        this.ranger_name = ranger_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getAnimal_health() {
        return animal_health;
    }

    public void setAnimal_health(String animal_health) {
        this.animal_health = animal_health;
    }

    public String getAnimal_age() {
        return animal_age;
    }

    public void setAnimal_age(String animal_age) {
        this.animal_age = animal_age;
    }

    public int getSighting_id() {
        return sighting_id;
    }

    public void setSighting_id(int sighting_id) {
        this.sighting_id = sighting_id;
    }
}
