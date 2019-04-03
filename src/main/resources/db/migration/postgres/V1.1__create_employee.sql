-- automatically creates employee_id_seq and makes this table the owner of the created sequence
CREATE TABLE IF NOT EXISTS employee (
	id SERIAL PRIMARY KEY,
	name varchar(20),
	email varchar(50),
	date_of_birth timestamp
) 
