package payment.prj;
import java.sql.*;
public class Payments {

    public static void placeOrder() {

        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false);
            String stockSql = "UPDATE product SET stock = stock - ? WHERE product_name=?";
            PreparedStatement ps1 = con.prepareStatement(stockSql);
            ps1.setInt(1, 1);
            ps1.setString(2, "Laptop");
            ps1.executeUpdate();
            String orderSql = "INSERT INTO orders(customer_name,product_name,quantity,total_price) VALUES(?,?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(orderSql);
            ps2.setString(1, "Abi");
            ps2.setString(2, "Laptop");
            ps2.setInt(3, 1);
            ps2.setDouble(4, 50000);
            ps2.executeUpdate();
            String paymentSql = "INSERT INTO payments(customer_name,amount,payment_method) VALUES(?,?,?)";
            PreparedStatement ps3 = con.prepareStatement(paymentSql);
            ps3.setString(1, "Abi");
            ps3.setDouble(2, 50000);
            ps3.setString(3, "UPI");
            ps3.executeUpdate();
            con.commit();
            System.out.println("Order Placed Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        placeOrder();
    }
}