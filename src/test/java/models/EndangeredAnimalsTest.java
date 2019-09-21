package models;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalsTest {


    @Test
    public void eAnimalInstantiatesAccurately() throws Exception{
        EndangeredAnimals endangeredAnimals = setUpAnimal();
        assertTrue(endangeredAnimals instanceof EndangeredAnimals);
    }
    @Test
    public void instantiatesWithRanger() throws Exception{
        EndangeredAnimals endangeredAnimals = setUpAnimal();
        assertEquals("Sew",endangeredAnimals.getRanger_name());
    }

    @Test
    public void animalInstantiatesWithName() throws Exception{
       EndangeredAnimals endangeredAnimals = setUpAnimal();
        assertEquals("Dog",endangeredAnimals.getAnimal_name());
    }

    @Test
    public void animalInstantiatesWithAnId() throws  Exception{
        EndangeredAnimals endangeredAnimals = setUpAnimal();
        assertEquals(0,endangeredAnimals.getId());
    }

    @Test
    public void animalInstantiatesWithHealth() throws Exception{
        EndangeredAnimals endangeredAnimals = setUpAnimal();
        assertEquals("ill",endangeredAnimals.getAnimal_health());
    }

    @Test
    public void equalReturnsEqualIfSame() throws Exception{
      EndangeredAnimals endangeredAnimals = setUpAnimal();
      EndangeredAnimals endangeredAnimals1 = setUpAnimal();
        assertTrue(endangeredAnimals.equals(endangeredAnimals1));
    }

    public EndangeredAnimals setUpAnimal(){
        return new EndangeredAnimals("Sew","Dog","ill","young","Zone 2");
    }
}