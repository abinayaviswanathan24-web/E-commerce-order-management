package product.prj;

import java.sql.*;

public class Addproduct {

    public static void addProduct(String name, double price, int stock) {

        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO product(product_name, price, stock) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, stock);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product Added Successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        addProduct("Laptop", 45000, 8);
        addProduct("Mobile", 30000, 15);
        addProduct("Keyboard", 1200, 6);
        addProduct("Mouse", 800, 12);
    }
}