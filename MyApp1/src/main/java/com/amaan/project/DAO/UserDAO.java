package com.amaan.project.DAO;

import com.amaan.project.model.User;
import com.amaan.project.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public boolean save(User user) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement1=null;
        PreparedStatement statement2=null;

        try {
        	
            statement1 = connection.prepareStatement("SELECT * from users where username=?");
            statement1.setString(1, user.getUsername());
            ResultSet resultSet1 = statement1.executeQuery();
        	
  
            if (resultSet1.next()) {
                return false;
                
            } else {
                statement2 = connection.prepareStatement("insert into users(username,fName,lName,email,password) values(?,?,?,?,?)");
                statement2.setString(1, user.getUsername());
                statement2.setString(2, user.getFirstName());
                statement2.setString(3, user.getLastName());
                statement2.setString(4, user.getEmail());
                statement2.setString(5, user.getPassword());
                int executeUpdate = statement2.executeUpdate();
                return true;
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
            
        }
        
        try {
        	statement1.close();
        	statement2.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return false;
        
    }
    
    
    public int delete(User user) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement=null;
        

        try {
            statement = connection.prepareStatement("DELETE FROM users where username=?");
            statement.setString(1, user.getUsername());
            int rowCount = statement.executeUpdate();
            return rowCount;
            
        } catch (SQLException var6) {
            var6.printStackTrace();
        }
        
        try {
        	statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return 0;
    }
    
    
    

    public User findUser(String username, String encyptedpassword) {
        User user = new User();
        PreparedStatement statement=null;
        Connection connection = ConnectionUtil.getConnection();

        try {
            statement = connection.prepareStatement("select * from users where username=? AND password=?");
            statement.setString(1, username);
            statement.setString(2, encyptedpassword);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	do{
                    user.setId(resultSet.getInt(1));
                    user.setUsername(resultSet.getString(2));
                    user.setFirstName(resultSet.getString(3));
                    user.setLastName(resultSet.getString(4));
                    user.setEmail(resultSet.getString(5));
                    user.setPassword(resultSet.getString(6));
                }while(resultSet.next());
            	
                return user;
            } else {
                return null;
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
            
        }
        try {
        	statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return user;
    }
    
}
