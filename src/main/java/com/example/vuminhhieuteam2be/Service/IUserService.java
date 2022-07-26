package com.example.vuminhhieuteam2be.Service;

import com.example.vuminhhieuteam2be.Entity.UserEntity;
import com.example.vuminhhieuteam2be.Model.UserModel;

public interface IUserService extends IBaseService<UserEntity, UserModel, Long> {
    boolean checkUser(String email);

    UserEntity findByUsername(String username);

    boolean loginUser(String email, String password);
}

