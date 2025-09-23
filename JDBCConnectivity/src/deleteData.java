import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class deleteData {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/netseeddemo";
            String username = "root";
            String password = "Carpus_Server1800";
            String sql = "delete from jdbcdemo where id = 2";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(url, username, password);

            Statement st = connect.createStatement();

            int rowsAffected = st.executeUpdate(sql);
            System.out.println(rowsAffected);
            if(rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " successfully");
            } else {
                System.out.println(rowsAffected + " rows affected");
            }

            st.close();
            connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
