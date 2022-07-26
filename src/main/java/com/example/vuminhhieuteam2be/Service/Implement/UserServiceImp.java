package com.example.vuminhhieuteam2be.Service.Implement;

import com.example.vuminhhieuteam2be.Entity.UserEntity;
import com.example.vuminhhieuteam2be.Model.UserModel;
import com.example.vuminhhieuteam2be.Repository.IRoleRepository;
import com.example.vuminhhieuteam2be.Repository.IUserRepository;
import com.example.vuminhhieuteam2be.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public UserEntity getByID(Long id) {
        return null;
    }

    @Override
    public UserEntity insertNew(UserModel userModel) {
        UserEntity user = new UserEntity();

        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setRoleSet(Set.of(roleRepository.findById(2L).get()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateOld(UserModel userModel) {
        return null;
    }

    @Override
    public boolean deleteOld(Long id) {
        return false;
    }

    @Override
    public boolean checkUser(String email) {
        return false;
    }

    @Override
    public UserEntity findByUsername(String username) {
        if(userRepository.findByUsername(username).isPresent()) {
            return userRepository.findByUsername(username).get();
        }else {
            return null;
        }
    }

    @Override
    public boolean loginUser(String email, String password) {
        return false;
    }
}
