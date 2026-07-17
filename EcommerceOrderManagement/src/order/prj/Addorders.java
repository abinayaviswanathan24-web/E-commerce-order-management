package order.prj;
import java.sql.*;
public class Addorders {
    public static void addOrder(String customerName, String productName,
                                int quantity, double totalPrice) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO orders(customer_name, product_name, quantity, total_price) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setString(2, productName);
            ps.setInt(3, quantity);
            ps.setDouble(4, totalPrice);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Order Placed Successfully");
            }con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        addOrder("Abi", "Laptop", 1, 50000);
        addOrder("Priya", "Mouse", 2, 1600);
    }
}