# 🏥 eClinic Uganda – Java-Based Telemedicine System

**eClinic Uganda** is a Java-based telemedicine system designed to connect patients in rural communities with medical professionals. The system allows appointment bookings, prescriptions, and SMS notifications to improve access to healthcare in underserved areas.

---

## 📌 Features

- 🧑‍⚕️ Patient login and dashboard
- 📅 Book appointments with doctors
- 💬 Doctors can view bookings and issue prescriptions
- 📲 SMS reminders (integrate with Africa's Talking or Twilio)
- 🔒 Role-based access (patient, doctor, admin)
- 🖥️ JSP + Servlets architecture (MVC)
- 🗄️ MySQL database backend

---

## 🛠️ Tech Stack

| Component   | Technology         |
|------------|--------------------|
| Language    | Java               |
| Frontend    | JSP, HTML, CSS     |
| Backend     | Java Servlets      |
| DB          | MySQL              |
| Server      | Apache Tomcat      |
| Build Tool  | Manual (or Maven)  |



---

## ⚙️ Setup Instructions

1. **Install Prerequisites**
   - Java JDK 11+
   - Apache Tomcat 10+
   - MySQL Server
   - IDE (Eclipse/IntelliJ)

2. **Database Setup**
```sql
CREATE DATABASE eclinicdb;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  role ENUM('patient', 'doctor', 'admin'),
  phone VARCHAR(15),
  password_hash VARCHAR(255)
);

CREATE TABLE appointments (
  appointment_id INT AUTO_INCREMENT PRIMARY KEY,
  patient_id INT,
  doctor_id INT,
  date_time DATETIME,
  status ENUM('pending', 'completed', 'cancelled'),
  FOREIGN KEY (patient_id) REFERENCES users(user_id),
  FOREIGN KEY (doctor_id) REFERENCES users(user_id)
);

CREATE TABLE prescriptions (
  prescription_id INT AUTO_INCREMENT PRIMARY KEY,
  appointment_id INT,
  description TEXT,
  date_issued DATETIME,
  FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

Deploy on Tomcat

Export project as .war or deploy via your IDE

Start Tomcat and navigate to: http://localhost:8080/eClinicUganda/

📩 Future Improvements
Video consultation with Jitsi or WebRTC

Admin dashboard with charts

SMS integration using Java SDK

Android app for offline access

👨‍💻 Author
Harkens Technologies
info@harkenstech.com

📜 License
MIT License – Feel free to use and modify!