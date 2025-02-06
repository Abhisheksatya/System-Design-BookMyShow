# System-Design-BookMyShow

This repository provides a simplified implementation of BookMyShow, an online platform for booking entertainment tickets. The project replicates essential features such as user authentication, seat selection, and payment processing.

## Design Book My Show

### Requirements :
Develop an online movie ticket booking system with the following capabilities:

Support for multiple cities, each with multiple cinemas.
Each cinema contains multiple halls, where each hall plays one movie at a time.
Cinemas showcase multiple movies concurrently.
Seating categories in a hall include:
Gold
Diamond
Platinum
Users can search for movies by name.
Movies can be filtered based on:
Location
Cinema
Language
Rating
Category
Movies have multiple time slots.
Users can book tickets and make payments via:
UPI
Credit Card
Net Banking
Users can apply coupons or promo codes at checkout.
Seat availability can be viewed in real time.
Ticket prices are determined based on:
Seat Type
Day of the Week
Time of the Day
Movie
Cinema Hall
Users can cancel or modify bookings, subject to a cutoff time of 1 hour before the movie starts.
### Class Diagram :

![BMS](https://raw.githubusercontent.com/Abhisheksatya/System-Design-BookMyShow/refs/heads/master/db.png)

### Technologies Used

Spring Boot – For developing production-ready applications.
Java – Primary programming language.
Model-View-Controller (MVC) – Architectural pattern for structuring the application.
MySQL – Database management system.
Java Persistence API (JPA) – For ORM-based data handling.

### Features

User Authentication – Secure sign-in and sign-up functionality.
Seat Booking – Real-time selection and booking of seats.
Payment Gateway – Integrated system for secure payment processing.

