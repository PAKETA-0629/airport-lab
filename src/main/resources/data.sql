<<<<<<< HEAD
=======
TRUNCATE TABLE ordered_tickets, flights, planes, companies, airports, cities, countries, roles, users, managers, regular_clients, personal_information;

INSERT INTO roles(name)
VALUES ('ROLE_CLIENT'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');

INSERT INTO users(email, password, role_id, is_active)
VALUES ('user@gmail.com', '$2a$12$7Anw.HJf2NBw/fIhCZ38yOLK6YfSgLBUt7Obh3y39EAe4dp35PKHq', 1, true),
       ('manager@gmail.com', '$2a$12$3Y1UZFMiveik1SZXO8lgHesOnPBQwe.AdfbCDdUjKUFoYQBJD8vzK', 2, true),
       ('admin@gmail.com', '$2a$12$Y0rwUlgSmoyxknPKljLEduAjcinQJzu3rWw3yIED5euX0B10yT6Li', 3, true);

INSERT INTO countries(name, country_id)
VALUES ('Ukraine', 'UKR'),
       ('England', 'ENG');

INSERT INTO cities(name, latitude, longitude, country)
VALUES ('Lviv', 0, 0, 1),
       ('Kyiv', 50.4501, 30.5234, 1),
       ('London', 0, 0, 2);

>>>>>>> 81247be918a95b757d455d47226c449ad34c9387
