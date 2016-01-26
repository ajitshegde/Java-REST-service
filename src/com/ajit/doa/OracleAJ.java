package com.ajit.doa;

import javax.naming.*;
import javax.sql.*;
import java.sql.Connection;
public class OracleAJ {

	private static DataSource Orc = null;
	private static Context context = null;
	
	public static DataSource AjithRestConn() throws Exception{
		if(Orc!=null)
			return Orc;
		
		try{
			if(context == null)
				context = new InitialContext();
		
		
		Context envContext = (Context)context.lookup("java:/comp/env");
		Orc = (DataSource)envContext.lookup("jdbc/ProjectDB");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Orc;
	}

	protected static Connection mySqlPcPartConn(){
		Connection conn = null;
		
		try {
			conn = AjithRestConn().getConnection();
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
