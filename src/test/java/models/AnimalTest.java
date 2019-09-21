package models;


import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void animalInstantiatesCorrectly() throws Exception{
        Animal animal = setUpAnimal();
        assertTrue(animal instanceof Animal);
    }

    @Test
    public void animalInstantiatesWithName() throws Exception{
        Animal animal = setUpAnimal();
        assertEquals("fish",animal.getAnimal_name());
    }

    @Test
    public void animalInstantiatesWithAnId() throws  Exception{
        Animal animal = setUpAnimal();
        assertEquals(0,animal.getId());
    }

    @Test
    public void animalInstantiatesWithASighting() throws Exception{
        Animal animal = setUpAnimal();
        assertEquals(4,animal.getSighting_id());
    }

    @Test
    public void equalReturnsEqualIfSame() throws Exception{
        Animal animal = setUpAnimal();
        Animal animal1 = setUpAnimal();
        assertTrue(animal.equals(animal1));
    }
    public Animal setUpAnimal(){
        return new Animal("fish",4);
    }
}