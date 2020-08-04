package BrunoOsio.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.of(repo.findById(id));
	}
	
	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		Optional<List<Client>> list = repo.findByNameIgnoreCaseContaining(name);	
		
		return ResponseEntity.of(list);
	}

}
