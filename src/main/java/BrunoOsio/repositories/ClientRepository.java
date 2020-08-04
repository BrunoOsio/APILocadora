package BrunoOsio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import BrunoOsio.domains.Client;

public interface ClientRepository extends JpaRepository<Client, Long>  {
	
	public Optional<List<Client>> findByNameIgnoreCaseContaining(String name);

}
