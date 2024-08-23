package org.example.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dto.UserDto;
import org.example.service.impl.UserServiceImpl;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRessource {

    @Inject
    UserServiceImpl bookService;

    @GET
    public Response getAll() {
        return Response.ok(bookService.findAll()).status(201).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        return Response.ok(bookService.findByID(id)).status(201).build();
    }

    @POST
    public Response save(UserDto bookDto){
        return Response.ok(bookService.save(bookDto)).status(201).build();
    }

    @PATCH
    @Path("/{id}")
    public Response update(@PathParam("id")long id, UserDto bookDto){
        return Response.ok(bookService.update(id, bookDto)).status(201).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id")long id, UserDto bookDto){
        return Response.ok(bookService.update(id, bookDto)).status(201).build();
    }
}
