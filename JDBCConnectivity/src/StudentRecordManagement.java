
// add, update, delete, exit, show records
// menu driven

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DatabaseConnectivity {
    private final String url = "jdbc:mysql://localhost:3306/netseeddemo";
    private final String username = "root";
    private final String password = "Carpus_Server1800";
    Connection connect;

    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.connect = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return connect;
    }
}

class StudentRecords extends DatabaseConnectivity {

    public void ShowRecords() {
        try {
            String sql = "select * from StudentRecords";
//            String sql2 = "select * from jdbcdemo";
            Statement ps = connection().createStatement();

            ResultSet resultSet = ps.executeQuery(sql);
//            ResultSet res = ps.executeQuery(sql2);
            System.out.println();
            while(resultSet.next()) {
                System.out.print(resultSet.getInt("roll_no") + " - ");
                System.out.print(resultSet.getString("s_name") + " - ");
                System.out.print(resultSet.getString("course_name") + " - ");
                System.out.println(resultSet.getDouble("percentage"));
            }
//            while(res.next()) {
//                System.out.print(res.getInt("id") + " - ");
//                System.out.print(res.getString("name") + " - ");
//                System.out.println(res.getInt("age"));
//            }
            resultSet.close();
            ps.close();
            connection().close();

        } catch (Exception e) {
//            System.out.println(e.getMessage() + "inside Student records");
            e.printStackTrace();
        }
    }
}

class Add extends DatabaseConnectivity{
    public void AddRecords(Scanner sc) {
        Connection con;
        try {
            con = connection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO StudentRecords VALUES (?,?,?,?)";
            PreparedStatement prepState = con.prepareStatement(sql);

            while(true) {
                System.out.println("Enter Roll no. - ");
                int Stud_id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Student Name - ");
                String s_name = sc.nextLine();
                System.out.println("Enter Course Name - ");
                String c_name = sc.nextLine();
                System.out.println("Enter percentage - ");
                double marks = sc.nextDouble();
                sc.nextLine();

                prepState.setInt(1, Stud_id);
                prepState.setString(2, s_name);
                prepState.setString(3, c_name);
                prepState.setDouble(4, marks);

                prepState.addBatch();

                System.out.println("Do you wish to add more values?(Y/N)");
                String reply = sc.nextLine();

                if (reply.equalsIgnoreCase("N")) {
                    break;
                }
            }

            int[] batchResults = prepState.executeBatch();
            for (int x : batchResults) {
                System.out.println(x + " row affected");
            }
            con.commit();

            prepState.close();
            con.close();
        } catch (Exception e) {
//            System.out.println(e.getMessage() + "inside add records");
            e.printStackTrace();
        }
    }
}

class Update extends DatabaseConnectivity {
    public void UpdateRecords(Scanner sc) {
        System.out.println("What do you want to update?");
        System.out.println("Student Name\nCourse Name\nPercentage");
        String option = sc.nextLine();

        Map<String, String> mpp = new HashMap<>();
        mpp.put("Student Name", "s_name");
        mpp.put("Course Name", "course_name");
        mpp.put("Percentage", "percentage");

        String colName = mpp.get(option);
        System.out.println("Enter the Roll Number of the student");
        int r_num = sc.nextInt();
        sc.nextLine();

        try {
            String sql = "UPDATE StudentRecords SET " + colName + " = ? WHERE roll_no = ?" ;
            PreparedStatement prepSt = connection().prepareStatement(sql);

            if(colName.equals("s_name")) {
                System.out.println("Enter student's new name");
                String Stud_name = sc.nextLine();
                prepSt.setString(1, Stud_name);
                prepSt.setInt(2, r_num);
            }
            if(colName.equals("course_name")) {
                System.out.println("Enter course name");
                String Course_name = sc.nextLine();
                prepSt.setString(1, Course_name);
                prepSt.setInt(2, r_num);
            }
            if(colName.equals("percentage")) {
                System.out.println("Enter new percentage");
                double new_percent = sc.nextDouble();
                prepSt.setDouble(1, new_percent);
                prepSt.setInt(2, r_num);
            }

            int statementResult = prepSt.executeUpdate();
            if(statementResult > 0) {
                System.out.println(statementResult + " row updated successfully");
            } else {
                System.out.println("0 row affected");
            }

        } catch (Exception e) {
//            System.out.println(e.getMessage() + " inside update records");
            e.printStackTrace();
        }
    }
}

class Delete extends DatabaseConnectivity{
    public void DeleteRecords(Scanner sc) {
        System.out.println("\nRecord Deletion");
        System.out.print("Enter the roll number of the student: ");
        int r_num = sc.nextInt();
        sc.nextLine();

        try {
            String query = "DELETE FROM StudentRecords WHERE roll_no = ?";
            PreparedStatement preparedStatement = connection().prepareStatement(query);

            preparedStatement.setInt(1, r_num);
            int statementResults = preparedStatement.executeUpdate();

            if (statementResults > 0) {
                System.out.println(statementResults + " Deleted successfully");
                System.out.println(statementResults + "rows affected");
            }
            preparedStatement.close();
            connection().close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        DatabaseConnectivity d = new DatabaseConnectivity();
        StudentRecords Stud_obj = new StudentRecords();
        Add Add_obj = new Add();
        Update Update_obj = new Update();
        Delete Delete_obj = new Delete();

        String ans;
        do {
            System.out.println("Choose an option");
            System.out.println("1. Add Records");
            System.out.println("2. Update Records");
            System.out.println("3. Delete Records");
            System.out.println("4. Show Records");
            System.out.println("5. Exit");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    Add_obj.AddRecords(sc);
                    break;

                case 2:
                    Update_obj.UpdateRecords(sc);
                    break;

                case 3:
                    Delete_obj.DeleteRecords(sc);
                    break;

                case 4:
                    Stud_obj.ShowRecords();
                    break;

                case 5:
                    System.out.println("Exit from the program");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Do you wish to continue?(Y/N)");
            ans = sc.nextLine();
        } while (ans.equalsIgnoreCase("Y"));

        sc.close();
    }
}

