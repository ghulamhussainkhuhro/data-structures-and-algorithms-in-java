import java.sql.*;

public class MySQLConnection2 {

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Parks_and_Recreation", "admin", "password");

            // Create a statement object to execute the SQL query
            Statement stmt = con.createStatement();

            // Execute the query and store the result in a ResultSet
            String sql = "SELECT * FROM parks_and_recreation.employee_demographics";
            ResultSet rs = stmt.executeQuery(sql);

            // Process the ResultSet and print the data
            while (rs.next()) {
                // Retrieving and printing each column's data
                int id = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                Date birthDate = rs.getDate("birth_date");

                // Print the retrieved data
                System.out.println("Employee ID: " + id + ", Name: " + firstName + " " + lastName + ", Age: " + age + ", Gender: " + gender + ", Birth Date: " + birthDate);
            }

            // Close the ResultSet and Statement objects
            rs.close();
            stmt.close();

            // Close the database connection
            con.close();

        } catch (Exception e) {
            // Handle any exceptions
            System.out.println(e);
        }
    }
}
