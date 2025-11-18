import java.sql.*;

public class JDBC {

    static final String URL = "jdbc:mysql://localhost:3306/DbNamee";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Employees (" +
                     "eno INT PRIMARY KEY, " +
                     "ename VARCHAR(50), " +
                     "eDepartment VARCHAR(50), " +
                     "eSalary DOUBLE)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertData() {
        String sql = "INSERT INTO Employees (eno, ename, eDepartment, eSalary) VALUES (?, ?, ?, ?)";
        Object[][] employees = {
            {1, "Kritisha Adhikari", "HR", 50000.0},
            {2, "Kritika Mahat", "IT", 60000.0},
            {3, "Subu Neupane", "Finance", 60000.0},
            {4, "Kritan Adhikari", "Marketing", 55000.0},
            {5, "Dewaki Adhikari", "Sales", 58000.0}
        };

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (Object[] emp : employees) {
                pstmt.setInt(1, (int) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setString(3, (String) emp[2]);
                pstmt.setDouble(4, (double) emp[3]);
                pstmt.executeUpdate();
            }
            System.out.println("Employees records inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateData() {
        String sql = "UPDATE Employees SET eSalary = ? WHERE eSalary < ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, 14000.0);
            pstmt.setDouble(2, 14000.0);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " employee(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteData() {
        String sql = "DELETE FROM Employees WHERE eno = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 2);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " employee(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectData() {
        String sql = "SELECT * FROM Employees WHERE eDepartment = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "IT");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Employees from IT department:");
            while (rs.next()) {
                int eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                String dept = rs.getString("eDepartment");
                double salary = rs.getDouble("eSalary");
                System.out.printf("%d\t%s\t%s\t%.2f%n", eno, ename, dept, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTable();
       // insertData();
       // updateData();
       // deleteData();
       // selectData();
    }
}
