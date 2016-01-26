package com.ajit.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;

import com.ajit.doa.*;
@Path("/v1/status")
public class V1_status {
	private static final String api_ver = "00.00";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<strong>Version:</strong>"+api_ver;
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDBStatus() throws Exception{
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		try {
			conn = OracleAJ.AjithRestConn().getConnection();
			query = conn.prepareStatement("select name from proj.info");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				myString = rs.getString("name");
			}
			query.close();
			returnString = "<p>Database Status</p>"+"<p>Database Name "+myString+"</p>";
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			if(conn != null)
				conn.close();
		}
		return returnString;
	}
}
