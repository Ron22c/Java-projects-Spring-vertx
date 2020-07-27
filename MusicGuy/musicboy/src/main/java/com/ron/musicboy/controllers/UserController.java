package com.ron.musicboy.controllers;

import com.ron.musicboy.models.UserModel;
import com.ron.musicboy.services.UserService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("users")
public class UserController {
	UserService userService = new UserService();
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserModel model) {
    	UserModel user = userService.createUser(model);
    	if (user!=null) return Response.accepted(user).build();
        return Response.status(400).build();
    }
    
    @GET
    @Path("{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam(value = "phone") String phone) {
    	UserModel userData = userService.getUser(phone);
    	return Response.ok(userData).build();    
    }
    
    
}
