package crud.example.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import crud.example.spring.entities.UserToken;
import crud.example.spring.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTokenService {

    @Autowired
    private UserTokenRepository userTokenRepository;

    // Méthode pour créer ou mettre à jour un UserToken
    public UserToken saveUserToken(UserToken userToken) {
        return userTokenRepository.save(userToken);
    }

    // Méthode pour récupérer un UserToken par son ID
    public Optional<UserToken> getUserTokenById(String id) {
        return userTokenRepository.findById(id);
    }

    // Méthode pour supprimer un UserToken par son ID
    public void deleteUserToken(String id) {
        userTokenRepository.deleteById(id);
    }

    // Autres méthodes selon les besoins
}


