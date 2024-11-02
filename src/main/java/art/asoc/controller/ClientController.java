package art.asoc.controller;


import art.asoc.model.Client;
import art.asoc.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/clients")
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
  
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllClients(){
        try{
            List<Client> clients = this.clientService.allClients();
            Map<String, Object> response = new HashMap<>();
            response.put("response", "OK");
            response.put("message", clients);
            return ResponseEntity.status(200).body(response);
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", e.getMessage());
            return ResponseEntity.status(400).body(errorResponse);
        }
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<Map<String, Object>> findByLastName(@PathVariable String lastName){
        try{
            List<Client> clientsByLastName = this.clientService.getByLastName(lastName);
            Map<String, Object> response = new HashMap<>();
            response.put("response", "OK");
            response.put("message", clientsByLastName);
            return ResponseEntity.status(200).body(response);
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", e.getMessage());
            return ResponseEntity.status(400).body(errorResponse);
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Map<String, Object>> findByDni(@PathVariable String dni){
        try{
            List<Client> clientsByDni = this.clientService.getByDni(dni);
            Map<String, Object> response = new HashMap<>();
            response.put("response", "OK");
            response.put("message", clientsByDni);
            return ResponseEntity.status(200).body(response);
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", e.getMessage());
            return ResponseEntity.status(400).body(errorResponse);
        }

    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> createClient(@RequestBody Client client){
        try{
            this.clientService.createClient(client);
            Map<String, Object> response = new HashMap<>();
            response.put("response", "OK");
            response.put("message", client);
            return ResponseEntity.status(201).body(response);
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", e.getMessage());
            return ResponseEntity.status(400).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteClient(@PathVariable String id) {
        try {
            Client findClient = this.clientService.getById(id);

            if(findClient != null){
                this.clientService.deleteClient(findClient.getId());
                Map<String, Object> response = new HashMap<>();
                response.put("response", "OK");
                response.put("message", findClient);
                return ResponseEntity.status(200).body(response);
            }else{
                Map<String, Object> notFoundResponse = new HashMap<>();
                notFoundResponse.put("error", "Cliente no encontrado");
                return ResponseEntity.status(404).body(notFoundResponse);
            }
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", e.getMessage());
            return ResponseEntity.status(400).body(errorResponse);
        }
    }
}
