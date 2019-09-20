package models;

public class Sighting {
    private int id;
    private String location;
    private String ranger_name;
    private String animal_name;


    public Sighting(String animal_location, String ranger_name, String animal_name ) {
        this.location = animal_location;
        this.ranger_name = ranger_name;
        this.animal_name = animal_name;

    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public void setRanger_name(String ranger_name) {
        this.ranger_name = ranger_name;
    }
}
