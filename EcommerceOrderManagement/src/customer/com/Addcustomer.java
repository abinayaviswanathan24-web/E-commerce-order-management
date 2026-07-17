package customer.com;
import java.sql.*;
public class Addcustomer {

    public static void addCustomer(String name, String phone, String city) {

        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";

        try {

            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO customer(customer_name, phone, city) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, city);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Added Successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        addCustomer("Abi", "9876543210", "Chennai");
        addCustomer("Hema", "9123456780", "Coimbatore");
        addCustomer("Priya", "9012345678", "Madurai");

    }
}