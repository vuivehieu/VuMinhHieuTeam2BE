package com.example.vuminhhieuteam2be.Service.Implement;

import com.example.vuminhhieuteam2be.Entity.RoomEntity;
import com.example.vuminhhieuteam2be.Model.RoomModel;
import com.example.vuminhhieuteam2be.Repository.IRoomRepository;
import com.example.vuminhhieuteam2be.Service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements IRoomService {
    @Autowired
    IRoomRepository roomRepository;
    @Override
    public List<RoomEntity> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public RoomEntity getByID(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public RoomEntity insertNew(RoomModel roomModel) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomName(roomModel.getName());
        roomEntity.setRoomType(roomModel.getType());
        roomEntity.setRoomStatus(roomModel.isStatus());
        roomEntity.setRoomPrice(roomModel.getPrice());
        roomEntity.setRoomDescription(roomModel.getDescription());
        roomEntity.setRoomImage(roomModel.getImage());
        return roomRepository.save(roomEntity);
    }

    @Override
    public RoomEntity updateOld(RoomModel roomModel) {
        RoomEntity roomEntity = roomRepository.findById(roomModel.getId()).orElseThrow(() -> new RuntimeException("Room not found"));
        roomEntity.setRoomName(roomModel.getName());
        roomEntity.setRoomType(roomModel.getType());
        roomEntity.setRoomStatus(roomModel.isStatus());
        roomEntity.setRoomPrice(roomModel.getPrice());
        roomEntity.setRoomDescription(roomModel.getDescription());
        roomEntity.setRoomImage(roomModel.getImage());
        return roomRepository.save(roomEntity);
    }

    @Override
    public boolean deleteOld(Long id) {
        if(roomRepository.findById(id).isPresent()) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

