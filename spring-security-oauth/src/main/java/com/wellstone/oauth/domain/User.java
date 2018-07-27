package com.wellstone.oauth.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String imageUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<UserRoleMap> userRoles = new ArrayList<>();

    @Builder
    public User(String name, String email, String imageUrl, List<UserRoleMap> userRoles) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.userRoles = userRoles;
    }

    public void addRole(UserRole userRole){
        if(userRoles == null){
            userRoles = new ArrayList<>();
        }
        userRoles.add(new UserRoleMap(this, userRole));
    }
}
