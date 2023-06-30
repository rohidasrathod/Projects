CREATE DATABASE appointment_scheduling;

USE appointment_scheduling;

CREATE TABLE customer (
  customer_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

CREATE TABLE stylist (
  stylist_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

CREATE TABLE services (
  service_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  price DECIMAL(8,2) DEFAULT 0
);

CREATE TABLE slots (
  slot_id INT PRIMARY KEY AUTO_INCREMENT,
  stylist_id INT NOT NULL,
  availability_date VARCHAR(20) NOT NULL,
  availability_time VARCHAR(20) NOT NULL,
  slot_available BOOLEAN NOT NULL DEFAULT true,
  FOREIGN KEY (stylist_id) REFERENCES stylist(stylist_id)
);

CREATE TABLE appointment (
  appointment_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT NOT NULL,
  stylist_id INT NOT NULL,
  service_id INT NOT NULL,
  customer_name VARCHAR(50) NOT NULL,
  stylist_name VARCHAR(50) NOT NULL,
  service_name VARCHAR(50) NOT NULL,
  appointment_date VARCHAR(20) NOT NULL,
  appointment_time VARCHAR(20) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  FOREIGN KEY (stylist_id) REFERENCES stylist(stylist_id),
  FOREIGN KEY (service_id) REFERENCES services(service_id)
);
