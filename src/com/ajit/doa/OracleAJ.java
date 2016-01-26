package com.ajit.doa;

import javax.naming.*;
import javax.sql.*;
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

}
