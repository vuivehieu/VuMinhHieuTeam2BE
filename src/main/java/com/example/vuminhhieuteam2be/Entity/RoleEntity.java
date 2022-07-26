package com.example.vuminhhieuteam2be.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tbl_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String role_name;
    @ManyToMany(targetEntity = UserEntity.class,mappedBy = "roleSet", fetch = FetchType.EAGER)
    private Set<UserEntity> userEntitySet;
}
