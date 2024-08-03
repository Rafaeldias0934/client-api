package com.example.client_api.service;

import com.example.client_api.dtos.ClientRecordDto;
import com.example.client_api.models.ClientModel;
import com.example.client_api.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        if (!clientsList.isEmpty()) {
            for (ClientModel client : clientsList) {
                UUID id = client.getIdClient();
            }
        } else {
            return null;
        }
        return clientsList;
    }

    public ClientModel getOneClient(UUID id) {
        Optional<ClientModel> getOneClientOpt = repository.findById(id);
        if (getOneClientOpt.isEmpty()) {
            return null;
        }
        return getOneClientOpt.get();
    }

    public ClientModel updateClient(UUID id, ClientRecordDto clientRecordDto) {
        Optional<ClientModel> updateClientOpt = repository.findById(id);
        if (updateClientOpt.isEmpty()) {
            return null;
        }
        ClientModel clientModel = updateClientOpt.get();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return repository.save(clientModel);
    }

    public boolean deleteClient(UUID id) {
        Optional<ClientModel> deleteClientOpt = repository.findById(id);
        if (deleteClientOpt.isPresent()) {
            repository.delete(deleteClientOpt.get());
            return true;
        } else {
            return false;
        }
    }
}

