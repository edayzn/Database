
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.*;
import java.sql.Statement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
public class Utility {
 // public static String sgl;
    Connection connection = null;

    public static void main(String[] args) throws SQLException {
        Utility gst = new Utility();
        gst.baglan();
        gst.goster();
    }

    public  void baglan() throws SQLException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        Logger logger = null;
        logger.error("Hayda " + e);

        return;
    }
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proje", "root", "123456");
    } catch (SQLException e) {
        System.out.println("Bağlantı Başarısız!");
        Logger logger = null;
        logger.error("Hayda " + e);
        return;
    }
    if (connection != null) {
        System.out.println("Baglandı!");
    } else {
        System.out.println("\n" +"Bağlantı kurulamadı!");
    }

    }

    public void goster() throws SQLException {
        StringBuffer sgl = new StringBuffer("SELECT pkid,adi,ozellik,fiyat,altkategoriId From urunler");
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(String.valueOf(sgl));
        while (rs.next()) {

            int pkid = rs.getInt("pkid");
            String adi = rs.getString("adi");
            String ozellik = rs.getString("ozellik");
            int fiyat = rs.getInt("fiyat");
            int altkategoriId = rs.getInt("altkategoriId");

            System.out.print("ID: " + pkid);
            System.out.print(", adi: " + adi);
            System.out.print(", ozellik: " + ozellik);
            System.out.print(", fiyat: " + fiyat);
            System.out.println(", altkategoriId: " + altkategoriId);

        }
        connection.close();
        rs.close();
    }
}


