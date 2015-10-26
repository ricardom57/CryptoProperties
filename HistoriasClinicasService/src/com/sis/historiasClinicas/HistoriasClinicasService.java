package com.sis.historiasClinicas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/historiaClinica")
public class HistoriasClinicasService {

	@GET
	@Produces({ "application/json" })
	public Response historiaClinicaService() {
		return Response
				.ok(SISPersistence.historiasClinicasService().toString())
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("{id}")
	@GET
	@Produces({ "application/json" })
	public Response historiaClinicaByIdService(@PathParam("id") int id) {
		return Response
				.ok(SISPersistence.historiasClinicasByIdService(id).toString())
				.header("Access-Control-Allow-Origin", "*").build();
	}
}
