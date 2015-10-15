package com.sis.historiasClinicas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/historiaClinica")
public class HistoriasClinicasService {

	private SISPersistence persistence;

	public HistoriasClinicasService() {
		persistence = new SISPersistence();
		persistence.conectar();
	}

	@Path("dummy")
	@GET
	@Produces({ "application/json" })
	public Response dummyService() {
		return Response.status(200).entity(persistence.dummyService())
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Produces({ "application/json" })
	public Response historiaClinicaService() {
		return Response.ok(persistence.historiasClinicasService().toString())
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("{id}")
	@GET
	@Produces({ "application/json" })
	public Response historiaClinicaByIdService(@PathParam("id") int id) {
		return Response
				.ok(persistence.historiasClinicasByIdService(id).toString())
				.header("Access-Control-Allow-Origin", "*").build();
	}
}
