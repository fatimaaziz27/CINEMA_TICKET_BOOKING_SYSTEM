# Cinema Ticket Booking System

A console-based Cinema Ticket Booking System built using Java. This project demonstrates all four major Object-Oriented Programming (OOP) concepts through movie management and ticket booking operations.

## About

This project allows users to view available movies, book cinema tickets, cancel bookings, and view their booking details.

The system provides three predefined movies with different showtimes, ticket prices, and available seats.

Users can book multiple seats, and the system automatically calculates the total fare and updates seat availability.

## Features

- View available movies
- Book cinema tickets
- Cancel existing bookings
- View customer bookings
- Book multiple seats
- Automatically calculate total ticket fare
- Update available seats after booking
- Release seats after cancellation
- Generate unique booking IDs
- Validate movie IDs
- Check seat availability
- Handle invalid menu choices

## Technologies Used

- Java
- Java Collections Framework

## OOP Concepts Used

### 1. Encapsulation
Private attributes are used in the `Movie` and `Booking` classes. Getters provide access to these attributes.

### 2. Inheritance
The `CinemaBooking` class extends the abstract `Booking` class using the `extends` keyword.

### 3. Polymorphism
Method overriding is used in the `CinemaBooking` class to provide implementations of `calculateTotalFare()` and `displayBooking()`.

### 4. Abstraction
The `Booking` class is declared as an abstract class and contains abstract methods.

## Other Java Concepts Practiced

- Classes and objects
- Constructors
- Getters
- `private` access modifier
- `abstract` classes and methods
- `extends` keyword
- `super()` keyword
- `@Override` annotation
- `ArrayList`
- `HashMap`
- `Scanner`
- `switch` statements
- `while` loops
- Enhanced `for` loops
- Conditional statements
- Exception handling
- `Integer.parseInt()`
- `NumberFormatException`

## How It Works

### 1. View Movies
Displays all available movies with their IDs, names, showtimes, ticket prices, and remaining seats.

### 2. Book Tickets
Allows the user to select a movie, enter their name, and choose the number of seats. The system checks seat availability, calculates the total fare, and generates a booking ID.

### 3. Cancel Booking
Allows the user to cancel an existing booking using its booking ID. The cancelled seats are added back to the movie's available seats.

### 4. View My Bookings
Displays all current bookings, including booking ID, customer name, movie, showtime, number of seats, and total fare.

## Available Movies

| Movie ID | Movie Name | Show Time | Ticket Price |
|---|---|---|---|
| 1 | Avengers | 10:00 AM | Rs. 500 |
| 2 | Spider Man | 01:00 PM | Rs. 600 |
| 3 | Batman | 05:00 PM | Rs. 400 |

Each movie starts with 30 available seats.

## Menu Options

| Option | Function |
|---|---|
| 0 | Exit |
| 1 | View Movies |
| 2 | Book Tickets |
| 3 | Cancel Booking |
| 4 | View My Bookings |

## Fare Calculation

Total Fare = Ticket Price × Number of Seats

**Example:**

- Ticket Price = Rs. 600
- Number of Seats = 3
- Total Fare = Rs. 1,800

## Data Structures Used

- **ArrayList:** Stores movie objects.
- **HashMap:** Stores booking records using booking IDs as keys.

## How to Run

1. Download or clone this repository.
2. Open the project folder in your code editor.
3. Make sure Java JDK is installed.
4. Open the terminal in the project folder.
5. Compile the program:

   ```bash
   javac Main.java
   ```

6. Run the program:

   ```bash
   java Main
   ```

## Data Storage

Movie schedules and booking records are stored in an `ArrayList` and a `HashMap`. All data is stored in memory and resets when the program restarts.

## Purpose

This project is designed to practice Java programming and all four major OOP concepts through a practical cinema ticket booking application.

## Future Improvements

- Add movie search functionality
- Add customer contact information
- Add different seat categories
- Add payment processing
- Save booking records using file handling
- Connect the system to a database
- Add a graphical user interface

## Author

Fatima Aziz

GitHub: [fatimaaziz27](https://github.com/fatimaaziz27)
