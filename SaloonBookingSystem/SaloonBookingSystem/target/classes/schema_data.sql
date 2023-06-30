INSERT INTO customer (name, email, password) VALUES
('John Doe', 'johndoe@example.com', 'password1'),
('Jane Smith', 'janesmith@example.com', 'password2'),
('Bob Johnson', 'bobjohnson@example.com', 'password3');

INSERT INTO stylist (name, email, password) VALUES
('Sarah Lee', 'sarahlee@example.com', 'password4'),
('Michael Brown', 'michaelbrown@example.com', 'password5'),
('Jennifer Davis', 'jenniferdavis@example.com', 'password6');

INSERT INTO services (name, price) VALUES
('Haircut', 30.00),
('Hair Coloring', 80.00),
('Manicure', 25.00);

INSERT INTO slots (stylist_id, availability_date, availability_time) VALUES
(1, '2023-04-04', '10:00:00'),
(1, '2023-04-04', '12:00:00'),
(1, '2023-04-05', '14:00:00'),
(2, '2023-04-04', '11:00:00'),
(2, '2023-04-04', '14:00:00'),
(2, '2023-04-05', '10:00:00'),
(3, '2023-04-04', '13:00:00'),
(3, '2023-04-04', '16:00:00'),
(3, '2023-04-05', '15:00:00');

INSERT INTO appointment (customer_id, stylist_id, service_id, customer_name, stylist_name, service_name, appointment_date, appointment_time) VALUES
(1, 1, 1, 'John Doe', 'Sarah Lee', 'Haircut', '2023-04-04', '10:00:00'),
(2, 2, 2, 'Jane Smith', 'Michael Brown', 'Hair Coloring', '2023-04-04', '11:00:00'),
(3, 3, 3, 'Bob Johnson', 'Jennifer Davis', 'Manicure', '2023-04-05', '15:00:00');





