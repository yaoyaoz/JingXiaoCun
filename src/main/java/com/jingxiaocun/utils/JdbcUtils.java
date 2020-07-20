package com.jingxiaocun.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class JdbcUtils {

//	@Value("${mysql.driver}")
//	private String driver;
//
//	@Value("${mysql.url}")
//	private String url;
//
//	@Value("${mysql.username}")
//	private String username;
//
//	@Value("${mysql.password}")
//	private String password;

	protected Logger logger = Logger.getLogger(getClass());

	@Autowired
	private JxcProperties jxcProperties;

	public Connection getConnection() throws SQLException {
		
		try {
//			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
//			Properties prop = new Properties();
//			prop.load(in);
//			driver = prop.getProperty("driver");
//			url = prop.getProperty("url");
//			username = prop.getProperty("username");
//			password = prop.getProperty("password");
			Class.forName(jxcProperties.getMysqlDriver());
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		return DriverManager.getConnection(jxcProperties.getMysqlUrl(),
				jxcProperties.getMysqlUsername(),
				jxcProperties.getMysqlPassword());
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
