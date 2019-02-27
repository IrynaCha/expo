CREATE TABLE department (
  id           SERIAL PRIMARY KEY,
  name         TEXT,
  abbreviation TEXT
);

CREATE TABLE "group" (
  id            SERIAL PRIMARY KEY,
  department_id int,
  name          TEXT,
  CONSTRAINT FK_GROUP_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department (id)
);

CREATE TABLE student (
  id             SERIAL PRIMARY KEY,
  first_name     TEXT,
  last_name      TEXT,
  email          TEXT,
  phone_number   TEXT,
  enrolment_date DATE,
  group_id       int,
  CONSTRAINT FK_STUDENTS_GROUPS FOREIGN KEY (group_id) REFERENCES "group" (id)
);

CREATE TABLE room (
  id     SERIAL PRIMARY KEY,
  number TEXT
);

CREATE TABLE teacher (
  id           SERIAL PRIMARY KEY,
  first_name   TEXT,
  last_name    TEXT,
  email        TEXT,
  phone_number TEXT,
  position     TEXT
);

CREATE TYPE subject_type AS ENUM ('LECTURE', 'PRACTICE');

CREATE TABLE subject (
  id   SERIAL PRIMARY KEY,
  name TEXT
);

CREATE TABLE teacher_subject (
  teacher_id int REFERENCES teacher (id),
  subject_id int REFERENCES subject (id),
  CONSTRAINT teacher_subject_pkey PRIMARY KEY (teacher_id, subject_id)
);

CREATE TABLE department_teacher (
  department_id int REFERENCES department (id),
  teacher_id    int REFERENCES teacher (id),
  CONSTRAINT department_teacher_pkey PRIMARY KEY (department_id, teacher_id)
);

CREATE TABLE department_subject (
  department_id int REFERENCES department (id),
  subject_id    int REFERENCES subject (id),
  CONSTRAINT department_subject_pkey PRIMARY KEY (department_id, subject_id)
);

CREATE TABLE schedule_item (
  id            SERIAL PRIMARY KEY,
  subject_id    INTEGER,
  subject_type  subject_type,
  room_id       int,
  teacher_id    int,
  group_id      int,
  schedule_date DATE
);
