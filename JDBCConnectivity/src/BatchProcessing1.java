import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/netseeddemo";
        String username = "root";
        String password = "Carpus_Server1800";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
            con.setAutoCommit(false);

            Statement st = con.createStatement();
            st.addBatch("Insert into StudentRecords values (4, 'Usman Khan', 'Python', 78)");
            st.addBatch("Insert into StudentRecords values (5, 'Vibhor', 'Python', 65)");
            st.addBatch("Insert into StudentRecords values (6, 'Vrishank', 'Python', 80)");
            int[] batchResult = st.executeBatch();
            con.commit();
            for (int x : batchResult) {
                System.out.print(x + " ");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
