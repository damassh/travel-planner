-- INSERT INTO ITINERARY(itinerary_name) VALUES('Itinerary1');
-- INSERT INTO CITY(city_name, country_code, itinerary_id) VALUES('Tokyo', 'JP', 1);
-- INSERT INTO WEATHER_FORECAST(temperature, cloud, date_time, city_id) VALUES (100, 100, TO_TIMESTAMP('2021-06-21 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);


INSERT INTO CITY(city_name, country_code)
VALUES ('Tokyo', 'JP');
INSERT INTO WEATHER_FORECAST(temperature, cloud, date_time, city_id)
VALUES (100, 100, TO_TIMESTAMP('2021-06-21 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);