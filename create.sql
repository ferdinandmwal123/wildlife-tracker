SET MODE PostgreSql;


CREATE TABLE IF NOT EXISTS animals(
id serial PRIMARY KEY,
 animal_name varchar,
  sighting_id int
  );

  CREATE TABLE IF NOT EXISTS sightings (
  id serial PRIMARY KEY,
  location varchar ,
  ranger_name varchar,
  animal_name varchar
  );

CREATE TABLE IF NOT EXISTS endangered_animals (
id serial PRIMARY KEY,
ranger_name varchar,
 animal_name varchar,
  animal_age varchar,
   animal_health varchar,
    location varchar
);




