package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Addresse;

public interface AddressRepository extends JpaRepository<Addresse, Long> {
}
