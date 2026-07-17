package product.prj;
import java.sql.*;
public class Deleteproduct {
    public static void deleteProduct(String name) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "DELETE FROM product WHERE product_name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product Deleted Successfully");
            }con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        deleteProduct("Mouse");
    }
}