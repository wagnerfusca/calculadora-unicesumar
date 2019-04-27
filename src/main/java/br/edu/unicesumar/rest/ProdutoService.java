package br.edu.unicesumar.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.unicesumar.dao.ProdutoDao;
import br.edu.unicesumar.model.Produto;

@Path("/json/produto")
public class ProdutoService {

	private ProdutoDao dao = new ProdutoDao();
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public Produto getProdutoJSON() {

		Produto produto = new Produto();
		produto.setNome("Moto X - Android");
		produto.setQuantidade(10);
	
		return produto;

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response criarProdutoJSON(Produto produto) {

		dao.save(produto);
		
		String result = "produto Criado : " + produto.toString();
		return Response.status(201).entity(result).build();

	}
	
	
	@GET
	@Path("/listas")
	@Produces("application/json")
	public Response listar() {

		List<Produto> produtos = dao.list();
		String resultado = "quantidade de produtos: "+ produtos.size();
		return Response.status(201).entity(resultado).build();

	}

}
