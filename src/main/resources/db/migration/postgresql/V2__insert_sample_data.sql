INSERT INTO coffee (id, name, cost)
VALUES (1, 'espresso', 100),
       (2, 'cappuccino', 100),
       (3, 'latte', 100);

INSERT INTO ingredients (id, quantity)
VALUES ('WATER', 5000),
       ('MILK', 5000),
       ('BEANS', 5000),
       ('CUPS', 5000);

INSERT INTO coffee_ingredients (ingredient_id, quantity, coffee_id)
VALUES ('WATER', 100, 1),
       ('MILK', 0, 1),
       ('BEANS', 16, 1),
       ('CUPS', 1, 1),
       ('WATER', 200, 2),
       ('MILK', 50, 2),
       ('BEANS', 12, 2),
       ('CUPS', 1, 2),
       ('WATER', 300, 3),
       ('MILK', 150, 3),
       ('BEANS', 20, 3),
       ('CUPS', 1, 3);

