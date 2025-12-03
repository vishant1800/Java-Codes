import java.sql.*;

// Read data
public class JDBCConnect {
    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/netseeddemo";
            String username = "root";
            String password = "Carpus_Server1800";
            String sql = "select * from jdbcdemo";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            System.out.println("statement " + statement);

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                System.out.print(resultSet.getInt("id") + " - ");
                System.out.print(resultSet.getString("name") + " - ");
                System.out.println(resultSet.getInt("age"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}