INSERT INTO Client (name) VALUES
('Alice'),
('Bob'),
('Charlie'),
('David'),
('Eve'),
('Frank'),
('Grace'),
('Hank'),
('Ivy'),
('Jack');

INSERT INTO Planet (id, name) VALUES
('MARS', 'Mars'),
('VEN', 'Venus'),
('EARTH', 'Earth'),
('JUPITER', 'Jupiter'),
('SATURN', 'Saturn');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'MARS', 'VEN'),
(2, 'EARTH', 'MARS'),
(3, 'VEN', 'EARTH'),
(4, 'JUPITER', 'SATURN'),
(5, 'MARS', 'EARTH'),
(6, 'SATURN', 'JUPITER'),
(7, 'EARTH', 'MARS'),
(8, 'VEN', 'EARTH'),
(9, 'SATURN', 'MARS'),
(10, 'JUPITER', 'VEN');
