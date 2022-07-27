/**
 * 
 */
package com.example.api.connectapps.apiconnectApps.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.connectapps.apiconnectApps.dto.ClienteDTO;
import com.example.api.connectapps.apiconnectApps.entity.Cliente;
import com.example.api.connectapps.apiconnectApps.repository.ClienteRepository;

/**
 * @author enzzitomartin12
 *
 */
@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente clienteMapper(ClienteDTO clienteDTO) {
		Cliente client = new Cliente();
		if(clienteDTO!=null) {
			client.setUserId(clienteDTO.getUserId());
			client.setTitle(clienteDTO.getTitle());
			client.setBody(clienteDTO.getBody());
		}
		return client;
	}
	
	public ClienteDTO clienteDTOMapper(Cliente cliente) {
		ClienteDTO clientDTO = new ClienteDTO();
		if(cliente!=null) {
			clientDTO.setUserId(cliente.getUserId());
			clientDTO.setTitle(cliente.getTitle());
			clientDTO.setBody(cliente.getBody());
		}
		return clientDTO;
	}

	@Override
	public void loadDataByPost(List<ClienteDTO> clientList) {
		if(!clientList.isEmpty() && clientList.size()>0) {
			clienteRepository.saveAll(clientList.stream()
					.map(item -> clienteMapper(item)).collect(Collectors.toList()));
		}
	}


}
