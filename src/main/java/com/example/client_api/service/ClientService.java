package com.example.client_api.service;

import com.example.client_api.dtos.ClientRecordDto;
import com.example.client_api.models.ClientModel;
import com.example.client_api.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    public ClientModel saveClient(ClientRecordDto clientRecordDto) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return repository.save(clientModel);
    }

    public List<ClientModel> getAllClients() {
        List<ClientModel> clientsList = repository.findAll();
        if (clientsList.isEmpty()) {
            for (ClientModel client : clientsList) {
                UUID id = client.getIdClient();
            }
        } else {
            return null;
        }
        return clientsList;
    }
    
}

