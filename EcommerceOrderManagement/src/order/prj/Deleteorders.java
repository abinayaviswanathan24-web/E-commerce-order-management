package order.prj;
import java.sql.*;
public class Deleteorders {
    public static void deleteOrder(int orderId) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "DELETE FROM orders WHERE order_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Order Deleted Successfully");
            } else {
                System.out.println("Order Not Found");
            }con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        deleteOrder(1);
    }
}