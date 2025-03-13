import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class Main{
  private static final String URL="jdbc:mysql://localhost:3306/student";
  private static final String USER="root";
  private static final String PASS="root";
  public static void main(String[] args) {
    /*****************************************************************************************
     
    Step-1: Loading the Driver's by using Class.forName()
    
    *****************************************************************************************/
    try{
    Class.forName("com.mysql.cj.jdbc .Diver");
    }
    catch(ClassNotFoundException e){
      System.out.println(e.getMessage());
    }
    try{
      /*****************************************************************************************
      
      Step-2: Creating a Connection object by using DriverManager and
      we make use of the connection interface to store the instance of the 
      connection created by the DriverManager;

     *****************************************************************************************/
      Connection connection=DriverManager.getConnection(URL, USER, PASS);
      /*****************************************************************************************
      
      Step-3: Creating a Statement object by using the Connection interface 
      to excute the SQL Queries.       
     
      *****************************************************************************************/
      String query="insert into student_table (name,age,marks) values (?,?,?)";
      PreparedStatement statement=connection.prepareStatement(query);
      // setting up the values 
      statement.setString(1,"Rahul");
      statement.setInt(2, 20);
      statement.setDouble(3, 90.60);
      /*****************************************************************************************
       
      Step-4: Executing the SQL Queries by using the Prepared Statement interface
       to execute the SQL Queries.
       And we have Different types of SQL Commands like
       1. SELECT
       2. INSERT
       3. UPDATE
       4. DELETE
       To excute the "SELECT" we will make use of the statement.executeQuery(selectQuery);
       and to store the result we make use of the ResultSet interface.

       *****************************************************************************************

       Syntax for the  "SELECT" Query:
       String selectQuery="SELECT * FROM student_table";
       ResultSet resultSet = statement.executeQuery(selectQuery);
       And we make use of the resultSet interface to stor the result of the query.
       And we iterate the resultSet by using the hasnext() method.

       *******************************************************************************************

       Syntax for the  "INSERT" Query:
       String insertQuery="INSERT INTO table_name (oder_of attributes) VALUES (values of attributes);
       int Rows_affected=statement.executeUpdate(insertQuery); and it will give integer as output
       and by using the simple if condition we can able to check how many rows are affected.
       
       And same Syntax for the "UPDATE" and "DELETE" Query.

       *********************************************************************************************
      */
      int rows_affected=statement.executeUpdate();
      if(rows_affected>0){
        System.out.println("Data inserted successfully");
      }
      else{
        System.out.println("Data not inserted");
      }
    }
    catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
}