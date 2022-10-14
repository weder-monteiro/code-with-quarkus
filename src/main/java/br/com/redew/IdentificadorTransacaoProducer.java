package br.com.redew;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class IdentificadorTransacaoProducer {

    @Produces
    @DefaultBean
    @RequestScoped
    public IdentificadorTransacao produceTeste() {
        return new IdentificadorTransacao("test-");
    }

    @Produces
    @IfBuildProfile("prod")
    @RequestScoped
    public IdentificadorTransacao produceProd() {
        return new IdentificadorTransacao("prod-");
    }

}
