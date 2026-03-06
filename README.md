# Smart Logistics Management System 

## Overview
The **Smart Logistics Management System** is a robust Spring Boot application designed to streamline modern supply chain operations. It centralizes the management of users, fleet assets, and delivery lifecycles while providing real-time tracking and automated financial documentation.

---

## Key Features
- **Unified User Management**: Single-entry system for Senders and Receivers to ensure data integrity.
- **Fleet & Crew Tracking**: Real-time availability and capacity monitoring for Drivers and Vehicles.
- **Intelligent Route Planning**: Grouping packages into delivery routes assigned to specific drivers and zones.
- **Automated Invoicing**: Generation of PDF invoices linked to specific package shipments.
- **Status Lifecycle**: Comprehensive tracking from `CREATED` to `DELIVERED` with handling for delays.

---

## Data Model (Core Entities)

The system is built on a relational schema optimized for high-performance joins and clear ownership:



### 1. Identity & Actors
* **User**: Unified entity for all participants. Roles (`USER`, `ADMIN`) and contact details are stored here.
* **Driver**: Specialized personnel entity including license numbers and real-time `availability` status.

### 2. Logistics & Assets
* **Package**: The heart of the system. Tracks physical attributes (weight/volume), statuses, and links to both a `Sender` and `Receiver`.
* **Vehicle**: Tracks fleet assets with specific `capacityWeight` and `capacityVolume` constraints to prevent overloading.
* **DeliveryRoute**: A logistical unit defined by a `zone` and `deliveryDate`, coordinating a Driver, a Vehicle, and a list of Packages.

### 3. Finance
* **Invoice**: Manages the billing state (`PENDING`, `PAID`, `CANCELLED`) and stores references to generated PDF files.

---

## Entity Relationships (JPA Mapping)
| Entity A | Relation | Entity B | Description |
| :--- | :---: | :--- | :--- |
| **User** | `1:N` | **Package** | A user can be associated with many packages (as sender or receiver). |
| **DeliveryRoute** | `N:1` | **Driver** | Multiple routes can be assigned to a driver over time. |
| **DeliveryRoute** | `N:1` | **Vehicle** | Multiple routes can be assigned to a vehicle over time. |
| **Package** | `N:1` | **DeliveryRoute** | Many packages are grouped into a single delivery route. |
| **Package** | `N:1` | **Invoice** | Packages are linked to a specific invoice for billing. |

---

## Tech Stack
* **Backend**: Spring Boot 3 (Data JPA, Hibernate, Validation).
* **Database**: PostgreSQL.
* **Tooling**: Lombok (Boilerplate reduction), Maven (Dependency management).
* **Security**: Role-based access control (Admin/User).

---

## ⚙️ Installation & Run
1. **Clone the repository**:
   ```bash
   git clone [https://github.com/hasindramanitra/smart-logistics-management-system.git](https://github.com/hasindramanitra/smart-logistics-management-system.git)