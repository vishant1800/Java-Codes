import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class preparedState {
    public static void main(String[] args) {
        try {
            int sid = 4;
            String sname = "RDJ";
            int sage = 60;

            String url = "jdbc:mysql://localhost:3306/netseeddemo";
            String username = "root";
            String password = "Carpus_Server1800";
            // String sql = "Insert into jdbcdemo values (" + s_id + ", '" + s_name
            String sql = "Insert into jdbcdemo values (?,?,?)";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1,sid);
            ps.setString(2, sname);
            ps.setInt(3, sage);

            ps.executeUpdate();

            ps.close();
            connect.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}