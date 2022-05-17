SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS department(
 id int PRIMARY KEY auto_increment,
 departmentname VARCHAR,
 description VARCHAR,
 numberOfEmployees int,
);

CREATE TABLE IF NOT EXISTS users(
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 position VARCHAR,
 role VARCHAR,
 department VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 title VARCHAR,
 content VARCHAR,
 departmentname VARCHAR,
);