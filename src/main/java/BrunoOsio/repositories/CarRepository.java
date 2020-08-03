package BrunoOsio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import BrunoOsio.domains.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
