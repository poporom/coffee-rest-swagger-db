create table coffee (
    id SERIAL PRIMARY KEY,
    name varchar(255) not null,
    cost integer not null
);

create table ingredients (
    id varchar(255) PRIMARY KEY,
    quantity integer not null
);

create table coffee_ingredients (
    coffee_id integer REFERENCES coffee(id),
    ingredient_id varchar(255) REFERENCES ingredients(id),
    quantity integer not null
);

