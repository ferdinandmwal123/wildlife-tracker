//import org.junit.Rule;
//import org.junit.Test;
//
//import java.util.Arrays;
//
//import static org.junit.Assert.*;
//
//public class AnimalTest {
//
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//    @Test
//    public void animalInstantiatesCorrectly(){
//        Animal animal = setUpAnimal();
//        assertEquals(true, animal instanceof Animal);
//    }
//
//    @Test
//    public void getNameInstantiatesWithNameGoat(){
//        Animal animal = setUpAnimal();
//        assertEquals("Goat", animal.getName());
//    }
//
//    @Test
//    public void equalsReturnTrueIfNamesAreSame(){
//        Animal animal =setUpAnimal();
//        Animal animalS = new Animal("Goat");
//        assertTrue(animal.equals(animalS));
//    }
//
//    @Test
//    public void saveInsertsObjectIntoDatabase(){
//        Animal animal = setUpAnimal();
//        animal.save();
//        assertTrue(Animal.all().get(0).equals(animal));
//    }
//
//    @Test
//    public void allReturnsAllInstancesOfAnimal(){
//        Animal animal = setUpAnimal();
//        animal.save();
//        Animal animalS = new Animal("Punda");
//        animalS.save();
//        assertEquals(true, Animal.all().get(0).equals(animal));
//        assertEquals(true, Animal.all().get(1).equals(animalS));
//
//    }
//
//    @Test
//    public void saveAssignsIdToObject(){
//        Animal animal = setUpAnimal();
//        animal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(animal.getId(),savedAnimal.getId());
//    }
//
//    @Test
//    public void findReturnsAnimalWithSameIdSecondAnimal(){
//        Animal animal = setUpAnimal();
//        animal.save();
//        Animal animal2 = new Animal("Punda");
//        animal2.save();
//        assertEquals(Animal.find(animal2.getId()), animal2);
//    }
//    @Test
//    public void getSightingss_retrievesAllSightingssFromDatabase_sightingssList() {
//        Animal testAnimal = new Animal("Henry");
//        testAnimal.save();
//        Sightings firstSightings = new Sightings(4, "Zone 3","Peter");
//        firstSightings.save();
//        Sightings secondSightings = new Sightings(4,"Zone 2", "John");
//        secondSightings.save();
//        Sightings[] sightings = new Sightings[] { firstSightings, secondSightings };
//        assertTrue(testAnimal.getSightings().containsAll(Arrays.asList(sightings)));
//    }
//
//    public Animal setUpAnimal(){
//        return new Animal("Goat");
//    }
//}