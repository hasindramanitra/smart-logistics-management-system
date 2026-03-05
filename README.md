# Smart Logistics Management System

## Overview
The **Smart Logistics Management System** is a logistics management application designed to:
- Manage senders (customers), receivers, drivers, and vehicles.
- Plan and optimize delivery routes.
- Track packages in real time.
- Generate reports and analytics to improve operational efficiency.

---

## Goals
- Provide full traceability of packages.
- Optimize vehicle and driver utilization.
- Enable real-time delivery tracking.
- Automate reporting for administrators.

---

## Key Features
- **Customer (Sender) Management**: create, update, and track packages sent.
- **Receiver Management**: store delivery information and notify recipients.
- **Driver & Vehicle Management**: availability, capacity, and status tracking.
- **Route Planning**: automatic assignment of drivers and vehicles to delivery routes.
- **Real-Time Tracking**: GPS updates of drivers, live package status, notifications.
- **Reporting**: delivery success rates, delays, average delivery times, PDF/Excel export.

---

## Data Model (Main Entities)
- **Customer (Sender)**: information about the sender.
- **Receiver**: information about the recipient.
- **Package**: package details (weight, volume, status, sender, receiver).
- **Driver**: driver details (availability, license).
- **Vehicle**: vehicle details (capacity, status).
- **DeliveryRoute**: delivery route with assigned driver, vehicle, and packages.

---

## Relationships
- Customer (Sender) ↔ Package : OneToMany  
- Receiver ↔ Package : OneToMany  
- Package ↔ DeliveryRoute : ManyToOne  
- Driver ↔ DeliveryRoute : OneToMany  
- Vehicle ↔ DeliveryRoute : OneToMany  
- DeliveryRoute ↔ Package : OneToMany  

---

## Notifications
- **Sender**: notified at each stage (creation, planning, transit, delivery, delay).  
- **Receiver**: notified during transit and upon delivery.  
- Notifications are triggered by package status changes.  

---

## Tech Stack
- **Backend**: Spring Boot (Web, Data JPA, Security, WebSockets).  
- **Database**: PostgreSQL.  
- **Real-Time Communication**: WebSockets + Kafka/RabbitMQ. 
- **Reporting**: JasperReports, Grafana, Metabase.  
- **Caching**: Redis for faster reporting queries.  
- **Testing**: JUnit, Mockito.  

---

## 🚀 Installation & Run
1. Clone the repository:
   ```bash
   git clone https://github.com/hasindramanitra/smart-logistics-management-system.git

2. Navigate to the folder project
    ```bash
   cd smart-logistics-management-system

3. Run the project
   ```bash
   mvn spring-boot:run

4. Access the API 
    http://localhost:8080/api

