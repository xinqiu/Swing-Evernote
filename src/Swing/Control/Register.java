package Swing.Control;

import Swing.util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qiuxin on 15/12/24.
 */
public class Register {
    public static int submitCheck(String userName, String passWord, String Name, boolean male, boolean female) {
        Connection con = DBConnect.Connect();
        String sqlStr = "SELECT username FROM user;";
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = con.createStatement();
            rs = stat.executeQuery(sqlStr);
            while (rs.next()) {
                if (rs.getString("username").equals(userName))
                    return 0;   // username has existed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(con, rs, stat);
        }
        System.out.println(userName);
        System.out.println(userName.matches("[a-zA-Z0-9_]*"));
        if (userName.isEmpty() || Name.isEmpty()) {
            return 3;   // Empty
        }else if (!userName.matches("[a-zA-Z0-9_]*")) {
            return 2;   // username invalid
        }else if (passWord.length() < 6 || passWord.length() > 16) {
            return 4;   // too short or long password
        }else if (userName.matches("[a-zA-Z0-9_]*") && (male || female)) {
            return 1;   // success
        }
        return 0;
    }

    public static void submit(String userName, String passWord,String Name,
                              Boolean male, Boolean female) {
        Connection con = DBConnect.Connect();
        Statement stat = null;
        Boolean gender; // True == male
        if (male == Boolean.TRUE){
            gender = true;
        }else {
            gender = false;
        }
        String sqlStr = "INSERT INTO user (username, name, password, gender) VALUES (\'" + userName + "\', \'" +
                Name + "\', \'" + passWord +"\', " + gender +");";
        try {
            stat = con.createStatement();
            int rs = stat.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
