# 🎓 Student Management System

A console-based **Student Management System** built using **Java, JDBC, and MySQL**.

This project demonstrates how to build a Java application that connects to a MySQL database using JDBC and performs complete CRUD operations along with student search functionality.

---

## 📌 Features

- ➕ Add a new student
- 📋 View all students
- 🔍 Search student by ID
- ✏️ Update student information
- 🗑️ Delete student
- 🎓 Search students by course
- 🔄 Interactive menu-driven interface
- 🔐 Uses `PreparedStatement` to prevent SQL injection
- 🗄️ MySQL database integration
- 🔌 JDBC connection management

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| JDBC | Database connectivity |
| MySQL | Relational database |
| IntelliJ IDEA / Eclipse | Development |
| MySQL Connector/J | JDBC driver |
| Git & GitHub | Version control |

---

## 🏗️ Application Architecture

```text
┌─────────────────────────────┐
│       Java Application      │
│                             │
│  Menu / User Interaction    │
└──────────────┬──────────────┘
               │
               │ JDBC
               ▼
┌─────────────────────────────┐
│       JDBC Connection       │
│     PreparedStatement       │
│       ResultSet             │
└──────────────┬──────────────┘
               │
               │ SQL Queries
               ▼
┌─────────────────────────────┐
│        MySQL Database       │
│                             │
│         students            │
│                             │
│  id | name | age | course   │
└─────────────────────────────┘
```

---

## 📂 Project Structure

```text
JDBC-Student-Management-System/
│
├── src/
│   ├── Main.java
│   ├── JDBC_Connection.java
│   └── StudentManagement.java
│
├── sql/
│   └── student.sql
│
├── .gitignore
│
└── README.md
```

> The exact Java file names can be changed according to your project structure.

---

## 🗄️ Database Setup

### 1. Install MySQL

Make sure MySQL Server is installed and running.

### 2. Create Database

Open MySQL and run:

```sql
CREATE DATABASE college;
```

Select the database:

```sql
USE college;
```

### 3. Create Students Table

```sql
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(100) NOT NULL
);
```

### 4. Insert Sample Data

```sql
INSERT INTO students (id, name, age, course)
VALUES
(101, 'Milind', 22, 'CSE'),
(102, 'Rajesh', 23, 'ECE'),
(103, 'Suresh', 21, 'CSE'),
(104, 'Amit', 24, 'IT');
```

---

## 🔌 JDBC Configuration

Update the database credentials in your Java application:

```java
String url = "jdbc:mysql://localhost:3306/college";
String username = "root";
String password = "root";
```

Change the username and password according to your MySQL configuration.

---

## 📦 MySQL JDBC Driver

Download **MySQL Connector/J** and add the JAR file to your project.

The dependency is required for:

```java
import java.sql.*;
```

The JDBC driver allows Java to communicate with MySQL.

---

## 🚀 How to Run

### Step 1 — Clone the Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

### Step 2 — Open the Project

Open the project using:

- IntelliJ IDEA
- Eclipse
- VS Code with Java extensions

### Step 3 — Configure MySQL

Make sure MySQL is running and create the `college` database and `students` table.

### Step 4 — Configure JDBC Credentials

Update:

```java
String url = "jdbc:mysql://localhost:3306/college";
String username = "root";
String password = "root";
```

### Step 5 — Add MySQL Connector/J

Add the MySQL Connector/J dependency or JAR to your project classpath.

### Step 6 — Run the Application

Run:

```text
Main.java
```

---

## 🖥️ Application Menu

The application provides the following menu:

```text
===== Student Management System =====

1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Search By Course
7. Exit

Enter your choice:
```

The menu continues running until the user selects:

```text
7. Exit
```

---

## 🔄 CRUD Operations

### Create — Add Student

Example:

```sql
INSERT INTO students
VALUES (?, ?, ?, ?);
```

The application uses `PreparedStatement` to insert student information.

---

### Read — View Students

```sql
SELECT * FROM students;
```

The returned records are processed using:

```java
ResultSet
```

---

### Search Student

Students can be searched using their ID:

```sql
SELECT name
FROM students
WHERE id = ?;
```

---

### Update Student

Student names can be updated using:

```sql
UPDATE students
SET name = ?
WHERE id = ?;
```

The application uses:

```java
executeUpdate();
```

and checks the number of affected rows.

---

### Delete Student

Students can be removed using:

```sql
DELETE FROM students
WHERE id = ?;
```

---

### Search By Course

Students belonging to a particular course can be retrieved using:

```sql
SELECT *
FROM students
WHERE course = ?;
```

For example:

```text
Enter course name:
CSE
```

Output:

```text
ID: 101 | Name: Milind | Age: 22 | Course: CSE
ID: 103 | Name: Suresh | Age: 21 | Course: CSE
```

---

## 🔐 PreparedStatement

This project uses `PreparedStatement` instead of directly concatenating user input into SQL queries.

Example:

```java
String query = "SELECT * FROM students WHERE id = ?";

PreparedStatement st = con.prepareStatement(query);

st.setInt(1, id);

ResultSet rs = st.executeQuery();
```

This provides safer query handling and helps prevent **SQL injection**.

---

## 📚 JDBC Methods Used

| Method | Usage |
|---|---|
| `DriverManager.getConnection()` | Establish database connection |
| `prepareStatement()` | Create parameterized SQL statement |
| `setInt()` | Set integer parameter |
| `setString()` | Set string parameter |
| `executeQuery()` | Execute `SELECT` queries |
| `executeUpdate()` | Execute `INSERT`, `UPDATE`, `DELETE` |
| `ResultSet.next()` | Move through query results |
| `getString()` | Retrieve String data |
| `getInt()` | Retrieve integer data |
| `close()` | Close database resources |

---

## 🧠 Key JDBC Concepts Demonstrated

This project helps demonstrate:

- JDBC architecture
- Database connectivity
- CRUD operations
- `Connection`
- `PreparedStatement`
- `ResultSet`
- SQL queries
- Parameterized queries
- Exception handling
- Scanner-based input
- Menu-driven applications
- MySQL integration

---

## 🔮 Future Improvements

Possible improvements include:

- Add input validation
- Use `try-with-resources`
- Add logging
- Implement a layered architecture
- Add DAO pattern
- Add service layer
- Add connection pooling
- Add a GUI using JavaFX
- Build a REST API using Spring Boot
- Add unit and integration tests
- Containerize the application using Docker

---

## 👨‍💻 Author

**Milind Hanchate**

Computer Science Engineering Graduate

---

## ⭐ If You Find This Project Useful

If this project helped you learn Java JDBC and MySQL, consider giving the repository a ⭐ on GitHub.
