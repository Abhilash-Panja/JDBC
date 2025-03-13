# CRUD Operations Using PreparedStatements in Java

This project demonstrates how to perform basic CRUD (Create, Read, Update, Delete) operations in Java using `PreparedStatement` with JDBC.

## Steps to Perform CRUD Operations

### 1. Load the JDBC Driver

Use `Class.forName()` to load the JDBC driver.

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### 2. Establish a Connection

Create a connection to the database using `DriverManager`.

```java
Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/database_name", "username", "password");
```

### 3. Create a PreparedStatement

Use the `Connection` interface to prepare SQL queries.

```java
String query = "INSERT INTO student_table (name, age, marks) VALUES (?, ?, ?)";
PreparedStatement statement = connection.prepareStatement(query);
```

### 4. Execute SQL Queries

- **INSERT Query**

```java
statement.setString(1, "John");
statement.setInt(2, 22);
statement.setDouble(3, 85.5);
int rowsAffected = statement.executeUpdate();
if (rowsAffected > 0) {
    System.out.println("Insert successful!");
}
```

- **SELECT Query**

```java
String selectQuery = "SELECT * FROM student_table";
PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
ResultSet resultSet = selectStatement.executeQuery();
while (resultSet.next()) {
    System.out.println("Name: " + resultSet.getString("name"));
    System.out.println("Age: " + resultSet.getInt("age"));
    System.out.println("Marks: " + resultSet.getDouble("marks"));
}
```

- **UPDATE Query**

```java
String updateQuery = "UPDATE student_table SET marks = ? WHERE name = ?";
PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
updateStatement.setDouble(1, 90.0);
updateStatement.setString(2, "John");
int rowsUpdated = updateStatement.executeUpdate();
System.out.println("Rows updated: " + rowsUpdated);
```

- **DELETE Query**

```java
String deleteQuery = "DELETE FROM student_table WHERE name = ?";
PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
deleteStatement.setString(1, "John");
int rowsDeleted = deleteStatement.executeUpdate();
System.out.println("Rows deleted: " + rowsDeleted);
```

## Notes

- Use `?` as placeholders for dynamic values in SQL queries.
- Always close `Connection`, `PreparedStatement`, and `ResultSet` objects to avoid resource leaks.

## Best Practices

- Handle SQL exceptions using try-catch blocks.
- Use try-with-resources for automatic resource management.
- Validate user inputs to prevent SQL injection.

---

Feel free to contribute or suggest improvements!
