package com.java.db.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLAccess {
	private final static String sqlString="com.mysql.jdbc.Driver";
	private final static String connectionURL="jdbc:mysql://localhost:3306/SampleDB";
	private final static String userName ="root";
	private final static String password="";
	private Connection con;
	private Statement stmt;
	public Statement getConnection(){
		try {
			Class.forName(sqlString);
			con=DriverManager.getConnection(connectionURL,userName,password);  
			stmt=con.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  		  
		
	}
	public boolean addUser(User user){
		String insertSql="insert into users (user_id, username, password, email) values ("+user.getUserId()+",'"+user.getUserName()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
		try {
			Statement st=getConnection();
			int count=st.executeUpdate(insertSql);
			if(count==0){
				return false;
			}
			else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	public boolean deleteUser(int userId){
		String deleteSql=" delete from users where user_id='"+userId+"'";
		System.out.println(deleteSql);
		try {
			Statement st=getConnection();
			int count=st.executeUpdate(deleteSql);
			if(count==0){
				return false;
			}
			else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateUser(User user){
		String updateSql="update users set username='"+user.getUserName()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"' where user_Id="+user.getUserId();
		try {
			Statement st=getConnection();
			int count=st.executeUpdate(updateSql);
			if(count==0){
				return false;
			}
			else{
				return true;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public User viewUser(int userId){
		String viewSql="select * from users where user_Id='"+userId+"'";
		System.out.println(viewSql);
		User user=new User();
		try {
			Statement st=getConnection();
			ResultSet rs=st.executeQuery(viewSql);
				while(rs.next()){
					System.out.println("Entering while loop;");
				user.setUserId(Integer.parseInt(rs.getString("user_id")));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
				}
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public List<User> selectAllUser(){
		String selectAllSql="select * from users";
		List<User> userList=new ArrayList<User>();
		try {
			Statement st=getConnection();
			ResultSet rs= st.executeQuery(selectAllSql);
			if(rs==null){
				return null;
			}
			else{
				while(rs.next()){
					User user=new User();
					user.setUserId(Integer.parseInt(rs.getString("user_id")));
					user.setUserName(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					userList.add(user);
				}
				return userList;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
