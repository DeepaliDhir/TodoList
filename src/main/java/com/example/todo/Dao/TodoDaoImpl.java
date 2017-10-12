package com.example.todo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.todo.Todo;
public class TodoDaoImpl {
	 private static final String DB_DRIVER = "org.h2.Driver";
	    private static final String DB_CONNECTION = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1";
	    private static final String DB_USER = "sa";
	    private static final String DB_PASSWORD = "";

	    
	    /**
	     * This method will create the database
	     * @throws SQLException
	     */
	    public void createTodo() throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement createPreparedStatement = null;
	        String CreateQuery = "CREATE TABLE TODO(id bigint auto_increment, item varchar(255) NOT NULL, flag number)";
	        try {
	            connection.setAutoCommit(false);
	            createPreparedStatement = connection.prepareStatement(CreateQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
	    }
	    
	    
	    /**
	     * This method will insert the data in table created 
	     * @param todoItem
	     * @param flag
	     * @throws SQLException
	     */
	    public  void insertTodo(String todoItem, int flag) throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement insertPreparedStatement = null;

	       String InsertQuery = "INSERT INTO TODO" + " (item,flag) values " + "(?,?)";

	        try {
	            connection.setAutoCommit(false);
	            System.out.println("hello");
	            insertPreparedStatement = connection.prepareStatement(InsertQuery);
	            insertPreparedStatement.setString(1,todoItem);
	            insertPreparedStatement.setInt(2, flag);
	            insertPreparedStatement.executeUpdate();
	            insertPreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
	    }

	    
	    /**
	     * This method will return the todo taking item name and flag as argument 
	     * @param todoItem
	     * @param flag
	     * @return
	     * @throws SQLException
	     */
	    public Todo retriveTodo(String todoItem, int flag) throws SQLException {
	        Connection connection = getDBConnection();
	        Todo al = new Todo();
	        PreparedStatement selectPreparedStatement = null;
	        String SelectQuery = "select item from TODO where item='"+todoItem+"' AND flag="+flag;
	        try {
	            connection.setAutoCommit(false);
	            selectPreparedStatement = connection.prepareStatement(SelectQuery);
	            ResultSet rs = selectPreparedStatement.executeQuery();
	            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
	            while (rs.next()) {
	                System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("item") + "    " + rs.getInt("flag"));
	             al=new Todo(rs.getInt("id"),rs.getString("item"), rs.getInt("flag"));
	            }
	            selectPreparedStatement.close();
	           
	           connection.commit();
	           
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
			return al;
	       
	    }
	    
	    /**
	     * This method will return the complete set of data inserted in table
	     * @return
	     * @throws SQLException
	     */
	    public List<Todo> retriveAll() throws SQLException {
	    	List<Todo> al = new ArrayList<Todo>();
	    	
	        Connection connection = getDBConnection();
	        PreparedStatement selectPreparedStatement = null;
	        
	        String SelectQuery = "select * from TODO";
	        try {
	            connection.setAutoCommit(false);
	            selectPreparedStatement = connection.prepareStatement(SelectQuery);
	            ResultSet rs = selectPreparedStatement.executeQuery();
	            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
	            while (rs.next()) {
	                System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("item") + "    " + rs.getInt("flag"));
	                al.add(new Todo(rs.getInt("id"),rs.getString("item"), rs.getInt("flag")));
	            }
	            selectPreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
			return al;
	    }
	    
	    
	    /**
	     * This method will retrive the data based on flag whether the work is completed or in pending state 
	     * @param todoFlag
	     * @return
	     * @throws SQLException
	     */
	    public List<Todo> retriveAllForFlag(int todoFlag) throws SQLException {
	    	List<Todo> al = new ArrayList<Todo>();
	    	
	        Connection connection = getDBConnection();
	        PreparedStatement selectPreparedStatement = null;
	        
	        String SelectQuery = "select * from TODO where flag="+todoFlag;
	        try {
	            connection.setAutoCommit(false);
	            selectPreparedStatement = connection.prepareStatement(SelectQuery);
	            ResultSet rs = selectPreparedStatement.executeQuery();
	            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
	            while (rs.next()) {
	                System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("item") + "    " + rs.getInt("flag"));
	                al.add(new Todo(rs.getInt("id"),rs.getString("item"), rs.getInt("flag")));
	            }
	            selectPreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
			return al;
	    }
	    

	    /**
	     * This method will delete the row based on item name passed 
	     * @param todoItem
	     * @throws SQLException
	     */
	   public  void deleteTodo(String todoItem) throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement deletePreparedStatement = null;
	        String DeleteQuery = "delete TODO where item='"+todoItem+"'";
	        try {
	            connection.setAutoCommit(false);
	            deletePreparedStatement = connection.prepareStatement(DeleteQuery);
	            deletePreparedStatement.executeUpdate();
	            
	            deletePreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
	    }

	    
	   /**
	    * This method will update the row based on item
	    * @param todoItem
	    * @param oldItem
	    * @throws SQLException
	    */
	    public void updateTodo(String todoItem ,String oldItem) throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement updatePreparedStatement = null;
	        String DeleteQuery = "UPDATE TODO SET item='"+todoItem+"'"+ " where item='"+oldItem+"'";
	        System.out.println("Query is "+ DeleteQuery);
	        System.out.println("Deepali old item value is "+todoItem);
	        System.out.println("Deepali item value is "+todoItem);
	        try {
	            connection.setAutoCommit(true);
	            updatePreparedStatement = connection.prepareStatement(DeleteQuery);
	            updatePreparedStatement.executeUpdate();
	            updatePreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
	    }
	    
	    
	    public void updateFlag(String todoItem) throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement updateFlafPreparedStatement = null;
	        String DeleteQuery = "UPDATE TODO SET flag=1 where item='"+todoItem+"'";
	        System.out.println("Deepali old item value is "+todoItem);
	        System.out.println("Deepali item value is "+todoItem);
	        try {
	            connection.setAutoCommit(false);
	            updateFlafPreparedStatement = connection.prepareStatement(DeleteQuery);
	            updateFlafPreparedStatement.executeUpdate();
	            updateFlafPreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
	    }
	    
	    
	    /**
	     * This method will update the row when the work is completed 
	     * @param todoItem
	     * @throws SQLException
	     */
	    public void completeTodo(String todoItem) throws SQLException {
	        Connection connection = getDBConnection();
	        PreparedStatement completePreparedStatement = null;
	        String DeleteQuery = "UPDATE TODO SET flag="+1+" where item='"+todoItem+"'";
	        try {
	            connection.setAutoCommit(false);
	            completePreparedStatement = connection.prepareStatement(DeleteQuery);
	            completePreparedStatement.executeUpdate();
	            completePreparedStatement.close();
	           connection.commit();
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connection.close();
	        }
	    }
	   

	    private static Connection getDBConnection() {
	        Connection dbConnection = null;
	        try {
	            Class.forName(DB_DRIVER);
	        } catch (ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	        try {
	            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	            return dbConnection;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return dbConnection;
	    }
	
	
}
