CREATE TABLE IF NOT EXISTS group (
	id SERIAL PRIMARY KEY,
	name TEXT
);

CREATE TABLE IF NOT EXISTS student (
	id SERIAL PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	email TEXT,
	phone_number TEXT,
	enrolment_date DATE,
	group_id INTEGER,
	CONSTRAINT FK_STUDENTS_GROUPS FOREIGN KEY(group_id) REFERENCES group(id)
);
