package Swing.Control;

import Swing.util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by qiuxin on 15/12/28.
 */
public class searchNote {
    public static ArrayList search(int id, String noteContent) {
        Connection con = DBConnect.Connect();
        String sqlStr = "SELECT notes FROM notes WHERE (notes LIKE "+ "\"%" + noteContent + "%\""
                + " AND notes.userid=" + id + ");";
        Statement stat = null;
        ArrayList<String> str = new ArrayList<String>();
        try {
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sqlStr);
            while (rs.next()){
                str.add(rs.getString("notes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
}
