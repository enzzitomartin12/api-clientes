/**
 * 
 */
package com.example.api.connectapps.apiconnectApps.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.connectapps.apiconnectApps.dto.ClienteDTO;
import com.example.api.connectapps.apiconnectApps.dto.ResponseApiDTO;
import com.example.api.connectapps.apiconnectApps.entity.Cliente;
import com.example.api.connectapps.apiconnectApps.repository.ClienteRepository;
import com.example.api.connectapps.apiconnectApps.service.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author enzzitomartin12
 *
 */
@RestController
@RequestMapping(path="/api/cliente")
public class ClienteController {
	
	static final String respDelete = Cliente.class.getSimpleName()+" with id: ";
	
	static final String uriPost = "https://jsonplaceholder.typicode.com/posts";
	
	static String ParamsOK = "PARAMETROS OBTENIDOS CORRECTAMENTE";
	
	private HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/loadFromAPI")
	public ResponseApiDTO loadFromAPI() {
		List<ClienteDTO> postList = new ArrayList<>();
		ResponseApiDTO resp = null;
		HttpRequest requestPost = HttpRequest.newBuilder().GET().uri(
				URI.create(uriPost)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			postList = convertToJSON(response.body(), new TypeReference<List<ClienteDTO>>() {} );
			clienteService.loadDataByPost(postList);
			resp = new ResponseApiDTO(ParamsOK,HttpStatus.OK.value());
		} catch (IOException | InterruptedException e) {
			resp = new ResponseApiDTO(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		} 
		return resp;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
		return  ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Cliente>> get() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Cliente> >get(@PathVariable Long id) {
		return ResponseEntity.ok(clienteRepository.findById(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseApiDTO delete(@PathVariable Long id) {
		if(clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return new ResponseApiDTO(respDelete+id.toString()+" deleted",HttpStatus.OK.value());
		}else {
			return new ResponseApiDTO(respDelete+id.toString()+" not exists",HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
	
	private <T> T convertToJSON(String json, TypeReference<T> ref) {
		try {
			return this.mapper.readValue(json, ref);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
