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

/**
 *
 * @author hectordiazaceves
 */
public class Database {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    /**
     *
     */
    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9291783", "sql9291783", "nuR1GyHkBW");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }

    /**
     *
     */
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
    
    /**
     *
     * @param symbol
     * @param name
     * @param atomicNumber
     */
    public void insertToElement(String symbol, String name, int atomicNumber){
        try {
            String sql = getInsertToElementsTableQuery(symbol,name,atomicNumber);
            int result = st.executeUpdate(sql);            

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    /**
     *
     * @param symbol
     * @param name
     * @param atomicNumber
     * @return
     */
    public String getInsertToElementsTableQuery(String symbol, String name, int atomicNumber){
        String elements =  "(ID, Symbol, Name, AtomicNumber)";
        String values = "(" + String.valueOf(atomicNumber) + ",'" + symbol + "','" + name + "'," + String.valueOf(atomicNumber) + ")";
        System.out.println("INSERT INTO elements VALUES " + values);
        return "INSERT INTO elements VALUES " + values;
    }
    
    /**
     *
     * @param username
     */
    public void registerUser(String username){
        try {
            String sql = "INSERT INTO users VALUES ";
            sql += "(NULL, '" + username + "', '5')";
            
            int result = st.executeUpdate(sql);            

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    /**
     *
     * @param username
     * @return
     */
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
    
    /**
     *
     * @param userId
     * @param atomSymbol
     * @return
     */
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
    
    /**
     *
     * @param userId
     * @param atomSymbol
     * @return
     */
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

    /**
     *
     * @param userId
     * @return
     */
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
    
    /**
     *
     * @param userId
     * @param symbol
     * @param newQuantity
     */
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
    
    /**
     *
     * @param userId
     * @param symbol
     * @param quantity
     */
    public void insertUserAtomQuantity(int userId, String symbol, int quantity){
        try {
            String sql = "INSERT INTO UserAtoms (UserId, symbol, quantity) ";
            sql += "VALUES ('" + String.valueOf(userId) + "','" + symbol + "','" + String.valueOf(quantity) + "')";
            st.executeUpdate(sql);            
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    /**
     *
     * @param userId
     */
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
    
    /**
     *
     * @param storeObject
     */
    public void addStoreObject(StoreObject storeObject){
        try {
            String sql = "INSERT INTO objects VALUES ";
            sql += "('" + storeObject.getId() + "', '" + storeObject.getName() + "')";
            st.executeUpdate(sql);            

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
    /**
     *
     * @param storeObject
     * @param userId
     */
    public void addObjectToUser(StoreObject storeObject, int userId){
        try {
            String sql = "INSERT INTO UserObjects VALUES ";
            sql += "('" + String.valueOf(userId) + "', '" + String.valueOf(storeObject.getId()) + "')";
            st.executeUpdate(sql);            

        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }

    /**
     *
     * @param userId
     * @param so
     * @return
     */
    public boolean userHasObject(int userId, StoreObject so) {
        try {
            String sql = "SELECT * FROM UserObjects ";
            String whereClause = "WHERE UserId = '" + String.valueOf(userId) + "'";
            whereClause += " AND ObjectId = '" + so.getId() + "'";
            sql += whereClause;
            System.out.println(sql);
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
    
    /**
     *
     * @param username
     * @return
     */
    public User getUserWithUsername(String username){
        try {
            String sql = "SELECT * FROM users WHERE username = '" + username + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                return new User(id, username);
            }
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
            return null;
        }
        return null;
    }
    
    /**
     *
     * @param userId
     * @return
     */
    public int getUserLives(int userId){
        try {
            String sql = "SELECT * FROM users WHERE id = '" + userId + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                int lives = Integer.parseInt(rs.getString("lives"));
                return lives;
            }
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
            return 5;
        }
        return 5;
    }
    
    /**
     *
     * @param userId
     * @param lives
     */
    public void updateUserLives(int userId, int lives){
        try {
            String sql = "UPDATE users ";
            sql += "SET lives = '" + String.valueOf(lives) + "' ";
            sql += "WHERE id = '" + String.valueOf(userId) + "' ";
            st.executeUpdate(sql);            
        } catch (Exception ex) {
            System.out.println("Error is found :" + ex);
        }
    }
    
}
