package com.example.vuminhhieuteam2be.Security.DetailServiceImp;

import com.example.vuminhhieuteam2be.Repository.IUserRepository;
import com.example.vuminhhieuteam2be.Security.DetailModels.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUser(userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("No User Found!!!")));
    }
}
