# Hotel Management System

This is a Hotel Management System built using Spring Boot for the backend and React for the frontend. The system supports user authentication, room bookings, and AWS S3 integration for image uploads.

## Features
- User Authentication with JWT
- Role-Based Access (Admin & Customer)
- Room Management (CRUD operations)
- Booking Management
- AWS S3 Integration for Image Uploads

## Tech Stack

### Backend
- Java + Spring Boot
- Spring Security + JWT Authentication
- MySQL Database
- AWS S3 for Image Storage

### Frontend
- React
- Axios (for API calls)

## Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/subhash-varun/Hotel-Management-Project.git
cd Hotel-Management-Project
```

### 2. Backend Setup (Spring Boot)
#### Configure application.properties
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=yourpassword

aws.s3.access.key=your-aws-access-key
aws.s3.secret.key=your-aws-secret-key
aws.s3.bucket.name=your-bucket-name
aws.s3.region=ap-south-1

jwt.secret=your-secret-key
```

#### Run the Spring Boot Application
```bash
mvn clean install
mvn spring-boot:run
```
The backend will start at: `http://localhost:4040`

### 3. Frontend Setup (React)
```bash
cd frontend
npm install
npm start
```
The frontend will start at: `http://localhost:3000`

## Authentication (JWT)
This project uses JWT (JSON Web Token) for authentication.

### Register API
```http
POST /auth/register
```
#### Admin Registration
```json
{
  "name": "Admin User",
  "email": "admin@example.com",
  "phoneNumber": "1234567890",
  "password": "password123",
  "role": "ADMIN"
}
```
#### User Registration
```json
{
  "name": "Regular User",
  "email": "user@example.com",
  "phoneNumber": "1234567890",
  "password": "password123"
}
```
Note: For regular users, the role field is optional and defaults to "USER".

[Rest of the content remains the same]
### Login API
```http
POST /auth/login
```
#### Request Body
```json
{
  "username": "admin",
  "password": "password123"
}
```
#### Response
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5c..."
}
```
The token must be sent in the Authorization header for protected routes:
```
Authorization: Bearer <token>
```

## API Endpoints

### Authentication APIs
| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /auth/register | Register a new user |
| POST | /auth/login | Login and get JWT token |

### User APIs
| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | /users/all | Get all users (Admin only) |
| GET | /users/get-by-id/{id} | Get user by ID |
| GET | /users/get-logged-in-profile-info | Get profile info of logged-in user |
| GET | /users/get-user-bookings/{userId} | Get all bookings of a user |
| DELETE | /users/delete/{id} | Delete user by ID |

### Room APIs
| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /rooms/add | Add a new room (Admin only) |
| GET | /rooms/all | Get all rooms |
| GET | /rooms/types | Get all room types |
| GET | /rooms/room-by-id/{roomId} | Get details of a room by ID |
| GET | /rooms/available-rooms-by-date-and-type | Get available rooms based on date and type |
| PUT | /rooms/update/{roomId} | Update room details |
| DELETE | /rooms/delete/{roomId} | Delete a room |

#### Example for fetching available rooms:
```http
GET /rooms/available-rooms-by-date-and-type?checkInDate=2025-02-12&checkOutDate=2025-02-16&roomType=Single
```

### Booking APIs
| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /bookings/book-room/{roomId}/{userId} | Book a room |
| GET | /bookings/get-by-confirmation-code/{code} | Get booking details by confirmation code |
| PUT | /bookings/cancel/{bookingId} | Cancel a booking |
| GET | /bookings/all | Get all bookings (Admin only) |

#### Example for booking a room:
```http
POST /bookings/book-room/2/8
```

## Contribution Guide
1. Fork the repository
2. Create a new branch (feature-new)
3. Commit your changes
4. Push to GitHub & create a Pull Request

## Author
Subhash Varun  
GitHub: [@subhash-varun](https://github.com/subhash-varun)
