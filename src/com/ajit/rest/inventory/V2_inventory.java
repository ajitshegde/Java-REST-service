package com.ajit.rest.inventory;

import java.sql.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.*;

import com.ajit.doa.OracleAJ;
import com.ajit.util.ToJSON;

@Path("/v2/inventory")
public class V2_inventory {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnBrandParts(@QueryParam("brand") String brand ) throws Exception{
		String returnString = null;
		JSONArray json = new JSONArray();
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server not able to provide response").build();
		}
		
		return Response.ok(returnString).build();
	}
}
