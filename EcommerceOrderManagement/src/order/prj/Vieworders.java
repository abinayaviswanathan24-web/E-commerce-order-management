package order.prj;
import java.sql.*;
public class Vieworders {
    public static void viewOrder() {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM orders";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Order ID      : " + rs.getInt("order_id"));
                System.out.println("Customer Name : " + rs.getString("customer_name"));
                System.out.println("Product Name  : " + rs.getString("product_name"));
                System.out.println("Quantity      : " + rs.getInt("quantity"));
                System.out.println("Total Price   : " + rs.getDouble("total_price"));
                
            }con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        viewOrder();
    }
}