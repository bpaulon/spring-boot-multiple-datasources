-- create sequence hibernate_sequence start with 1 increment by 1;

-- Create the users Database
CREATE TABLE IF NOT EXISTS employee (
	id SERIAL PRIMARY KEY,
	name varchar(20),
	email varchar(50),
	date_of_birth timestamp
) 