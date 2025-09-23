import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createData {
    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/netseeddemo";
            String username = "root";
            String password = "Carpus_Server1800";
            String sql = "Create table jdbcdemo (id int, name varchar(50), age int)";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(sql);

            if(rowsAffected == 0) {
                System.out.println("Created table successfully");
                System.out.println(rowsAffected + " rows affected");
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

