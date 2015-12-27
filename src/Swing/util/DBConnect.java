package Swing.util;

import java.sql.*;

/**
 * Created by qiuxin on 15/12/24.
 */
public class DBConnect {
    public static Connection Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Access successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String url = "jdbc:mysql://115.159.96.43/db";
        String user = "root";
        String password = "password";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void close(Connection con, ResultSet rs, Statement stat){
        try {
            if(rs != null){
                con.close();
            }

            if(stat != null){
                con.close();
            }

            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
