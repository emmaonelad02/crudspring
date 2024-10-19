package crud.example.spring.service;

import crud.example.spring.entities.Role;
import crud.example.spring.repository.RoleRepository;
import crud.example.spring.service.RoleService;
import jakarta.persistence.EntityExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RoleServiceTest {

    private RoleRepository roleRepository;
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        roleRepository = mock(RoleRepository.class);
        roleService = new RoleService();
        roleService.roleRepository = roleRepository;
    }

    @Test
    void testGetAllRoles() {
        roleService.getAllRoles();
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    void testCreateRoleExistsByCode() {
        Role role = new Role();
        role.setCode("ADMIN");

        when(roleRepository.findById(role.getCode())).thenReturn(Optional.of(role));

        EntityExistsException thrown = assertThrows(EntityExistsException.class, () -> roleService.create(role));
        assertEquals("Le role du code est ADMIN existe deja.", thrown.getMessage());
    }

    @Test
    void testCreateRoleExistsByName() {
        Role role = new Role();
        role.setCode("USER");
        role.setNom("User");

        when(roleRepository.findById(role.getCode())).thenReturn(Optional.empty());
        when(roleRepository.findByNom(role.getNom())).thenReturn(Optional.of(role));

        EntityExistsException thrown = assertThrows(EntityExistsException.class, () -> roleService.create(role));
        assertEquals("Le role du nom est User existe deja.", thrown.getMessage());
    }

    @Test
    void testCreateRoleSuccess() {
        Role role = new Role();
        role.setCode("USER");
        role.setNom("User");

        when(roleRepository.findById(role.getCode())).thenReturn(Optional.empty());
        when(roleRepository.findByNom(role.getNom())).thenReturn(Optional.empty());

        roleService.create(role);

        verify(roleRepository, times(1)).save(role);
    }

    @Test
    void testCountRoles() {
        roleService.count();
        verify(roleRepository, times(1)).count();
    }
}

