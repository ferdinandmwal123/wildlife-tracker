import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "ferdinand", "  ");
    }
  @Override
    protected void after(){
        try (Connection conn = DB.sql2o.open()){
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            String deleteJoinsQuery = "DELETE FROM sightings_animals*;";
            conn.createQuery(deleteAnimalsQuery).executeUpdate();
            conn.createQuery(deleteSightingsQuery).executeUpdate();
            conn.createQuery(deleteJoinsQuery).executeUpdate();
        }
  }



}
