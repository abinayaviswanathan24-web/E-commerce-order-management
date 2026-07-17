package customer.com;
import java.sql.*;
public class Viewcustomer {
    public static void viewCustomer() {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM customer";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Customer ID   : " + rs.getInt("customer_id"));
                System.out.println("Customer Name : " + rs.getString("customer_name"));
                System.out.println("Phone         : " + rs.getString("phone"));
                System.out.println("City          : " + rs.getString("city"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        viewCustomer();
    }
}