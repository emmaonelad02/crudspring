package crud.example.spring.entities;


import jakarta.persistence.*;
import lombok.Generated;

import java.util.Date;

@Entity
@Table(
        name = "user_token"
)
public class UserToken {
    @Id
    private String token;
    @ManyToOne
    @JoinColumn(
            nullable = false
    )
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            nullable = false
    )
    private Date notBefore;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            nullable = false
    )
    private Date notAfter;

    public UserToken() {
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public User getUser() {
        return this.user;
    }

    @Generated
    public Date getNotBefore() {
        return this.notBefore;
    }

    @Generated
    public Date getNotAfter() {
        return this.notAfter;
    }

    @Generated
    public void setToken(final String token) {
        this.token = token;
    }

    @Generated
    public void setUser(final User user) {
        this.user = user;
    }

    @Generated
    public void setNotBefore(final Date notBefore) {
        this.notBefore = notBefore;
    }

    @Generated
    public void setNotAfter(final Date notAfter) {
        this.notAfter = notAfter;
    }
}

