package crud.example.spring.service;
import crud.example.spring.entities.User;
import crud.example.spring.repository.UserRepository;
import crud.example.spring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService();
        userService.userRepository = userRepository;
    }

    @Test
    void testFindAllUsers() {
        userService.findAll();
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testSaveUser() {
        User user = new User();
        userService.save(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testFindByEmail() {
        String email = "test@example.com";
        userService.findByEmail(email);
        verify(userRepository, times(1)).findByEmail(email);
    }
}

