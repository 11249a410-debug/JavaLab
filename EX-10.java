//CREATE DATABASE scsvmv_lab;
//USE scsvmv_lab;
//CREATE TABLE student (
//reg_no VARCHAR(10) PRIMARY KEY,
//name VARCHAR(40),
//marks INT
//);
//INSERT INTO student VALUES ('101','Aravind',78), ('102','Divya',91);



// Ex 10: retrieve all rows from the student table

import java.sql.*;

public class FetchData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/scsvmv_lab";
        String user = "root";
        String password = "root";

        String query = "SELECT * FROM student";

        try (
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query)
        ) {
            System.out.printf("%-10s %-15s %s%n",
                    "REG_NO", "NAME", "MARKS");

            while (rs.next()) {
                System.out.printf("%-10s %-15s %d%n",
                        rs.getString("reg_no"),
                        rs.getString("name"),
                        rs.getInt("marks"));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}



// Ex 10: insert a row safely with a PreparedStatement

import java.sql.*;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/scsvmv_lab";
        String sql = "INSERT INTO student VALUES (?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(
                url, "root", "root"
            );
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, "103");
            ps.setString(2, "Karthik");
            ps.setInt(3, 45);

            int n = ps.executeUpdate();

            System.out.println(n + " row inserted.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

// Case Study 10, file 2: add, search, update, delete

import java.sql.*;
import java.util.Scanner;

public class StudentApp {
    static void run(String sql, Object... v) {
        try (
            Connection c = Db.open();
            PreparedStatement p = c.prepareStatement(sql)
        ) {
            for (int i = 0; i < v.length; i++) {
                p.setObject(i + 1, v[i]);
            }

            if (sql.startsWith("SELECT")) {
                ResultSet rs = p.executeQuery();

                while (rs.next()) {
                    System.out.println(
                        rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getInt(3)
                    );
                }
                rs.close();
            } else {
                System.out.println(
                    p.executeUpdate() + " row(s) affected."
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Register number to search: ");
        String reg = sc.nextLine();

        run("SELECT * FROM student WHERE reg_no = ?", reg);

        run("UPDATE student SET marks = ? WHERE reg_no = ?",
            95, reg);

        run("SELECT * FROM student WHERE reg_no = ?", reg);

        sc.close();
    }
}
