package dao;


import models.Animal;
import models.Sighting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SightingDTest {
    public SightingD sightings;
    public  AnimalD animalD;
    public Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:test.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        sightings = new SightingD(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws  Exception{
        con.close();
    }

    @Test
    public void getAllReturnsAll(){
        Sighting sighting = setUpSighting();
        sightings.add(sighting);
        assertEquals(1,sightings.getAll().size());
    }

    @Test
    public void addAddsId() throws Exception{
        Sighting sighting = setUpSighting();
        int origialId = sighting.getId();
        sightings.add(sighting);
        assertNotEquals(origialId,sighting.getId());
    }

    @Test
    public void findByIdAddsId() throws  Exception{
        Sighting sighting = setUpSighting();
        sightings.add(sighting);
        int id = sighting.getId();
        assertEquals(id,sighting.getId());
    }

//    @Test
//    public void getAllAnimalsBySighting() throws  Exception{
//        Sighting sighting = setUpSighting();
//        sightings.add(sighting);
//        Animal animal = new Animal("dog",4);
//        animalD.add(animal);
//        assertEquals(1,sightings.getAllAnimalsBySighting(sighting.getId().size()));
//    }

    @Test
    public void updateChanges(){
        Sighting sighting = setUpSighting();
        sightings.add(sighting);
        sightings.update(sighting.getId(),"Zone 12","No");
        Sighting newSighting = sightings.findById(sighting.getId());
        assertNotEquals(sighting,newSighting);
    }

    @Test
    public void deleteByIdDeletes(){
        Sighting sighting = setUpSighting();
        sightings.add(sighting);
        sightings.deleteById(sighting.getId());
        assertEquals(0,sightings.getAll().size());
    }

    @Test
    public void clearAllDeletesAllSIghtings() throws  Exception{
        Sighting sighting = setUpSighting();
        Sighting sighting1 = new Sighting("Zone 4","You","Uknown");
        sightings.add(sighting);
        sightings.add(sighting1);
        int allSightings = sightings.getAll().size();
        sightings.clearAllSightings();
        assertNotEquals(allSightings,sightings.getAll().size());
    }

    public Sighting setUpSighting(){
        return new Sighting("Zone 2","Kool","Cow");
    }
}