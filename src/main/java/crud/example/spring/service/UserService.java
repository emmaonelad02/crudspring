package crud.example.spring.service;

import crud.example.spring.entities.User;
import crud.example.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
