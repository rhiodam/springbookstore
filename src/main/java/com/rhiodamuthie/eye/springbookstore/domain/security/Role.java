package com.rhiodamuthie.eye.springbookstore.domain.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 123123L;

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<UserRole> userRole = new HashSet<>();
}
