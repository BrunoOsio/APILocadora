package BrunoOsio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import BrunoOsio.domains.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

//	@Query("select manufac from car where lower(car.manufac) = lower(:manufac)")
//	public Optional<List<Car>> find(@Param("manufac") String manufac);
	
	
	
	public Optional<List<Car>> findByManufacIgnoreCaseContaining(String manufac);
	public Optional<List<Car>> findByModelIgnoreCaseContaining(String model);
	public Optional<List<Car>> findByYear(String year);
	public Optional<List<Car>> findByPrice(Double price);


}
