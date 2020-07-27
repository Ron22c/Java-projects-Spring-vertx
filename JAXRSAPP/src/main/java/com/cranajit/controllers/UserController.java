package com.cranajit.controllers;

import com.cranajit.entiyclasses.UserModel;
import com.cranajit.services.UserService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("users")
public class UserController {

    UserService service = new UserService();

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserModel> getUserInfo(@QueryParam("gender") String gender,
                                       @QueryParam("start") int start,
                                       @QueryParam("end") int end) {
        List<UserModel> users = null;
        if(gender!=null) {
            users = service.getUserByGender(gender);
        } else {
            users = service.getUsers();
        }
        if(end>0 && end<users.size()) {
            users = users.subList(start, end);
        }
        return users;
    }

    @POST
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUserData(UserModel model, @Context UriInfo info) {
        URI location=info.getAbsolutePath();
        UserModel addedModel = service.addUserData(model);
        return Response.created(location).entity(addedModel).build();
    }

    @PUT
    @Path("user/{phone}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserModel editUserData(@PathParam("phone") String phone, UserModel updatedUser) {
        updatedUser.setPhone(phone);
        UserModel userData = service.updateUserData(updatedUser);
        return userData;
    }

    @DELETE
    @Path("user/{phone}")
    public void deleteUser(@PathParam("phone") String phone) {
        service.deleteUser(phone);
    }

    @Path("user/{phone}/books")
    public BooksController booksController() {
        return new BooksController();
    }
}