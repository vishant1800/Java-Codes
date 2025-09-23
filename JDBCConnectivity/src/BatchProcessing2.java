import java.sql.*;
import java.util.Scanner;

public class BatchProcessing2 {
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

            String query = "INSERT INTO StudentRecords values (?,?,?,?)";
            PreparedStatement prepStatment = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println("Roll no. - ");
                int rollNo = sc.nextInt();
                sc.nextLine();
                String S_Name = sc.nextLine();
                String course = sc.nextLine();
                int marks = sc.nextInt();
                sc.nextLine();

                prepStatment.setInt(1, rollNo);
                prepStatment.setString(2, S_Name);
                prepStatment.setString(3, course);
                prepStatment.setInt(4, marks);

                prepStatment.addBatch();

                System.out.println("Do you want to insert more values?(Y/N)");
                String ans = sc.nextLine();
                if(ans.equalsIgnoreCase("N")) {
                    break;
                }
            }
            int[] batchResult = prepStatment.executeBatch();
            con.commit();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
