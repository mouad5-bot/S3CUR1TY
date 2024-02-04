package com.example.security.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppRole implements GrantedAuthority {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

   @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppPermission> permissions;

    @Override
    public String getAuthority() {
        return name;
    }
}
