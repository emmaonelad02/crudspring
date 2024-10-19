package crud.example.spring.repository;

import crud.example.spring.entities.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTokenRepository extends JpaRepository<UserToken, String> {
}
