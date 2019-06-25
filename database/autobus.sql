DROP DATABASE IF EXISTS autobus;
CREATE DATABASE IF NOT EXISTS autobus;
USE autobus;

SELECT 'CREATING DATABASE STRUCTURE' AS 'INFO';

DROP TABLE IF EXISTS city, travel;

CREATE TABLE city (
	city_id			INT				NOT NULL,
	name			VARCHAR(50)		NOT NULL,
	PRIMARY KEY		(city_id)
);

CREATE TABLE travel (
	travel_id		INT				NOT NULL,	
	departure_id	INT				NOT NULL,
	arrival_id		INT				NOT NULL,
	departure_date	DATE			NOT NULL,
	departure_hour 	TIME			NOT NULL,
	arrival_date	DATE			NOT NULL,
	arrival_hour	TIME			NOT NULL,
	FOREIGN KEY (departure_id) REFERENCES city (city_id),
	FOREIGN KEY (arrival_id) REFERENCES city (city_id),
	PRIMARY KEY (travel_id)
);

-- HC Test data
INSERT INTO `city` VALUES (1, 'Oviedo'),
(2, 'Madrid'),
(3, 'Sevilla'),
(4, 'Zaragoza'),
(5, 'Palma de Mallorca'),
(6, 'Las Palmas de Gran Canaria'),
(7, 'Santander'),
(8, 'Toledo'),
(9, 'Valladolid'),
(10, 'Barcelona'),
(11, 'Mérida'),
(12, 'Santiago de Compostela'),
(13, 'Logroño'),
(14, 'Melilla'),
(15, 'Murica'),
(16, 'Pamplona'),
(17, 'Valencia'),
(18, 'Vitoria');

INSERT INTO `travel` VALUES (1, 2, 4, '2019-07-01', '11:00:00', '2019-07-01', '16:00:00'),
(2, 2, 4, '2019-07-01', '18:00:00', '2019-07-01', '22:00:00'),
(3, 5, 7, '2019-07-01', '11:00:00', '2019-07-01', '16:00:00'),
(4, 5, 7, '2019-07-01', '18:00:00', '2019-07-01', '22:00:00'),
(5, 6, 9, '2019-07-01', '11:00:00', '2019-07-01', '16:00:00'),
(6, 6, 9, '2019-07-01', '18:00:00', '2019-07-01', '22:00:00'),
(7, 10, 17, '2019-07-01', '11:00:00', '2019-07-01', '16:00:00'),
(8, 10, 17, '2019-07-01', '18:00:00', '2019-07-01', '22:00:00'),
(9, 11, 15, '2019-07-01', '11:00:00', '2019-07-01', '16:00:00'),
(10, 11, 15, '2019-07-01', '18:00:00', '2019-07-01', '22:00:00'),
(11, 12, 4, '2019-07-01', '11:00:00', '2019-07-01', '16:00:00'),
(12, 12, 4, '2019-07-01', '18:00:00', '2019-07-01', '22:00:00'),
(13, 2, 4, '2019-07-02', '11:00:00', '2019-07-02', '16:00:00'),
(14, 2, 4, '2019-07-02', '18:00:00', '2019-07-02', '22:00:00'),
(15, 5, 7, '2019-07-02', '11:00:00', '2019-07-02', '16:00:00'),
(16, 5, 7, '2019-07-02', '18:00:00', '2019-07-02', '22:00:00'),
(17, 6, 9, '2019-07-02', '11:00:00', '2019-07-02', '16:00:00'),
(18, 6, 9, '2019-07-02', '18:00:00', '2019-07-02', '22:00:00'),
(19, 10, 17, '2019-07-02', '11:00:00', '2019-07-02', '16:00:00'),
(20, 10, 17, '2019-07-02', '18:00:00', '2019-07-02', '22:00:00'),
(21, 11, 15, '2019-07-02', '11:00:00', '2019-07-02', '16:00:00'),
(22, 11, 15, '2019-07-02', '18:00:00', '2019-07-02', '22:00:00'),
(23, 12, 4, '2019-07-02', '11:00:00', '2019-07-02', '16:00:00'),
(24, 12, 4, '2019-07-02', '18:00:00', '2019-07-02', '22:00:00');