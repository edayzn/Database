import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.*;
import java.sql.Statement;
import java.sql.ResultSet;
public class Utility {


  public static void main(String[] args) throws SQLException {

           System.out.println("-------- MySQL JDBC Connection Testing ------------");

             try {
                 Class.forName("com.mysql.jdbc.Driver");
             } catch (ClassNotFoundException e) {
                 System.out.println("Where is your MySQL JDBC Driver?");
                 e.printStackTrace();
                 return;
             }

             System.out.println("MySQL JDBC Driver Registered!");
             Connection connection = null;

             try {
                 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proje","root", "123456");

             } catch (SQLException e) {
                 System.out.println("Connection Failed! Check output console");
                 e.printStackTrace();
                 return;
             }

             if (connection != null) {
                 System.out.println("You made it, take control your database now!");
             } else {
                 System.out.println("Failed to make connection!");
             }


       String sql="SELECT pkid,adi,ozellik,fiyat,altkategoriId From urunler";
      Statement stm=  connection.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while(rs.next()){
          //Retrieve by column name
          int pkid  = rs.getInt("pkid");
          String adi = rs.getString("adi");
          String ozellik = rs.getString("ozellik");
          int fiyat = rs.getInt("fiyat");
          int altkategoriId = rs.getInt("altkategoriId");
          //Display values
          System.out.print("ID: " + pkid);
          System.out.print(", adi: " + adi);
          System.out.print(", ozellik: " + ozellik);
          System.out.print(", fiyat: " + fiyat);
          System.out.println(", altkategoriId: " + altkategoriId);
      }
         }
}














      /*  public static Connection getConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/proje", "root", "123456");
                return con;
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Database.getConnection() Error -->"
                        + ex.getMessage());
                return null;
            }
        }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
}*/
