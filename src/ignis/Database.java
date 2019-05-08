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
import java.util.HashMap;
import java.util.Map;

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
    
    public void insertToElement(String symbol, String name, int atomicNumber){
        try {
            String sql = getInsertToElementsTableQuery(symbol,name,atomicNumber);
            int result = st.executeUpdate(sql);            

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    public String getInsertToElementsTableQuery(String symbol, String name, int atomicNumber){
        String elements =  "(ID, Symbol, Name, AtomicNumber)";
        String values = "(" + String.valueOf(atomicNumber) + ",'" + symbol + "','" + name + "'," + String.valueOf(atomicNumber) + ")";
        System.out.println("INSERT INTO elements VALUES " + values);
        return "INSERT INTO elements VALUES " + values;
    }
    
    public void registerUser(String username){
        try {
            String sql = "INSERT INTO users VALUES ";
            sql += "(NULL, '" + username + "')";
            
            int result = st.executeUpdate(sql);            

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    public boolean usernameInDatabase(String username){
        try {
            String sql = "SELECT * FROM users WHERE username = '" + username + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
            return false;
        }
        return false;
    }
    
    public boolean userHasAtom (int userId, String atomSymbol){
        try {
            String sql = "SELECT * FROM UserAtoms ";
            String whereClause = "WHERE UserId = '" + String.valueOf(userId) + "'";
            whereClause += " AND symbol = '" + atomSymbol + "'";
            sql += whereClause;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
            return false;
        }
        return false;
    }
    
    public int getUserAtomQuantity(int userId, String atomSymbol) {
        try {
            String sql = "SELECT * FROM UserAtoms ";
            String whereClause = "WHERE UserId = '" + String.valueOf(userId) + "'";
            whereClause += " AND symbol = '" + atomSymbol + "'";
            sql += whereClause;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String quantity = rs.getString("quantity");
                return Integer.parseInt(quantity);
            }
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
            return 0;
        }
        return 0;
    }

    public Map<String, Integer> getUserAtomsMap (int userId){
        Map<String, Integer> map = new HashMap<>();
        try {
            String sql = "SELECT * FROM UserAtoms ";
            String whereClause = "WHERE UserId = '" + String.valueOf(userId) + "'";
            sql += whereClause;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String symbol = rs.getString("symbol");
                String quantity = rs.getString("quantity");
                map.put(symbol, Integer.parseInt(quantity));
            }
            return map;
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
            return null;
        }  

    }
    
    public void updateUserAtomQuantity(int userId, String symbol, int newQuantity){
        try {
            String sql = "UPDATE UserAtoms";
            sql += "SET quantity = '" + String.valueOf(newQuantity) + "' ";
            sql += "WHERE UserId = '" + String.valueOf(userId) + "' ";
            sql += "AND symbol = '" + symbol + "'";
            st.executeUpdate(sql);            
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    public void insertUserAtomQuantity(int userId, String symbol, int quantity){
        try {
            String sql = "INSERT INTO UserAtoms (UserId, symbol, quantity) ";
            sql += "VALUES ('" + String.valueOf(userId) + "','" + symbol + "','" + String.valueOf(quantity) + "')";
            st.executeUpdate(sql);            
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    public void deleteAllUserAtoms(int userId){
        try {
            String sql = "DELETE FROM UserAtoms";
            sql += " WHERE UserId = '" + String.valueOf(userId) + "' ";
            System.out.println(sql);
            st.executeUpdate(sql);            
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
}
