package org.example.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Client;
import org.example.service.ClientService;

import java.time.Period;
import java.util.List;

@Path(("/api/clients"))
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientRessource {
    @Inject
    ClientService clientService;

    @POST
    @Path("/create")
    public Response saveClient(Client client) {
        Client nouvelleClient = clientService.save(client);
        return Response.ok(nouvelleClient).status(201).build();
    }

    @GET
    public List<Client> getAllClient() {
        return clientService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Client client = clientService.findById(id);
        return Response.ok(client).status(201).build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response UpdateById(@PathParam("id")Long id, Client client){
        Client clientUpdate = clientService.updateClient(id,client);
        return Response.ok(clientUpdate).status(201).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id){
        clientService.deleteClient(id);
        return Response.ok().status(201).build();
    }
}
