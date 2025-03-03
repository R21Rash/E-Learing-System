# User Management System (OSGi-Based)

## 📌 Overview
This is an **OSGi-based User Management System** that runs in an **OSGi container**. It consists of:
- `com.providers` - The service provider (User Management Service)
- `com.clients` - The service consumer (Client Application)

## 🚀 How to Run the System

### **1️⃣ Start the OSGi Shell**
Make sure you have **Apache Felix** or **Eclipse Equinox** running.  
If not, launch the OSGi container and enter the interactive shell.

### **2️⃣ Install and Start the Bundles**
Inside the OSGi shell, run:
```sh
start 23  # Start the User Management Service (com.providers)
start 14  # Start the Client Bundle (com.clients)


rules--->
stop 14  # Stop the Client Bundle
stop 23  # Stop the User Management Service

start 23  # Restart the User Management Service
start 14  # Restart the Client Bundle
### **Expected Output
User Management Service Started...
Client Bundle Started...
Connected to UserService!
Register user: Alice with email: alice@example.com


