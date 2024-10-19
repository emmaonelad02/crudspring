package crud.example.spring.service;


import crud.example.spring.entities.Role;
import crud.example.spring.repository.RoleRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleService() {
    }

    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    public void create(Role role) {
        Optional<Role> dbRole = this.roleRepository.findById(role.getCode());
        if (dbRole.isPresent()) {
            throw new EntityExistsException("Le role du code est " + role.getCode() + " existe deja.");
        } else {
            dbRole = this.roleRepository.findByNom(role.getNom());
            if (dbRole.isPresent()) {
                throw new EntityExistsException("Le role du nom est " + role.getNom() + " existe deja.");
            } else {
                this.roleRepository.save(role);
            }
        }
    }

    public long count() {
        return this.roleRepository.count();
    }
}
