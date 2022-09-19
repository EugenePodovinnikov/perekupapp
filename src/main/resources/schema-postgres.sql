DROP TABLE IF EXISTS cars;

CREATE TABLE cars
(
    car_id      serial PRIMARY KEY,
    name        VARCHAR(255),
    photo_url   VARCHAR(255),
    engine_volume INT,
    year        INT,
    clutch_type VARCHAR(128),
    description VARCHAR(5012),
    price INT
);