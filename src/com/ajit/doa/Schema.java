package com.ajit.doa;

import java.sql.*;
import javax.ws.rs.*;
import org.codehaus.jettison.json.*;

import com.ajit.util.ToJSON;

public class Schema extends OracleAJ{
	
   public JSONArray queryReturnBrandParts(String brand)throws Exception{
	Connection conn = null;
	ToJSON conv = new ToJSON();	
	PreparedStatement query = null;
	JSONArray json = new JSONArray();
   
		try {
			conn = mySqlPcPartConn();
			query = conn.prepareStatement("select * from proj.pc_parts where UPPER(PC_PARTS_MAKER) = ?");
			query.setString(1, brand.toUpperCase());
			ResultSet rs = query.executeQuery();
			json = conv.toJSONArray(rs);
			query.close();
			
		} 
			catch(SQLException sqlError){
				sqlError.printStackTrace();
				return json;
			}
			catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		
		finally{
			if(conn!=null)
				conn.close();
		}
		return json;
   }
	
	
}
