# Reservation System (Java - OOP Project)

## Overview

This project is a desktop-based Reservation System developed in Java using Object-Oriented Programming principles and Java Swing for the user interface.

The system allows administrators, companies, and customers to manage transportation reservations including buses, trains, and airplanes.

## Purpose

The main objective of this project was to:
- Understand object-oriented programming concepts
- Apply inheritance, abstraction, and polymorphism
- Design a multi-role system (Admin, Company, Customer)
- Develop a functional GUI application using Java Swing

## System Features

### Admin Panel
- View existing companies
- Add new companies
- Manage system-level operations

(Admin login: username: burak, password: 1234)

### Company Panel
- Add/remove vehicles
- Add/remove trips
- View daily profit/loss
- Manage transportation types (Bus, Train, Airplane)

(Default password for companies: 1234)

### Customer Panel
- Search trips by:
  - Date
  - Departure location
  - Destination
  - Passenger count
- Select seats
- Enter passenger information
- Make payment
- View purchased tickets

## Class Structure

The system is designed using the following main classes:

- `User` (Base class)
- `Admin`
- `Company`
- `Customer`
- `Vehicle`
  - `Bus`
  - `Train`
  - `Airplane`
- `Trip`
- `Route`
- `Reservation`
- `Transport`
- `Person` (Abstract)
  - `Personnel`
  - `Passenger`

The UML diagram is available in the repository.

## Technologies Used

- Java
- Java Swing
- OOP (Inheritance, Abstraction, Polymorphism)
- UML Design

## Project Report

The detailed project report (IEEE format) is available the name `rapor.pdf` .
