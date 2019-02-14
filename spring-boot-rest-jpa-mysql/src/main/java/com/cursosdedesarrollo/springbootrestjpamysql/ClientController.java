package com.cursosdedesarrollo.springbootrestjpamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    // Get All Clients
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Create a new Client
    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    // Get a Single Client
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable(value = "id") Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));
    }

    // Update a Client
    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable(value = "id") Long clientId,
                           @Valid @RequestBody Client clientDetails) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));

        client.setName(clientDetails.getName());
        client.setEmail(clientDetails.getEmail());
        client.setPassword(clientDetails.getPassword());

        Client updatedClient = clientRepository.save(client);
        return updatedClient;
    }

    // Delete a Client
    @DeleteMapping("/clients/{id}")
    public Client deleteClient(@PathVariable(value = "id") Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));
        client.setActive("N");
        client.setDeletedAt(new Date());

        Client deletedClient = clientRepository.saveAndFlush(client);
        return deletedClient;
    }
}
