package pl.pkrakowiak.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pkrakowiak.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
 User findOneByEmail(String email);

}