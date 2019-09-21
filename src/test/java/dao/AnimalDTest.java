package dao;


import models.Animal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AnimalDTest {
     private AnimalD animalD;
     private Connection con;

     @Before
     public void setUp() throws Exception {
         String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:test.sql'";
         Sql2o sql2o = new Sql2o(connectionString,"","");
         animalD = new AnimalD(sql2o);
         con = sql2o.open();
     }

     @After
     public void tearDown() throws  Exception{
         con.close();
     }

    @Test
    public void addAddsId() throws  Exception{
        Animal animal = setUpAnimal();
        int originalId = animal.getId();
        animalD.add(animal);
        assertNotEquals(originalId,animal.getId());
    }

    @Test
    public void getAllReturnsAllAnimals(){
         Animal animal = setUpAnimal();
         animalD.add(animal);
         assertEquals(1,animalD.getAll().size());
    }

    @Test
    public void findByIdReturnsId(){
         Animal animal = setUpAnimal();
         animalD.add(animal);
         int id = animal.getId();
         assertEquals(animal.getId(),id);
    }

    @Test
    public void updateChangesData(){
         Animal animal = setUpAnimal();
         animalD.add(animal);
         animalD.update(animal.getId(),5,"Wolf");
         Animal newAnimal = animalD.findById(animal.getId());
         assertNotEquals(animal,newAnimal);
    }

//   @Test
//   public void getEndangeredAnimalByAnimal() throws Exception{
//         Animal animal = setUpAnimal();
//
//   }

   @Test
   public void clearAllAnimalsReturnsNoANimal(){
         Animal animal = setUpAnimal();
         animalD.add(animal);
         animalD.clearAllAnimals();
         assertEquals(0,animalD.getAll().size());

   }

    public Animal setUpAnimal(){
        return  new Animal("Dog",4);
    }
}