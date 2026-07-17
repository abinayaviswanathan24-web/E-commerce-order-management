package payment.prj;
import java.sql.*;
public class Resultset {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM orders");
            while (rs.next()) {
                if (rs.getInt("order_id") == 1) {
                    rs.deleteRow();
                    System.out.println("Order Deleted Successfully");
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}