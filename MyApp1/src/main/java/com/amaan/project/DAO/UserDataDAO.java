package com.amaan.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amaan.project.model.User;
import com.amaan.project.model.UserData;
import com.amaan.project.util.ConnectionUtil;

public class UserDataDAO {
	
	public int save(UserData userData) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = null;
        try {
                statement = connection.prepareStatement("insert into userData(title,content,user) values(?,?,?)");
                statement.setString(1, userData.getTitle());
                statement.setString(2, userData.getContent());
                statement.setInt(3, userData.getUser());
                int dataUpdated = statement.executeUpdate();
                return dataUpdated;
        } catch(SQLException e) {
            e.printStackTrace();
            
        }
        try {
        	statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return 0;
    }
	
	
	public List<UserData> read(User user) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = null;
        List<UserData> userDataList = new ArrayList<>();
        
        try {
                statement = connection.prepareStatement("SELECT userData.title,userData.content,userData.user FROM userData INNER JOIN users ON userData.user = users.id WHERE users.username = ?");
                statement.setString(1, user.getUsername());
                
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()) {
                	UserData userData = new UserData();
                	userData.setTitle(resultSet.getString(1));
                	userData.setContent(resultSet.getString(2));
                	userData.setUser(resultSet.getInt(3));
                	userDataList.add(userData);
                }
                
        } catch(SQLException e) {
            e.printStackTrace();
            
        }
        try {
        	statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return userDataList;
    }
	
	
	
	public int delete(String title) {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement=null;
        
        try {
                statement = connection.prepareStatement("DELETE FROM userData WHERE title=?");
                statement.setString(1, title);
                int deletedData = statement.executeUpdate();  
                return deletedData;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
        	statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return 0;
    }
	
	public int delete(User user) {
		Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement=null;
        
        try {
                statement = connection.prepareStatement("DELETE FROM userData WHERE user=?");
                statement.setInt(1, user.getId());
                int deletedData = statement.executeUpdate();  
                return deletedData;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
        	statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return 0;
    }
		
}
	
