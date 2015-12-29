package Swing.Control;

import Swing.util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qiuxin on 15/12/28.
 */
public class deleteNote {
    public static void delete(String note) {
        Connection con = DBConnect.Connect();
        String sqlStr = "DELETE FROM notes WHERE " +
                "notes=\"" +  note +"\";";
        Statement stat = null;
        try {
            stat = con.createStatement();
            int rs = stat.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
