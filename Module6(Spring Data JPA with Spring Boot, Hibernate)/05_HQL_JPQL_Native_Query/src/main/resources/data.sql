INSERT INTO department (dp_name) VALUES ('Engineering');
INSERT INTO department (dp_name) VALUES ('Human Resources');
INSERT INTO department (dp_name) VALUES ('Finance');

INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('Python');
INSERT INTO skill (sk_name) VALUES ('SQL');
INSERT INTO skill (sk_name) VALUES ('Spring Boot');

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('John Doe', 60000, true, '1990-01-15', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Jane Smith', 80000, true, '1985-06-20', 2);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES ('Bob Wilson', 55000, false, '1992-11-10', 1);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 4);
