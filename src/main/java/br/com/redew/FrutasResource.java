package br.com.redew;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutasResource {

    @Inject
    FrutaService frutaService;

    @GET
    public List<Fruta> list() {
        return frutaService.list();
    }

    @POST
    @Transactional
    public void novaFruta(Fruta fruta) {
        frutaService.novaFruta(fruta);
    }
}