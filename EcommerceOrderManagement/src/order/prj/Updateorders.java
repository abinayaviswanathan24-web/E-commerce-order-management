package order.prj;
import java.sql.*;
public class Updateorders {
    public static void updateOrder(int orderId, String customerName,
                                   String productName, int quantity,
                                   double totalPrice) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE orders SET customer_name=?, product_name=?, quantity=?, total_price=? WHERE order_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setString(2, productName);
            ps.setInt(3, quantity);
            ps.setDouble(4, totalPrice);
            ps.setInt(5, orderId);
            ps.executeUpdate();
            System.out.println("Order Updated Successfully");
        con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        updateOrder(1, "Abi", "Laptop", 2, 100000);
    }
}