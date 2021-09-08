package br.inatel.dm110.api.supplier;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tp")
public interface SupplierService {

	@POST
	@Path("/supplier")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String saveSupplier(SupplierTO supplier);

	@GET
	@Path("/supplier/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SupplierTO getSupplierById(@PathParam("id") Integer id);

	@GET
	@Path("/supplier/cnpj/{cnpj}")
	@Produces(MediaType.APPLICATION_JSON)
	public SupplierTO getSupplierByCnpj(@PathParam("cnpj") String cnpj);

	@GET
	@Path("/supplier")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SupplierTO> listSuppliers();

	@PUT
	@Path("/supplier/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String updateSupplier(SupplierTO supplier);

}