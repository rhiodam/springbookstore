package com.rhiodamuthie.eye.springbookstore.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rhiodamuthie.eye.springbookstore.domain.security.Authority;
import com.rhiodamuthie.eye.springbookstore.domain.security.Role;
import com.rhiodamuthie.eye.springbookstore.domain.security.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails , Serializable {

    private static final long serialVersionUID = 123123L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id" , nullable = false , updatable = false)
    private Long id;

    private String username;
    private String password;
    private String firtsname;
    private String lastname;

    private String email;
    private String phone;
    private boolean enabled = true;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

//    private ShoppingCart shoppingCart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(userRole -> authorities.add(new Authority(userRole.getRole().getName())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
