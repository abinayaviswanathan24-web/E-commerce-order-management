package customer.com;
import java.sql.*;
public class Updatecustomer {

    public static void updateCity(String name, String city) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE customer SET city=? WHERE customer_name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, city);
            ps.setString(2, name);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Customer Updated Successfully");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        updateCity("Abi", "Salem");
    }
}