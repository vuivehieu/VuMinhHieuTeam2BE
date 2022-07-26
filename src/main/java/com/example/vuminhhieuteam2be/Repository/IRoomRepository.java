package com.example.vuminhhieuteam2be.Repository;

import com.example.vuminhhieuteam2be.Entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends JpaRepository<RoomEntity,Long> {
}
