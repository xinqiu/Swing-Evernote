package Swing.Control;

import java.sql.*;

import Swing.View.EnterView;
import Swing.util.DBConnect;

/**
 * Created by qiuxin on 15/12/24.
 */
public class Login {
    public static boolean LoginCheck(String userName, String passWord) {
        Connection con = DBConnect.Connect();
        Statement stat = null;
        ResultSet rs = null;
        String sqlStr = "SELECT password FROM user WHERE username=" + '"'+userName+'"';
        try {
            stat = con.createStatement();
            rs = stat.executeQuery(sqlStr);
            rs.next();
            if (rs.getString("password").equals(passWord)) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnect.close(con, rs, stat);
        }
        return false;
    }
}
