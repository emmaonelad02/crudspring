package crud.example.spring.service;

import crud.example.spring.entities.UserToken;
import crud.example.spring.repository.UserTokenRepository;
import crud.example.spring.service.UserTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTokenServiceTest {

    private UserTokenRepository userTokenRepository;
    private UserTokenService userTokenService;

    @BeforeEach
    void setUp() {
        userTokenRepository = mock(UserTokenRepository.class);
        userTokenService = new UserTokenService();
        userTokenService.userTokenRepository = userTokenRepository;
    }

    @Test
    void testSaveUserToken() {
        UserToken userToken = new UserToken();
        userTokenService.saveUserToken(userToken);
        verify(userTokenRepository, times(1)).save(userToken);
    }

    @Test
    void testGetUserTokenById() {
        String id = "token123";
        userTokenService.getUserTokenById(id);
        verify(userTokenRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteUserToken() {
        String id = "token123";
        userTokenService.deleteUserToken(id);
        verify(userTokenRepository, times(1)).deleteById(id);
    }
}

