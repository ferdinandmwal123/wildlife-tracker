import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class EndangeredAnimal extends Animal implements DatabaseManagement{

    public static final String DATABASE_TYPE = "endangered";

    public EndangeredAnimal(String animal_name, int sighting_id) {
        this.animal_name = animal_name;
        this.sighting_id =sighting_id;

        type = DATABASE_TYPE;
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='endangered';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal endangeredAnimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return endangeredAnimal;
        }
    }
}