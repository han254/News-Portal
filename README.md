# News-Portal
### By **Peter Njenga**
## Description
A rest API for querying and retrieving scoped news and information that are available to all employees without navigating into any department, and others that are housed/classified within departments.
## Setup/Installation Requirements
* Open Terminal {Ctrl+Alt+T}
* clone ```https://github.com/han254/News-Portal.git```.
* Enter into the folder (cd News-Portal).
* open your IDE (e.g  IntelliJ IDEA)

### SQL Installation/ Setup.
1.Launch postgres

2.Type in psql

Run these commands

```CREATE DATABASE news_portal;```

```CREATE TABLE users(id serial PRIMARY KEY,name text,role varchar,department_id int);```

```CREATE TABLE departments(id serial PRIMARY KEY,name varchar,description varchar,employees int);```

```CREATE TABLE news(id serial PRIMARY KEY,text varchar,department varchar);```

### Author's Information
* Github: [Peter Njenga](https://github.com/han254)
* Twitter handle: [https://twitter.com/Hanselpeter4]
* LinkedIn: [www.linkedin.com/in/peter-njenga]
## Technologies Used
* Java
* Spark
### Support and contact details

You can contact me through my email[peternjenga1706@gmail.com]

### License

Copyright (c) 2022 [click here to view license](LICENSE)