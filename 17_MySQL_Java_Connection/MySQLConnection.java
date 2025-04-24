import java.sql.*;

public class MySQLConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Parks_and_Recreation", "admin", "password");

            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM parks_and_recreation.employee_demographics";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("first_name");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            rs.close();
            stmt.close();

            con.close();

        } catch (Exception e) {
            // Handle any exceptions
            System.out.println(e);
        }
    }
}
