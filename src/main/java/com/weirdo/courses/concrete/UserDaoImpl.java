package com.weirdo.courses.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.weirdo.courses.connect.ConnectionFactory;
import com.weirdo.courses.interfaces.UserDao;
import com.weirdo.courses.model.User;

public class UserDaoImpl implements UserDao{

	ConnectionFactory con = new ConnectionFactory();
	Connection c = con.getConnection();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		UserDaoImpl ud = new UserDaoImpl();
		
	//	User u = new User("Alemitu", "weirdo", 21);
		
		//System.out.println(ud.insertUser(u));
		
	//	User u = new User(1, "Kebede", "wirdo", 30);
	//	System.out.println(ud.updateUser(u));
		
	//	User u = new User(3);
	//	System.out.println(ud.deleteUser(u));
		
		
		
		User u = ud.loginUser(new User("Hamza", "2222"));
		
		
			System.out.println("ID: " + u.getId());
			System.out.println("Name: " + u.getName());
			System.out.println("Age: " + u.getAge());
			System.out.println("Password: " + u.getPassword());
			System.out.println("============================");
		
		
	}

	public Set<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from user");
			Set users = new HashSet();
			
			
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				
				users.add(user);
			}
			
			return users;
			
		}catch(Exception e) {
			
		}
		
		
		
		return null;
	}

	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps = c.prepareStatement("insert into user(name, age, password) values(?,?,?)");
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getPassword());
			
			int i = ps.executeUpdate();
			if(i==1) {
				return true;
			}
			
		}catch(Exception e) {
			
		}
		
		
		return false;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps = c.prepareStatement("Update user set name=?, password =?, age =? where id=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setInt(4, user.getId());
			int i = ps.executeUpdate();
			if(i == 1) {
				return true;
			}
		}catch(Exception e) {
			
		}
		
		
		
		return false;
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		
		
		try {
			PreparedStatement ps = c.prepareStatement("Delete from user where id =?");
			ps.setInt(1, user.getId());
			int i = ps.executeUpdate();
			if(i==1) {
				return true;
			}
			
		}catch(Exception e) {
			
		}
		
		return false;
	}

	public User loginUser(User user) {
		// TODO Auto-generated method stub
		
		
		try {
			PreparedStatement ps = c.prepareStatement("Select * from user where name =? and password = ?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			
			ResultSet rs =ps.executeQuery();
			
			rs.next();
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setAge(rs.getInt("age"));
			u.setPassword(rs.getString("password"));
			return u;
			
		}catch(Exception e) {
			
		}
		
		
		return null;
	}

}
