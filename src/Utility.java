
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.*;
import java.sql.Statement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

public class Utility {

    Connection connection = null;

    static final String URL="jdbc:mysql://localhost:3306/proje";
    static final String USER="root";
    static final String PASS="123456";

    public static void main(String[] args) throws SQLException {
        Utility gst = new Utility();
        gst.connect();
        gst.list();
    }
    public  void connect() throws SQLException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        Logger logger = null;
        logger.error("Exception" + e);
        return;
    }
    try {
        connection = DriverManager.getConnection(URL,USER,PASS);

    } catch (SQLException e) {
        System.out.println("Connection Failed!");
        Logger logger = null;
        logger.error("Exception " + e);
        return;
    }
    if (connection != null) {
        System.out.println("You made it, take control your database now!");
    } else {
        System.out.println("Failed to make connection!");
    }
    }

    public void list() throws SQLException {
        StringBuffer sgl = new StringBuffer("SELECT pkid,adi,ozellik,fiyat,altkategoriId From urunler");
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(String.valueOf(sgl));
        while (rs.next()) {

            int id = rs.getInt("pkid");
            String name = rs.getString("adi");
            String attreibute = rs.getString("ozellik");
            int price = rs.getInt("fiyat");
            int subcategoryId = rs.getInt("altkategoriId");

            System.out.print("ID: " + id);
            System.out.print(", adi: " + name);
            System.out.print(", ozellik: " + attreibute);
            System.out.print(", fiyat: " + price);
            System.out.println(", altkategoriId: " + subcategoryId);
        }
        connection.close();
        rs.close();
    }
}


