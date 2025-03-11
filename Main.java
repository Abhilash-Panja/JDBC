import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class Main{
  private static final String URL="jdbc:mysql://localhost:3306/student";
  private static final String USER="root";
  private static final String PASS="root";
  public static void main(String[] args) {
    try{
    Class.forName("com.mysql.cj.jdbc .Diver");
    }
    catch(ClassNotFoundException e){
      System.out.println(e.getMessage());
    }
    try{
      Connection connection=DriverManager.getConnection(URL, USER, PASS);
      Statement statement=(Statement)connection.createStatement();
      String insertQuery = "INSERT INTO student_table (id, name, marks, age) VALUES (3, 'Priyanshu', 90.89, 20)";
      String selectQuery = "SELECT * FROM student_table";
      statement.executeUpdate(insertQuery);
      ResultSet resultSet = statement.executeQuery(selectQuery);
      while (resultSet.next()) {
        int id=resultSet.getInt("id");
        int age=resultSet.getInt("age");
        String name=resultSet.getString("name");
        double marks=resultSet.getDouble("marks");
        System.out.println("id"+" "+id+" "+"age"+" "+age+" "+"name"+" "+name+" "+"marks"+" "+marks);
      }
    }
    catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
}