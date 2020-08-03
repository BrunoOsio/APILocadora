package BrunoOsio.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BrunoOsio.domains.Client;
import BrunoOsio.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientEndpoint {
	
	@Autowired
	private ClientRepository repo;
	
	@GetMapping
	private ResponseEntity<?> listAll(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping
	private ResponseEntity<?> save(@RequestBody Client client) {
		return ResponseEntity.ok(repo.save(client));
		
	}

}
