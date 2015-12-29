package Swing.Control;

import Swing.util.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qiuxin on 15/12/29.
 */
public class modifyNote {
    public static void modify(String note, String oldNote) {
        Connection con = DBConnect.Connect();
        String sqlStr = "UPDATE notes SET notes=\'"+note+"\' WHERE notes=\'"+oldNote+"\';";
        Statement stat = null;
        try {
            stat = con.createStatement();
            int rs = stat.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
