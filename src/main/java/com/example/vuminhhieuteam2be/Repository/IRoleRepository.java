package com.example.vuminhhieuteam2be.Repository;

import com.example.vuminhhieuteam2be.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}

