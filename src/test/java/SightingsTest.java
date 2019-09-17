//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class SightingsTest {
//
//    @Test
//    public void sightingsInstantiatesSightings(){
//        Sightings sightings = setUpSightings();
//        assertTrue(sightings instanceof Sightings);
//    }
//
//    @Test
//    public void sightingsInstantiatesWithAnimalId(){
//        Sightings sightings = setUpSightings();
//        assertEquals(1,sightings.getAnimal_id());
//    }
//
//    @Test
//    public void equalsReturnsTrueIfSightingsAreSame(){
//        Sightings sightings = setUpSightings();
//        Sightings sightings1 = setUpSightings();
//        assertTrue(sightings.equals(sightings1));
//    }
//
//    @Test
//    public void saveSaves(){
//        Sightings sightings = setUpSightings();
//        sightings.save();
//        assertTrue(Sightings.all().get(0).equals(sightings));
//    }
//
//    @Test
//    public void saveAssignsIdToSightings(){
//        Sightings sightings = setUpSightings();
//        sightings.save();
//        Sightings savedSighting = Sightings.all().get(0);
//        assertEquals(savedSighting.getId(), savedSighting.getId());
//    }
//
//    @Test
//    public void allReturnsAllInstancesOfSightings_true(){
//        Sightings sightings =setUpSightings();
//        sightings.save();
//        Sightings sightings1 = new Sightings(4,"Zone 2","peter");
//        assertEquals(true, Sightings.all().get(0).equals(sightings));
//        assertEquals(true, Sightings.all().get(4).equals(sightings1));
//
//    }
//
//    @Test
//    public void findReturnsSightingWithSameId(){
//        Sightings sightings = setUpSightings();
//        sightings.save();
//        Sightings sightings1 = new Sightings(1,"Zone 2","John");
//        sightings1.save();
//        assertEquals(Sightings.find(sightings1.getId()), sightings1);
//    }
//
//
//    @Test
//    public void saveSavesAnimalIntoDB_TRUE(){
//       Animal animal = new Animal("Goat");
//       animal.save();
//       Sightings sightings = setUpSightings();
//       sightings.save();
//       Sightings sightingsSaved = Sightings.find(sightings.getId());
//       assertEquals(sightingsSaved.getAnimal_id(), animal.getId());
//    }
//
//    private Sightings setUpSightings(){
//        return new Sightings(1,"Zone 1","ferdinand");
//    }
//}