package com.cranajit.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Base {
    @Context
    public UriInfo uriInfo;

    @GET
    public String getBase(@Context HttpHeaders headers,
                          @HeaderParam("token") String token,
                          @CookieParam("Expires") String expire) {

        return "headers: "+headers.getRequestHeaders().entrySet().toString()+
                " cookie: expire: "+expire+
                " header: token: "+token;
    }
}
