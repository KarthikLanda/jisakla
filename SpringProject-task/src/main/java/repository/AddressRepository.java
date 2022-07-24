package repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import entity.Addresse;

public interface AddressRepository extends JpaRepository<Addresse, Long> {

	Optional<Addresse> findByCity(String string);
}
