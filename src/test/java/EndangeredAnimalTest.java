//import org.junit.Assert.*;
//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
//
//public class EndangeredAnimalTest {
//
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void endangeredAnimalsInstantiatesCorrectly(){
//   EndangeredAnimal endangeredAnimal = setupEndangeredAnimal();
//   assertTrue(endangeredAnimal instanceof  EndangeredAnimal);
//    }
//
//    @Test
//    public void equalsReturnsTrueIfNameAndAnimalIdAreEqual(){
//        EndangeredAnimal endangeredAnimal = setupEndangeredAnimal();
//        EndangeredAnimal another = setupEndangeredAnimal();
//        assertTrue(endangeredAnimal.equals(another));
//    }
//
//
//
//  public EndangeredAnimal setupEndangeredAnimal(){
//        return new EndangeredAnimal("Tiger",4,"ill","young",2);
//  }
//}
