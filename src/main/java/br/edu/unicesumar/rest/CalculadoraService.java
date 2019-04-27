package br.edu.unicesumar.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/calculadora")
public class CalculadoraService {

	@GET
	@Path("/teste/{param1}/{param2}")
	public Response olaMundo(@PathParam("param1") String mensagem1, @PathParam("param2") String mensagem2) {
		
		String texto = "ola unicesumar  " + mensagem1 + " - " + mensagem2;
		
		return Response.status(200).entity(texto).build();
	}
}
