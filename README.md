# Bus Reservation System Using Hibernate

A Java web application for bus ticket booking built with Servlet, JSP, Hibernate ORM, and Bootstrap.

## Tech Stack

- Java Servlets
- JSP (JavaServer Pages)
- Hibernate ORM
- MySQL Database
- Bootstrap 5
- Apache Tomcat 10.1
- Eclipse IDE

## Features

### Admin
- Login with admin credentials
- Add new buses
- View all buses
- View passengers of a specific bus
- Delete a bus
- View all bookings in the system

### User
- Register and login
- Browse available buses
- Book a ticket with seat selection
- View my tickets
- Cancel a booking

## Project Structure
src/

└── main/

├── java/

│   └── com/bus/

│       ├── entity/       # User, Bus, Booking

│       ├── dao/          # UserDAO, BusDAO, BookingDAO

│       ├── servlet/      # All servlets

│       └── util/         # HibernateUtil

└── webapp/

├── WEB-INF/

│   └── web.xml

└── *.jsp             # All JSP views

## Setup Instructions
1. Clone the repository
git clone https://github.com/chaitanya0313/BusReservationSystemUsingHibernate.git

2. Create MySQL database and update `hibernate.cfg.xml` with your credentials

3. Import project into Eclipse as a Maven project

4. Add Apache Tomcat 10.1 as server runtime

5. Run on Server → access at `http://localhost:8080/BusreservationSystemHibernate/`

## Database Setup

Run these SQL statements to create test accounts:

### Admin Account
```sql
INSERT INTO users (name, email, password, role) 
VALUES ('Admin', 'admin@gmail.com', 'admin123', 'ADMIN');
```

### Test User Account
```sql
INSERT INTO users (name, email, password, role) 
VALUES ('Test User', 'user@gmail.com', 'user123', 'USER');
```

> Note: Regular users can also self-register through the Register page.

## Author

Chaitanya — [github.com/chaitanya0313](https://github.com/chaitanya0313)

