package models;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingTest {

    @Test
    public void sightingInstantiatesCorrectly() throws  Exception {
        Sighting sighting = setUpSight();
        assertTrue(sighting instanceof  Sighting);
    }

    @Test
    public void sightingInstantiatesWithLocale() throws Exception{
        Sighting sighting = setUpSight();
        assertEquals("Zone 3",sighting.getLocation());
    }

    @Test
    public void sightingInstantiatesWithRName() throws  Exception{
        Sighting sighting = setUpSight();
        assertEquals("Kool", sighting.getRanger_name());
    }

    @Test
    public void sightingInstantiatesWithAnimalName(){
        Sighting sighting = setUpSight();
        assertEquals("Cat", sighting.getAnimal_name());
    }

    @Test
    public void sightingInstantiatesWithIs() throws  Exception{
        Sighting sighting = setUpSight();
        assertEquals(0,sighting.getId());
    }

    @Test
    public void equalReturnsTrue(){
        Sighting sighting = setUpSight();
        Sighting sighting1 = setUpSight();
        assertTrue(sighting.equals(sighting1));
    }

    public Sighting setUpSight(){
        return  new Sighting("Zone 3","Kool","Cat");
    }
}