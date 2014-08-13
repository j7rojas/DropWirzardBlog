package com.juan.blog;

import java.sql.ResultSet;

import javax.net.ssl.SSLEngineResult.Status;

import java.sql.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import io.dropwizard.lifecycle.Managed;

public class MySQLManaged implements Managed {
    private Connection con = null;
    private Status  stat = null;
    private ResultSet rs = null;
    private MysqlDataSource dataSource;
    
    public MySQLManaged(MysqlDataSource dataSource) {
		this.dataSource = dataSource;
	}
 
    public void start() throws Exception {
    	/*MysqlDataSource dataSource = new MysqlDataSource();
    	dataSource.setUser("root");
    	dataSource.setPassword("");
    	dataSource.setServerName("127.0.0.1:3306");
    	
    	Connection con = dataSource.getConnection();
    	Statement stat = con.createStatement();
    	ResultSet rs = stat.executeQuery("SELECT ID FROM USERS");*/
    }
 
    public void stop() throws Exception {
    	rs.close();
    	con.close();
    }
 
}
