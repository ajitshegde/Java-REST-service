package com.ajit.rest.inventory;

import java.sql.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.*;

import com.ajit.doa.OracleAJ;
import com.ajit.util.ToJSON;

@Path("/v1/inventory")
public class V1_inventory {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String returnAllPcParts() throws Exception{
		
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		
		try{
			conn = OracleAJ.AjithRestConn().getConnection();
			query = conn.prepareStatement("select * from proj.pc_parts");
			ResultSet rs = query.executeQuery();
			
			ToJSON conv = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = conv.toJSONArray(rs);
			query.close();
			
			returnString = json.toString();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn != null)
				conn.close();
		}
		
		return returnString;
	}
}
