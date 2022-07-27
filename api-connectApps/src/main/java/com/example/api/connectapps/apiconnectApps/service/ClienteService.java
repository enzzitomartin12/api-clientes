/**
 * 
 */
package com.example.api.connectapps.apiconnectApps.service;

import java.util.List;

import com.example.api.connectapps.apiconnectApps.dto.ClienteDTO;

/**
 * @author enzzitomartin12
 *
 */
public interface ClienteService {

	void loadDataByPost(List<ClienteDTO> clientList);
}
