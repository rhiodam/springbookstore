package com.rhiodamuthie.eye.springbookstore.domain.security;

import com.rhiodamuthie.eye.springbookstore.domain.User;
import javax.persistence.*;
import java.io.Serializable;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 123123L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_id")
    private Role role;

}
