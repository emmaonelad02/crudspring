package crud.example.spring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Generated;

import java.util.List;

@Entity
@Table(
        name = "roles"
)
public class Role {
    @Id
    @Column(
            length = 10
    )
    private String code;
    @Column(
            length = 100,
            unique = true,
            nullable = false
    )
    private String nom;
    private String description;
    @ManyToMany(
            mappedBy = "roles"
    )
    @JsonIgnore
    private List<User> users;

    @Generated
    public static RoleBuilder builder() {
        return new RoleBuilder();
    }

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public String getNom() {
        return this.nom;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public List<User> getUsers() {
        return this.users;
    }

    @Generated
    public void setCode(final String code) {
        this.code = code;
    }

    @Generated
    public void setNom(final String nom) {
        this.nom = nom;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @JsonIgnore
    @Generated
    public void setUsers(final List<User> users) {
        this.users = users;
    }

    @Generated
    public Role() {
    }

    @Generated
    public Role(final String code, final String nom, final String description, final List<User> users) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.users = users;
    }

    @Generated
    public static class RoleBuilder {
        @Generated
        private String code;
        @Generated
        private String nom;
        @Generated
        private String description;
        @Generated
        private List<User> users;

        @Generated
        RoleBuilder() {
        }

        @Generated
        public RoleBuilder code(final String code) {
            this.code = code;
            return this;
        }

        @Generated
        public RoleBuilder nom(final String nom) {
            this.nom = nom;
            return this;
        }

        @Generated
        public RoleBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @JsonIgnore
        @Generated
        public RoleBuilder users(final List<User> users) {
            this.users = users;
            return this;
        }

        @Generated
        public Role build() {
            return new Role(this.code, this.nom, this.description, this.users);
        }

        @Generated
        public String toString() {
            String var10000 = this.code;
            return "Role.RoleBuilder(code=" + var10000 + ", nom=" + this.nom + ", description=" + this.description + ", users=" + String.valueOf(this.users) + ")";
        }
    }
}
