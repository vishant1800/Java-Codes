import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class updateData {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/netseeddemo";
            String username = "root";
            String password = "Carpus_Server1800";
            String sql = "insert into jdbcdemo values (1, 'Prashant', 25),(2, 'Shubhojit', 24), (3, 'Vaishali', 24)";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(sql);

            if(rowsAffected > 0) {
                System.out.println("Data inserted successfully");
                System.out.println(rowsAffected + " rows affected");
            } else {
                System.out.println(rowsAffected + " rows affected");
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
