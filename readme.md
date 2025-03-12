Performing the Curd Operations Using the CreateStatements.
/

---

     Step-1: Loading the Driver's by using Class.forName();

    *****************************************************************************

      Step-2: Creating a Connection object by using DriverManager and
      we make use of the connection interface to store the instance of the
      connection created by the DriverManager;

     *****************************************************************************

      Step-3: Creating a Statement object by using the Connection interface
      to excute the SQL Queries.

      ****************************************************************************

      Step-4: Executing the SQL Queries by using the Statement interface
       And  when we are using the createStatement() we have to write the SQL
       Commands Manually.
       And we have Different types of SQL Commands like
       1. SELECT
       2. INSERT
       3. UPDATE
       4. DELETE
       To excute the "SELECT" we will make use of the statement.executeQuery(selectQuery);
       and to store the result we make use of the ResultSet interface.

       ***************************************************************************

       Syntax for the  "SELECT" Query:
       String selectQuery="SELECT * FROM student_table";
       ResultSet resultSet = statement.executeQuery(selectQuery);
       And we make use of the resultSet interface to stor the result of the query.
       And we iterate the resultSet by using the hasnext() method.

       ***************************************************************************

       Syntax for the  "INSERT" Query:
       String insertQuery="INSERT INTO table_name (oder_of attributes) VALUES (values of attributes);
       int Rows_affected=statement.executeUpdate(insertQuery); and it will give integer as output
       and by using the simple if condition we can able to check how many rows are affected.

       And same Syntax for the "UPDATE" and "DELETE" Query.

       ***************************************************************************

---

    /
