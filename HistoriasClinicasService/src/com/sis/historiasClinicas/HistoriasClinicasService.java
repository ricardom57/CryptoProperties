package com.sis.historiasClinicas;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/historiaClinica")
public class HistoriasClinicasService {

	@Path("dummy")
	@GET
	@Produces({ "application/json" })
	public Response dummyService() throws SQLException {
		return Response.status(200).entity(new SISPersistence().dummyService())
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Produces({ "application/json" })
	public Response historiaClinicaService() throws SQLException {
		return Response.ok(new SISPersistence().historiasClinicasService().toString())
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("{id}")
	@GET
	@Produces({ "application/json" })
	public Response historiaClinicaByIdService(@PathParam("id") int id) throws SQLException {
		return Response
				.ok(new SISPersistence().historiasClinicasByIdService(id).toString())
				.header("Access-Control-Allow-Origin", "*").build();
	}
}
