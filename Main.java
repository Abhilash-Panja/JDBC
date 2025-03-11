import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
class Main{
  private static final String URL="jdbc:mysql://localhost:3306/?user=root";
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
    }
    catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
}