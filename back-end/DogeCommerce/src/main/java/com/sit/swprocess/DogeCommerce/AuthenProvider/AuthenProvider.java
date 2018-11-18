package com.sit.swprocess.DogeCommerce.AuthenProvider;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AuthenProvider")
public class AuthenProvider {
    @Id
    Long id;

    @NotNull
    String name;

    @NotNull
    String token;

    public AuthenProvider() {
    }

    public AuthenProvider(Long id, @NotNull String name, @NotNull String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
