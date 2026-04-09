CREATE DATABASE Employee_Management;

CREATE TABLE Address(
                        address_id int PRIMARY KEY ,
                        city VARCHAR(50) NOT NULL ,
                        state CHAR(2) NOT NULL ,
                        zipcode VARCHAR(50) NOT NULL
);

CREATE TABLE Department(
                           dept_id int PRIMARY KEY,
                           name VARCHAR(50)
);
CREATE TABLE Employee(
                         emp_id INT PRIMARY KEY,
                         name VARCHAR(50) NOT NULL,
                         salary INT NOT NULL,
                         address_id INT NOT NULL ,
                         dept_id INT NOT NULL ,
                         FOREIGN KEY (address_id) REFERENCES Address(address_id),
                         FOREIGN KEY (dept_id) REFERENCES Department(dept_id));
CREATE TABLE Project(
                        project_id INT PRIMARY KEY ,
                        project_name VARCHAR(50) NOT NULL ,
                        estimated_days INT NOT NULL ,
                        location VARCHAR(2) NOT NULL
);
CREATE TABLE Employee_Project(
                                 emp_id int NOT NULL ,
                                 project_id INT NOT NULL,
                                 PRIMARY KEY (emp_id,project_id),
                                 FOREIGN KEY (project_id) REFERENCES Project(project_id),
                                 FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);
INSERT INTO Address (address_id, city, state, zipcode) VALUES
                                                           (1, 'Fairfield', 'IA', '52556'),
                                                           (2, 'Iowa City', 'IA', '52440'),
                                                           (3, 'Morrison', 'IL', '61270'),
                                                           (4, 'Orlando', 'FL', '34565'),
                                                           (5, 'Tampa', 'FL', '31765');
INSERT INTO Department (dept_id, name) VALUES
                                           (1, 'Tech'),
                                           (2, 'HR'),
                                           (3, 'Finance'),
                                           (4, 'Marketing');
INSERT INTO Project (project_id, project_name, estimated_days, location)
VALUES
    (1, 'X', 180, 'FL'),
    (2, 'Y', 60, 'FL'),
    (3, 'Z', 80, 'IA');
INSERT INTO Employee (emp_id, name, salary, address_id, dept_id) VALUES
                                                                     (111, 'Zaineh', 100000, 1, 1),
                                                                     (112, 'Yasmeen', 160000, 2, 4),
                                                                     (113, 'Mira', 140000, 3, 3),
                                                                     (114, 'Shimaa', 200000, 4, 2),
                                                                     (115, 'Dean', 150000, 5, 1);
INSERT INTO Employee_Project (emp_id, project_id) VALUES
                                                      (115, 1),
                                                      (115, 2),
                                                      (115, 3),
                                                      (114, 1),
                                                      (114, 3),
                                                      (111, 1),
                                                      (111, 2);
-- A Selection:
SELECT name,salary
FROM Employee;

--2.
SELECT project_name
FROM Project
WHERE location='FL';

--3.
SELECT emp_id,project_id
FROM Employee_Project
WHERE project_id=1;

--4
SELECT DISTINCT state
FROM Address;

--5
SELECT name,salary
FROM Employee
WHERE salary<150000;

--6
SELECT project_name,estimated_days
FROM Project
ORDER BY estimated_days DESC ;

--7
SELECT DISTINCT emp_id
FROM Employee_Project;

--B Aggregates and Grouping

--1
SELECT AVG(salary)
FROM Employee;

--2
SELECT MAX(estimated_days)
FROM Project;

--3
SELECT dept_id,SUM(salary) AS total_salary
FROM Employee
GROUP BY dept_id;

--4
SELECT dept_id
FROM Employee
GROUP BY dept_id
HAVING AVG(salary)>150000;

--C JOIN
--1
SELECT name,city
FROM Employee e
         JOIN  Address a
               ON e.address_id=a.address_id;

--2
SELECT  d.name,e.name
FROM Department d
         LEFT JOIN Employee e
                   ON d.dept_id = e.dept_id;

--3
SELECT e.name,p.project_name
FROM Employee e
         INNER JOIN Employee_Project ep
                    ON e.emp_id=ep.emp_id
         INNER JOIN Project p
                    ON ep.project_id=p.project_id ;

-- D SubQueries
--1.
SELECT name
FROM Employee
WHERE salary=(
    SELECT MAX(salary)
    FROM Employee);

--2
SELECT name
FROM Employee e
         INNER JOIN Employee_Project ep
                    ON e.emp_id=ep.emp_id
         INNER JOIN Project p
                    ON ep.project_id=p.project_id
WHERE p.project_id IN(
    SELECT project_id
    FROM Project
    WHERE estimated_days=180
);

--3
SELECT project_id
FROM Project
WHERE estimated_days>(
    SELECT AVG(estimated_days)
    FROM Project
);

----- LAB_8
--A
CREATE VIEW EmployeeDetails AS
SELECT e.emp_id,e.name AS employee_name,salary,d.name AS dept_name,p.project_name
FROM Employee e
         JOIN Department d
              ON e.dept_id=d.dept_id
         JOIN Employee_Project ep
              ON ep.emp_id=e.emp_id
         JOIN Project p
              ON p.project_id=ep.project_id;

SELECT *
FROM EmployeeDetails;
--B
CREATE INDEX  idx_employee_name
    ON Employee(name);

SELECT indexname
FROM pg_indexes
WHERE indexname='idx_employee_name';