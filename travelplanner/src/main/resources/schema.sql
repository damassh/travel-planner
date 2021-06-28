DROP TABLE IF EXISTS WEATHER_FORECAST;
DROP TABLE IF EXISTS DAILY_WEATHER_FORECAST;
DROP TABLE IF EXISTS ITINERARY;

CREATE TABLE ITINERARY
(
    itinerary_id   INT AUTO_INCREMENT PRIMARY KEY,
    itinerary_name VARCHAR(25) NOT NULL
);

CREATE TABLE CITY
(
    city_id      INT AUTO_INCREMENT PRIMARY KEY,
    city_name    VARCHAR(25) NOT NULL,
    country_code VARCHAR(3)  NOT NULL,
    itinerary_id INT,
    CONSTRAINT FK_CITY_ITINERARY FOREIGN KEY (itinerary_id)
        REFERENCES ITINERARY (itinerary_id)
);


CREATE TABLE WEATHER_FORECAST
(
    weather_forecast_id INT AUTO_INCREMENT PRIMARY KEY,
    temperature         INT       NOT NULL,
    cloud               INT       NOT NULL,
    date_time           TIMESTAMP NOT NULL,
    city_id             INT,
    CONSTRAINT FK_WEATHER_FORECAST_CITY FOREIGN KEY (city_id)
        REFERENCES CITY (city_id)

);

-- INSERT INTO ITINERARY(itinerary_name) VALUES('Itinerary1');
-- INSERT INTO CITY(city_name, country_code, itinerary_id) VALUES('Tokyo', 'JP', 1);
-- INSERT INTO WEATHER_FORECAST(temperature, cloud, date_time, city_id) VALUES (100, 100, TO_TIMESTAMP('2021-06-21 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);
