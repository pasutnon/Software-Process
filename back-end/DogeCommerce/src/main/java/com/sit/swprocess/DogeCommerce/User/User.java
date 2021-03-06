package com.sit.swprocess.DogeCommerce.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sit.swprocess.DogeCommerce.Address.Address;
import com.sit.swprocess.DogeCommerce.AuthenProvider.AuthenProvider;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        targetEntity = Address.class
    )
    List<Address> addresses;

    @NotNull
    String username;

    @Nullable
    @JsonIgnore
    String password;

    @NotNull
    String email;

    @NotNull
    String firstname;

    @NotNull
    String lastname;

    @Nullable
    String phone;

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    List<AuthenProvider> authenProviders;

    public User() {
    }

    public User(List<Address> addresses, @NotNull String username, @Nullable String password, @NotNull String email, @NotNull String firstname, @NotNull String lastname, @Nullable String phone, List<AuthenProvider> authenProviders) {
        this.addresses = addresses;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.authenProviders = authenProviders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }

    public void setPhone(@Nullable String phone) {
        this.phone = phone;
    }

    public List<AuthenProvider> getAuthenProviders() {
        return authenProviders;
    }

    public void setAuthenProviders(List<AuthenProvider> authenProviders) {
        this.authenProviders = authenProviders;
    }
}
