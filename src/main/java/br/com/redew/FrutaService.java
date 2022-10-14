package br.com.redew;


import io.quarkus.arc.Lock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Lock
@ApplicationScoped
public class FrutaService {

    @Inject
    IdentificadorTransacao identificadorTransacao;

    @Lock(value = Lock.Type.READ, time = 3, unit = TimeUnit.SECONDS)
    public List<Fruta> list() {
        System.out.println(identificadorTransacao.getIdentificadorTransacao());
        return Fruta.listAll();
    }

    @Transactional
    public void novaFruta(Fruta fruta) {
        System.out.println(identificadorTransacao.getIdentificadorTransacao());
        fruta.persist();
    }

}
