/**
 * 
 */
package com.example.api.connectapps.apiconnectApps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.connectapps.apiconnectApps.entity.Cliente;

/**
 * @author enzzitomartin12
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
