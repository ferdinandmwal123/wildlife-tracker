package models;

public class EndangeredAnimals {

    private int id;
    private String ranger_name;
    private String animal_name;
    private String animal_health;
    private String animal_age;
    private int sighting_id;
    private String location;

    public EndangeredAnimals(String ranger_name,String animal_name, String animal_health, String animal_age, String location) {
        this.animal_name = animal_name;
        this.animal_health = animal_health;
        this.animal_age = animal_age;
        this.location= location;
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
