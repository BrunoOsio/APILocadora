package BrunoOsio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import BrunoOsio.domains.Client;

public interface ClientRepository extends JpaRepository<Client, Long>  {

}
