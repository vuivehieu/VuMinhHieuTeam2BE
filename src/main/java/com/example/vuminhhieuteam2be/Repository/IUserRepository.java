package com.example.vuminhhieuteam2be.Repository;

import com.example.vuminhhieuteam2be.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
