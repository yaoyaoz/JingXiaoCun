package com.jingxiaocun.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//@Component
public class JdbcUtils {

//	@Value("${mysql-driver}")
	private String driver;
	private String url;
	private String username;
	private String password;
	
	protected Logger logger = Logger.getLogger(getClass());
	
	public Connection getConnection() throws SQLException {
		
		try {
//			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
//			Properties prop = new Properties();
//			prop.load(in);
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/JingXiaoCun?useUnicode=true&characterEncoding=UTF-8";
			username = "root";
			password = "123456";
			Class.forName(driver);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		return DriverManager.getConnection(url, username, password);
	}
		
	public void release(Connection conn, Statement st, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
