package io.qiot.covid19.edge.emulator.rest;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.qiot.covid19.edge.emulator.services.GasService;


@Path("/gas")
@ApplicationScoped
public class GasResource {

    @Inject
    GasService service;

    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String getGas() throws Exception {
        return service.produceAsString();
    }

}
