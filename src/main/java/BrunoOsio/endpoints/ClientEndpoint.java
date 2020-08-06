package BrunoOsio.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BrunoOsio.domains.Client;
import BrunoOsio.exceptions.ApiRequestException;
import BrunoOsio.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientEndpoint {

	@Autowired
	private ClientRepository repo;

	@GetMapping
	private ResponseEntity<?> listAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping
	private ResponseEntity<?> save(@RequestBody Client client) {
		return ResponseEntity.ok(repo.save(client));

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		if (!clientIdExists(id))
			throw new ApiRequestException("Client id not found");
		return ResponseEntity.of(repo.findById(id));
	}

	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {

		if (!clientNameExists(name)) {
			throw new ApiRequestException("Client name not found");
		}

		Optional<List<Client>> listOfClients = repo.findByNameIgnoreCaseContaining(name);
		return ResponseEntity.of(listOfClients);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Client client) {
		if (!clientIdExists(client.getId())) {
			throw new ApiRequestException("Client id not found for update");
		}
		repo.save(client);
		return ResponseEntity.ok().build();

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		if (!clientIdExists(id)) {
			throw new ApiRequestException("Client id not found for delete ");
		}
		repo.deleteById(id);
		return ResponseEntity.ok().build();
	}

	/*
	 * Helping methods
	 */

	public boolean clientIdExists(Long id) {
		Optional<Client> c = repo.findById(id);
		if (c.isEmpty()) {
			return false;
		}
		return true;

	}

	public boolean clientNameExists(String name) {
		Optional<List<Client>> c = repo.findByNameIgnoreCaseContaining(name);
		if (c.isEmpty()) {
			return false;
		}
		return true;
	}
}
