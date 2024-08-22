package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import net.bytebuddy.implementation.bytecode.Throw;
import org.example.entity.Client;
import org.example.repository.ClientRepository;

import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;


    public Client createEntity(String name, String email, String telephone) {
        Client client = new Client(name, email, telephone);
        return client;
    }

    @Transactional
    public Client save(String name, String email, String telephone) {
        Client client = createEntity(name, email, telephone);
        clientRepository.isPersistent(client);
        return client;
    }

    @Transactional
    public Client save(Client entity) {
        clientRepository.isPersistent(entity);
        return entity;
    }

    public List<Client> findAll() {
        return clientRepository.listAll();
    }

    public Client findById(long id) {
        return clientRepository.findById(id);
    }

    public Client updateClient(long id, Client client) {
        if (findById(id) == null)
            return null;
        return save(updateEntity(findById(id), client));
    }

    public Boolean deleteClient(long id){
        if (findById(id) == null)
            return null;
        return clientRepository.deleteById(id);
    }

    public Client updateEntity(Client clientFind, Client newClient) {
        clientFind.setName(newClient.getName());
        clientFind.setEmail(newClient.getEmail());
        clientFind.setTelephone(newClient.getTelephone());
        return clientFind;
    }


}
