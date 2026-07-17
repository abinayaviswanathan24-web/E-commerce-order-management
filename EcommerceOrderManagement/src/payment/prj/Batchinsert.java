package payment.prj;
import java.sql.*;
public class Batchinsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO product(product_name,price,stock) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Monitor");
            ps.setDouble(2, 12000);
            ps.setInt(3, 5);
            ps.addBatch();
            ps.setString(1, "Speaker");
            ps.setDouble(2, 2500);
            ps.setInt(3, 10);
            ps.addBatch();
            ps.setString(1, "Headphone");
            ps.setDouble(2, 1800);
            ps.setInt(3, 20);
            ps.addBatch();
            ps.executeBatch();
            System.out.println("Batch Insert Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}