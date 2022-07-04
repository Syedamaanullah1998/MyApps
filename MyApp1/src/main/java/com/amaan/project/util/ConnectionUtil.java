
package com.amaan.project.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {
	private Connection connection;
    public ConnectionUtil() {
    }

    public static Connection getConnection() {
        

        try {
        	Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/myds");
            Connection connection = dataSource.getConnection();
            return connection;
        } 
        catch (NamingException var3) {
            var3.printStackTrace();
            
        } 
        catch (SQLException var4) {
            var4.printStackTrace();
        }
        return null;
        
    }
    
}
