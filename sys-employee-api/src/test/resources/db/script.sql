/**********************************************************************/
/* SQL Server sample database                                  */
/**********************************************************************/

IF NOT EXISTS(SELECT * FROM sys.databases WHERE name = 'company')
    CREATE DATABASE company;

USE company;

if exists (select * from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'employees' AND TABLE_SCHEMA = 'dbo')
    drop table dbo.employees;

CREATE TABLE employees (
  no INT IDENTITY(1,1) PRIMARY KEY ,
  dob DATE NOT NULL,
  first_name VARCHAR(14) NOT NULL,
  last_name VARCHAR(16) NOT NULL,
  gender VARCHAR(1) NOT NULL CHECK (gender IN('M', 'F')),
  hire_date DATE NOT NULL,
);

INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1985-09-02','Chava','Puckett','F','2008-10-12');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1971-12-03','Christopher','Tillman','M','2006-11-01');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1975-07-31','Judith','David','F','10-11-20');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1957-08-03','Neil','Ford','F','08-09-04');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1977-01-09','Daryl','Wolfe','M','07-09-14');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1986-03-08','Maryam','Burt','M','09-09-16');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1980-08-21','Marny','Alvarez','M','11-01-27');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1965-04-06','Wanda','Fowler','M','08-02-09');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1950-02-14','Lillian','Hancock','F','05-11-22');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1965-11-17','Tatyana','Lucas','M','09-02-16');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1973-03-13','Rooney','Sears','M','05-09-07');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1974-11-23','Ezekiel','Harding','M','10-07-02');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1961-01-26','Willa','Swanson','F','12-10-24');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1948-01-24','Eden','Mcclure','F','09-02-13');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1951-10-31','Maris','Serrano','F','11-10-04');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1972-11-11','Kyle','Jordan','M','12-10-22');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1953-10-06','Jolie','Burton','M','06-06-11');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1970-11-22','Alyssa','Black','M','11-11-10');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1952-05-23','Rahim','Noel','F','10-08-13');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1979-03-07','Roth','May','M','12-06-04');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1961-08-07','Mira','Harding','M','08-02-04');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1957-04-07','Helen','Pacheco','F','07-11-17');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1971-08-07','Isadora','Walsh','F','09-07-02');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1979-02-25','Sybil','Mccarty','F','10-06-15');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1989-08-23','Emma','Cardenas','M','10-01-16');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1965-03-18','Seth','Monroe','M','06-10-16');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1954-03-21','Herrod','Noel','M','10-07-07');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1963-09-06','Devin','Howard','M','11-12-18');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1989-05-25','Kaden','Ellis','F','10-12-07');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1966-02-21','Emery','Walters','M','07-05-07');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1957-11-15','Tyrone','Gill','F','12-07-24');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1957-06-20','Uriah','Morse','M','12-04-22');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1976-11-15','Ross','Bradford','M','08-11-14');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1964-05-04','Elton','Wilkins','F','10-12-21');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1948-06-07','Lillith','Estes','M','08-04-12');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1960-04-04','Hayfa','Burch','F','06-09-25');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1966-02-26','Erin','Lane','M','05-03-01');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1985-08-23','Ella','Robinson','F','06-03-11');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1967-04-19','Wayne','Fischer','M','07-05-24');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1970-11-07','Channing','Mccoy','M','06-05-27');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1993-07-07','Rhonda','Kirby','M','06-05-19');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1978-06-04','Brenda','Hodge','M','06-05-09');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1959-10-27','Barbara','Dixon','M','12-12-05');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1949-04-28','Zephr','Lindsey','M','09-02-16');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1977-08-30','Joan','Campbell','M','12-10-14');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1957-04-14','Breanna','Leblanc','F','07-12-29');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1983-01-15','Hanna','Shaffer','M','11-04-12');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1966-01-15','Felicia','Burt','F','11-11-16');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1963-10-16','Nevada','Blackburn','M','07-08-10');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1961-12-26','Germane','Duncan','F','09-05-31');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1974-03-18','Vladimir','Becker','M','09-12-10');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1965-03-04','Stephen','Clarke','F','09-06-25');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1968-10-18','Jackson','Edwards','F','11-03-02');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1959-05-16','Brent','Dunn','M','08-01-26');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1971-10-21','Quentin','Puckett','F','08-09-15');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1950-09-26','Mona','Sosa','M','07-11-27');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1977-10-01','Nola','Dillard','F','06-10-17');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1956-08-04','Destiny','Maldonado','M','11-05-07');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1974-07-03','Levi','Dunn','M','11-12-13');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1987-09-15','Colleen','Mcpherson','M','05-02-05');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1952-12-11','Igor','Macias','M','11-10-11');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1984-07-04','Brooke','Hodge','F','06-06-22');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1969-08-30','Dillon','Stone','F','06-06-07');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1975-12-29','Marshall','Acevedo','M','11-12-22');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1965-03-29','Kylan','Richards','F','10-07-21');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1991-01-23','Luke','Howard','F','09-07-17');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1951-01-23','Chelsea','Chan','F','07-03-09');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1978-02-21','Linus','Hobbs','F','12-04-28');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1977-01-28','Burke','Ashley','F','08-07-09');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1990-11-23','Pearl','Dennis','M','10-10-10');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1981-04-27','Lyle','Myers','F','06-03-02');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1966-05-04','Kennan','Roman','M','07-07-20');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1947-12-28','Marcia','Bell','M','05-07-29');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1987-01-25','Aaron','Parrish','M','12-02-18');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1960-08-05','Madeline','Elliott','M','08-05-13');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1951-09-03','Zahir','Stevenson','M','12-06-23');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1973-01-31','Colette','Berger','F','12-01-22');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1987-11-09','Molly','Nieves','M','12-04-02');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1978-10-03','Nicole','Salas','M','07-11-08');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1955-05-08','Zane','Madden','M','09-07-01');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1949-03-26','Sydnee','Chen','F','09-11-11');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1969-02-24','Francesca','Patel','F','08-05-11');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1949-05-17','Clark','Glenn','F','08-09-25');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1984-12-07','William','Glover','F','09-12-28');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1967-10-30','Noble','Wiggins','F','08-04-08');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1977-10-15','Dai','Weeks','F','10-02-01');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1955-03-13','Ciara','Chavez','F','11-04-05');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1977-11-29','Francis','Singleton','M','10-12-07');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1993-03-25','TaShya','Mack','M','11-01-12');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1973-08-28','Jameson','Lopez','F','11-12-19');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1981-08-12','Dora','Hinton','F','07-05-26');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1948-11-13','Pascale','Ray','F','06-11-27');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1947-12-24','Geoffrey','Meyers','M','08-04-15');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1989-01-09','Mara','Smith','M','05-07-18');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1963-05-07','Rhoda','Beard','M','10-12-02');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1964-01-22','Ali','Hanson','M','05-01-26');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1973-01-25','Vaughan','English','F','11-03-04');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1961-10-13','Marah','Pollard','M','07-10-28');
INSERT INTO employees (dob,first_name,last_name,gender,hire_date) VALUES ('1975-08-18','Tatum','Adams','F','11-03-24');
