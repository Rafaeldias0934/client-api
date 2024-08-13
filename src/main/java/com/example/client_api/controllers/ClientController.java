package com.example.client_api.controllers;
import com.example.client_api.dtos.ClientRecordDto;
import com.example.client_api.models.ClientModel;
import com.example.client_api.service.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;
    @PostMapping
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto clientRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveClient(clientRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneClient(@PathVariable(value = "id") Long id) {
        ClientModel clientModel = service.getOneClient(id);
        if (clientModel == null) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid ClientRecordDto clientRecordDto) {
        ClientModel updateClientOpt = service.updateClient(id,clientRecordDto);
        if (updateClientOpt == null) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.updateClient(id, clientRecordDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") Long id){
        Boolean isDeleted = service.deleteClient(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Client deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Client not found");
    }

}
