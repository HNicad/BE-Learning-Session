-- Task 4;
INSERT INTO employees(name, surname, birthdate, age, department_name) VALUES('A','B','1970-01-03',50,'HR');
INSERT INTO employees(name, surname, birthdate, age, department_name) VALUES('C','D','1953-11-15',67,'GM');
INSERT INTO employees(name, surname, birthdate, age, department_name) VALUES('E','F','1950-09-25',70,'FD');
INSERT INTO employees(name, surname, birthdate, age, department_name) VALUES('G','H','2000-10-01',40,'PD');
INSERT INTO employees(name, surname, birthdate, age, department_name) VALUES('K','J','2001-07-20',19,'FD');
INSERT INTO employees(name, surname, birthdate, age, department_name) VALUES('L','M','1986-05-13',34,'HR');

INSERT INTO employees_contact_details(employee_id, email, phone) VALUES(1,'ab@gmail.com','+9941231212');
INSERT INTO employees_contact_details(employee_id, email, phone) VALUES(2,'cd@gmail.com','+9941231213');
INSERT INTO employees_contact_details(employee_id, email, phone) VALUES(3,'ef@yandex.com','+9941231214');
INSERT INTO employees_contact_details(employee_id, email, phone) VALUES(4,'gh@mail.ru','+9941231215');
INSERT INTO employees_contact_details(employee_id, email, phone) VALUES(5,'kj@apple.com','+9941231216');
INSERT INTO employees_contact_details(employee_id, email, phone) VALUES(6,'lm@facebook.com','+9941231217');

--Task 5;
SELECT  name, birthdate FROM employees ORDER BY birthdate LIMIT 1;

--Task 6;

SELECT e.name, d.email FROM employees e LEFT JOIN employees_contact_details d ON e.employee_id=d.employee_id where d.email LIKE '%gmail.com';

--Task 7
SELECT department_name, AVG(age)  FROM employees GROUP BY department_name;

--Task 8
SELECT department_name, count(*)  FROM employees WHERE age>=65 GROUP BY department_name;

--Task 9
docker container run -d --name=postgres -p 5432:5432 -e POSTGRES_PASSWORD=password -e PGDATA=/pgdata -v /pgdata:/pgdata postgres:latest
