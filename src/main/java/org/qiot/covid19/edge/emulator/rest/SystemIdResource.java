//package org.qiot.covid19.edge.emulator.rest;
//
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//
//import org.eclipse.microprofile.config.inject.ConfigProperty;
//
//
//@Path("/system")
//@ApplicationScoped
//public class SystemIdResource {
//
//    @ConfigProperty(name = "measurementstation.stationid", defaultValue = "100000007eb33b29")
//    String systemId;
//
//    //    @PostConstruct
//    //    void init() {
//    //        int leftLimit = 48; // numeral '0'
//    //        int rightLimit = 122; // letter 'z'
//    //        int targetStringLength = 16;
//    //        Random random = new Random();
//    //
//    //        String generatedString = random
//    //                .ints(leftLimit, rightLimit + 1)
//    //                .filter(i -> (i <= 57 || i >= 65)
//    //                        && (i <= 90 || i >= 97))
//    //                .limit(targetStringLength)
//    //                .collect(StringBuilder::new,
//    //                        StringBuilder::appendCodePoint,
//    //                        StringBuilder::append)
//    //                .toString();
//    //        systemId = generatedString;
//    //    }
//
//    @GET
//    @Path("/id")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getSystemId() {
//        return systemId;
//    }
//}
