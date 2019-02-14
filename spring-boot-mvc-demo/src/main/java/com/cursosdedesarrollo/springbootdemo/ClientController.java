package com.cursosdedesarrollo.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @GetMapping(value = "/clients/")
    public List<Client> listClients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Client> clientsList = new ArrayList<Client>();

        clientsList.add(generateClient("1"));
        clientsList.add(generateClient("2"));
        clientsList.add(generateClient("3"));
        clientsList.add(generateClient("4"));
        clientsList.add(generateClient("5"));
        clientsList.add(generateClient("6"));

        return clientsList;
    }

    private Client generateClient(String param) {
        Client client1 = new Client();
        client1.setId(param);
        client1.setName("name"+param);
        client1.setEmail("email"+param+"@email.com");
        client1.setPassword(param+"1234");
        client1.setToken("token"+param);
        client1.setActivo(true);
        return client1;
    }

    @GetMapping(value = "/clients/{id}")
    public Client showClient(@PathVariable String id)
            throws ServletException, IOException {
        Client client1 = generateClient(id);

        return client1;
    }

    @PostMapping(value = "/clients/")
    public Client addClient(@RequestBody Client client)
            throws ServletException, IOException {
        client.setId("666");
        return client;
    }

    @PutMapping(value = "/clients/{id}")
    public Client editClient(@PathVariable String id, @RequestBody Client client)
            throws ServletException, IOException  {
        client.setId(id);
        return client;
    }

    @DeleteMapping(value = "/clients/{id}")
    public Client deleteClient(@PathVariable String id)
            throws ServletException, IOException {
        Client client1 = generateClient(id);

        return client1;
    }
}
