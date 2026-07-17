package payment.prj;
import java.sql.*;
public class Metadata {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/JDBCproject";
        String user = "root";
        String pass = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Table Name : " + rsmd.getTableName(1));
            System.out.println("Number of Columns : " + rsmd.getColumnCount());
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println("Column " + i + " : " + rsmd.getColumnName(i));
                System.out.println("Data Type : " + rsmd.getColumnTypeName(i));
              
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}