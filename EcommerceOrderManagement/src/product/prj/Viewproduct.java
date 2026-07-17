package product.prj;
import java.sql.*;
public class Viewproduct {
    public static void viewProduct() {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM product";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Product Name : " + rs.getString("product_name"));
                System.out.println("Price        : " + rs.getDouble("price"));
                System.out.println("Stock        : " + rs.getInt("stock"));
                
            }con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        viewProduct();
    }
}