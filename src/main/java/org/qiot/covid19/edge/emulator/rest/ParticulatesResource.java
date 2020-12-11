package org.qiot.covid19.edge.emulator.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.qiot.covid19.edge.emulator.services.ParticulatesService;

@Path("/particulates")
@ApplicationScoped
public class ParticulatesResource {
    
    @Inject
    ParticulatesService service;

    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String getParticulates() throws Exception {
        return service.produceAsString();
    }
}
