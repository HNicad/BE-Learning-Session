CREATE TABLE employees(
    employee_id SERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    surname VARCHAR(25) NOT NULL,
    birthdate DATE NOT NULL,
    age INT NOT NULL,
    department_name VARCHAR(35) NOT NULL
);

CREATE TABLE employees_contact_details(
    employee_id SERIAL PRIMARY KEY  REFERENCES employees(employee_id) ON DELETE CASCADE,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(51)
);
