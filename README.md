# IPL Team Management System

## Project Overview

The IPL Team Management System is a Java-based console application designed to manage and analyze player data for Indian Premier League (IPL) teams. It provides functionality for adding, deleting, updating, and viewing player information, along with specific features like filtering batters and bowlers based on performance criteria.

---

## Features

- **View All Players:** Display all players across teams.
- **Filter Batters:** List players who scored more than 5000 runs.
- **Filter Bowlers:** List players who took more than 50 wickets.
- **Add Player:** Add a new player to a specific team.
- **Update Player:** Update details of an existing player.
- **Delete Player:** Remove a player from the system.
- **Search by Team:** View all players in a specific team.
- **Search by Jersey Number:** Find a player by their jersey number.

---

## Prerequisites

1. **Java Development Kit (JDK)** 8 or higher
2. **MySQL Database**
3. **Maven** (Optional, for dependency management)

---

## Database Setup

### 1. Create Database

Execute the following SQL commands to set up the database:

```sql
CREATE DATABASE iplteams;
USE iplteams;

CREATE TABLE players (
    name VARCHAR(50),
    jersey_no INT PRIMARY KEY,
    runs INT,
    wickets INT,
    team VARCHAR(50)
);
```

### 2. Add Sample Data (Optional)

```sql
INSERT INTO players (name, jersey_no, runs, wickets, team) VALUES
('Virat Kohli', 18, 6000, 20, 'RCB'),
('Jasprit Bumrah', 93, 200, 100, 'MI'),
('MS Dhoni', 7, 5000, 30, 'CSK');
```

---

## How to Run the Application

### 1. Clone the Repository

```bash
git clone <repository-url>
```

### 2. Import into an IDE

- Open the project in **IntelliJ IDEA**, **Eclipse**, or **VS Code**.
- Ensure your IDE is configured for Java and supports Maven (if applicable).

### 3. Configure Database Connection

Update the `IPLUtility` class with your MySQL credentials:

```java
public static Connection support() {
    String url = "jdbc:mysql://localhost:3306/iplteams";
    String username = "<your-username>";
    String password = "<your-password>";
    try {
        return DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
```

### 4. Compile and Run

- Compile the project using your IDE or a terminal:

```bash
javac *.java
```

- Run the main class `IPLClient`:

```bash
java IPLClient
```

---

## Usage Guide

- Choose an option from the menu to perform desired operations.
- Follow on-screen prompts for input.

### Example Menu

```
1. View All Players
2. Filter Batters
3. Filter Bowlers
4. Add Player
5. Update Player
6. Delete Player
7. Search by Team
8. Search by Jersey Number
9. Exit
Enter your choice:
```

---

## Best Practices Followed

- **Parameterization:** Prevents SQL injection by using parameterized queries.
- **Resource Management:** Ensures proper closing of database connections and resources.
- **Separation of Concerns:** DAO, Service, and Client layers separate functionality.
- **Validation:** Input validation to handle incorrect user entries.

---

## Future Improvements

- **Spring Boot Integration:** Migrate to a Spring Boot-based architecture for scalability.
- **Pagination:** Implement pagination for large datasets.
- **Logging:** Replace `System.out.println` with a logging framework (e.g., SLF4J, Log4j).
- **Enhanced UI:** Develop a graphical or web-based user interface.
- **Testing:** Add unit and integration tests using JUnit and Mockito.

---

## Contributing

1. Fork the repository.
2. Create a feature branch.
3. Commit changes and push to your branch.
4. Create a pull request.

---


## Contact

For any queries or suggestions, please contact:

- **Email:** (mailto\:sajalbagde@gmail.com)
- **GitHub:** ((https://github.com/sajal-0))

---

Enjoy managing IPL teams efficiently with this application!

