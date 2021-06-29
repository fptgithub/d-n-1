/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JDBC {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
    }

    public static Connection con = null;

    public static Connection getconnect() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/DUAN1_THITHPT_2";
        String username = "root";
        String passworld = "songlong";
        return DriverManager.getConnection(url, username, passworld);
    }

    public boolean delete(String sql, Object... params) {
        PreparedStatement pst = null;
        try {
            if (con != null) {
                pst = (PreparedStatement) con.prepareStatement(sql);
                setparam(pst, params);
                con.setAutoCommit(false);
                pst.execute();
                con.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("excute fail");
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    public boolean excuteupdate(String sql, Object... params) throws SQLException {
        PreparedStatement pst = null;
        try {
            if (con != null) {
                pst = (PreparedStatement) con.prepareStatement(sql);
                setparam(pst, params);
                con.setAutoCommit(false);
                pst.executeUpdate();
                con.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("excute fail");
            con.rollback();
            return false;
        }
    }

    public ResultSet select(String sql) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            if (con != null) {
                pst = (PreparedStatement) con.prepareStatement(sql);
                rs = pst.executeQuery();
                return rs;
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return rs;
        }
    }

    public ResultSet selectByParam(String sql, Object... params) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            if (con != null) {
                pst = (PreparedStatement) con.prepareStatement(sql);
                setparam(pst, params);
                rs = pst.executeQuery();
                return rs;
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return rs;
        }
    }

    public boolean selectcheck(String sql, Object... params) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            if (con != null) {
                pst = (PreparedStatement) con.prepareStatement(sql);
                setparam(pst, params);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setparam(PreparedStatement pst, Object... params) throws SQLException {
        int i = 1;
        for (Object object : params) {
            pst.setObject(i, object);
            i++;
        }
    }
}
