package dao;

import models.EndangeredAnimals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class EndangeredAnimalsDTest {

    public EndangeredAnimalsD endangered;
    public Connection con;
    @Before
    public void setUp() throws Exception {
    String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:test.sql'";
    Sql2o sql2o = new Sql2o(connectionString,"","");
    endangered = new EndangeredAnimalsD(sql2o);
    con = sql2o.open();
}

    @After
    public void tearDown() throws  Exception{
        con.close();
    }

    @Test
    public void getAllReturnsAll() throws Exception{
       EndangeredAnimals endangeredAnimals = setUpEndangeredAnimals();
       endangered.add(endangeredAnimals);
       assertEquals(1,endangered.getAll().size());
    }

    @Test
    public void addAddsCorrectly() throws  Exception {
        EndangeredAnimals endangeredAnimals = setUpEndangeredAnimals();
        endangered.add(endangeredAnimals);
        int firstId = endangeredAnimals.getId();
        assertNotEquals(firstId,endangeredAnimals.getId());
    }

    @Test
    public void findByIDWorks(){
        EndangeredAnimals endangeredAnimals = setUpEndangeredAnimals();
        endangered.add(endangeredAnimals);
        int id = endangeredAnimals.getId();
        assertEquals(id,endangeredAnimals.getId());
    }
    @Test
    public void updateChangesDetails(){
        EndangeredAnimals endangeredAnimals = setUpEndangeredAnimals();
        endangered.add(endangeredAnimals);
        endangered.update(endangeredAnimals.getId(),"fish","okay","old",3);
        EndangeredAnimals endangeredAnimals1 = endangered.findById(endangeredAnimals.getId());
        assertNotEquals(endangeredAnimals,endangeredAnimals1);
    }

    @Test
    public void clearClearsAll(){
        EndangeredAnimals endangeredAnimals = setUpEndangeredAnimals();
        endangered.add(endangeredAnimals);
        endangered.clearAllEndangeredAnimals();
        assertEquals(0,endangered.getAll().size());
    }

    public EndangeredAnimals setUpEndangeredAnimals(){
        return new EndangeredAnimals("kool","cat","ill","young","zone 2");
    }
}