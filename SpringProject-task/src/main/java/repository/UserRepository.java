package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.UsersDetails;

public interface UserRepository extends JpaRepository<UsersDetails, Long> {

}
