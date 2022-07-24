package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.UsersDetails;

public interface UserRepository extends JpaRepository<UsersDetails, Long> {

	Optional<UsersDetails> findByEmail(String string);

}
