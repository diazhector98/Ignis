/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignis;

/**
 *
 * @author hectordiazaceves
 */
import java.sql.*;

public class Database {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9290852", "sql9290852", "VgkPCchXtu");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }

    public void getData() {
        try {
            String sql = "select * from elements";
            rs = st.executeQuery(sql);
            System.out.println("Data from online Database :");
            while (rs.next()) {
                String symbol = rs.getString("symbol");
                String name = rs.getString("name");
                System.out.println(symbol + ":" + name);
            }

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
}
