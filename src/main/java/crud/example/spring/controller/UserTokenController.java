package crud.example.spring.controller;

import crud.example.spring.entities.UserToken;
import crud.example.spring.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tokens")
public class UserTokenController {

    @Autowired
    private UserTokenService userTokenService;

    @PostMapping
    public UserToken createToken(@RequestBody UserToken userToken) {
        return userTokenService.saveUserToken(userToken);
    }

    @GetMapping("/{id}")
    public Optional<UserToken> getToken(@PathVariable String id) {
        return userTokenService.getUserTokenById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteToken(@PathVariable String id) {
        userTokenService.deleteUserToken(id);
    }
}

