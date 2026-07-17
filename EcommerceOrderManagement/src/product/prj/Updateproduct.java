package product.prj;

import java.sql.*;

public class Updateproduct {

    public static void updatePrice(String name, double price) {

        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "UPDATE product SET price=? WHERE product_name=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, price);
            ps.setString(2, name);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Price Updated Successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        updatePrice("Laptop", 50000);
        
    }
}