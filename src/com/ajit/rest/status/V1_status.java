package com.ajit.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
	
}
