package crud.example.spring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Generated;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String prenom;
    private String nom;
    private String email;
    @JsonIgnore
    private String password;
    @ManyToMany
    private List<Role> roles;

    @Generated
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getPrenom() {
        return this.prenom;
    }

    @Generated
    public String getNom() {
        return this.nom;
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public List<Role> getRoles() {
        return this.roles;
    }

    @Generated
    public void setId(final Integer id) {
        this.id = id;
    }

    @Generated
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    @Generated
    public void setNom(final String nom) {
        this.nom = nom;
    }

    @Generated
    public void setEmail(final String email) {
        this.email = email;
    }

    @JsonIgnore
    @Generated
    public void setPassword(final String password) {
        this.password = password;
    }

    @Generated
    public void setRoles(final List<Role> roles) {
        this.roles = roles;
    }

    @Generated
    public User() {
    }

    @Generated
    public User(final Integer id, final String prenom, final String nom, final String email, final String password, final List<Role> roles) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Generated
    public static class UserBuilder {
        @Generated
        private Integer id;
        @Generated
        private String prenom;
        @Generated
        private String nom;
        @Generated
        private String email;
        @Generated
        private String password;
        @Generated
        private List<Role> roles;

        @Generated
        UserBuilder() {
        }

        @Generated
        public UserBuilder id(final Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public UserBuilder prenom(final String prenom) {
            this.prenom = prenom;
            return this;
        }

        @Generated
        public UserBuilder nom(final String nom) {
            this.nom = nom;
            return this;
        }

        @Generated
        public UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        @JsonIgnore
        @Generated
        public UserBuilder password(final String password) {
            this.password = password;
            return this;
        }

        @Generated
        public UserBuilder roles(final List<Role> roles) {
            this.roles = roles;
            return this;
        }

        @Generated
        public User build() {
            return new User(this.id, this.prenom, this.nom, this.email, this.password, this.roles);
        }

        @Generated
        public String toString() {
            Integer var10000 = this.id;
            return "User.UserBuilder(id=" + var10000 + ", prenom=" + this.prenom + ", nom=" + this.nom + ", email=" + this.email + ", password=" + this.password + ", roles=" + String.valueOf(this.roles) + ")";
        }
    }
}