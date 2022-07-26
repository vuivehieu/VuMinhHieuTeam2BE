package com.example.vuminhhieuteam2be.Security.DetailModels;

import com.example.vuminhhieuteam2be.Entity.RoleEntity;
import com.example.vuminhhieuteam2be.Entity.UserEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
public class CustomUser implements UserDetails {

    UserEntity userEntity;

    public CustomUser(UserEntity userEntity){
        this.userEntity = userEntity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleEntity> roleEntitySet = userEntity.getRoleSet();
        List<SimpleGrantedAuthority> authorities =new ArrayList<>();
        for (RoleEntity r: roleEntitySet){
            authorities.add(new SimpleGrantedAuthority(r.getRole_name()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
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
        return true;
    }
}
