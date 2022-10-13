package br.com.redew;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutasResource {

    @GET
    public List<Fruta> list() {
        return Fruta.listAll();
    }

    @POST
    @Transactional
    public void novaFruta() {
        Fruta fruta = new Fruta();
        fruta.nome = "Maçã";
        fruta.qtd = 5;

        fruta.persist();
    }
}