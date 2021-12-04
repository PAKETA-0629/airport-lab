DROP TABLE IF EXISTS ordered_tickets, flights, planes, companies, airports, cities, countries, personal_information, regular_clients, managers, users, roles;
create table roles (
    id serial primary key,
    name varchar(20) not null unique
);

create table users (
    id serial primary key,
    email varchar(50) not null unique,
    password varchar(255) not null,
    role_id integer not null references roles,
    is_active boolean
);

create table managers (
    id serial primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    manager_id varchar(50) not null unique,
    user_id integer not null references users
);

create table regular_clients (
    id serial primary key,
    user_id int not null unique references users,
    points int not null,
    flight_distance int not null
);

create table personal_information (
    id serial primary key,
    phone_number varchar(20) not null unique,
    born date not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    passport_id varchar(50) not null unique,
    account_id int references regular_clients
);

create table countries (
    id serial primary key,
    name varchar(50) not null unique,
    country_id varchar(3) not null unique
);

create table cities (
    id serial primary key,
    name varchar(50) not null,
    latitude double precision not null,
    longitude double precision not null,
    country integer not null references countries,
    unique (latitude, longitude),
    unique (name, country)
);

create table airports (
    id serial primary key,
    name varchar(50) not null unique,
    iata varchar(4) not null unique,
    ikao varchar(4) not null unique,
    city integer not null references cities,
    latitude double precision not null,
    longitude double precision not null
);

create table companies (
    id serial primary key,
    name varchar(50) not null unique
);

create table planes (
    id serial primary key,
    company_name int not null references companies,
    bc_capacity integer not null,
    ec_capacity integer not null,
    board_number varchar(50) not null unique
);

create table flights (
    id serial primary key,
    plane int not null unique references planes,
    flight_id varchar(50) not null unique,
    departure_time time with time zone not null,
    arrival_time time with time zone not null,
    company int not null references companies,
    departure_airport int constraint fk_departure_airport references airports,
    destination_airport int constraint fk_destination_airport references airports,
    bc_price int not null,
    ec_price int not null,
    include_baggage boolean,
    include_meal boolean,
    meal_price int,
    departure_days varchar(7)
);

create table ordered_tickets (
    id serial primary key,
    flight int not null references flights,
    seat varchar(5) not null,
    departure_date date not null,
    client int references personal_information,
    baby_seat boolean default false not null,
    payment_date date,
    unique (flight, seat, departure_date)
);

INSERT INTO roles(name)
VALUES ('ROLE_CLIENT'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');

INSERT INTO users(email, password, role_id, is_active)
VALUES ('user@gmail.com', '$2y$12$aDvzOnearRd4eulVJID3pOufutAIXVU5i1GKhgpXuvyVmktuSAmqe', 1, true),
       ('admin@gmail.com', '$2y$12$iod5PRHZaYrIO6L3onnnk.Mhx9Hc1lb2ehBi0hRvPDD83u6OM/b66', 3, true);

INSERT INTO countries(name, country_id)
VALUES ('Ukraine', 'UKR'),
       ('England', 'ENG'),
       ('Poland', 'POL'),
       ('Germany', 'GER'),
       ('Italy', 'ITA'),
       ('France', 'FRA'),
       ('United States of America', 'USA'),
       ('Spain', 'SPA'),
       ('Portugal', 'POR');

INSERT INTO cities(name, latitude, longitude, country)
VALUES ('Kyiv', 50.4501, 30.5234, 1),
       ('Lviv', 49.5030, 24.0153, 1);

INSERT INTO airports(name, iata, ikao, city, latitude, longitude)
VALUES ('Міжнародний аеропорт «Київ»', 'IEV', 'UKKK', 1, 50.4501, 30.5234),
       ('Міжнародний аеропорт «Львів»', 'LWO', 'UKLL', 2, 49.5030, 24.0153)
