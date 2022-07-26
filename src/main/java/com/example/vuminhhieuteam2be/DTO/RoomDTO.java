package com.example.vuminhhieuteam2be.DTO;

import com.example.vuminhhieuteam2be.Entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Long id;
    private String name;
    private String description;
    private String image;
    private boolean status;
    private String type;
    private int size;
    private double price;
    private Date createdDate;
    private Date updatedDate;

    public static RoomDTO toDTO(RoomEntity roomEntity) {
        return RoomDTO.builder()
                .id(roomEntity.getId())
                .name(roomEntity.getRoomName())
                .description(roomEntity.getRoomDescription())
                .image(roomEntity.getRoomImage())
                .status(roomEntity.getRoomStatus())
                .size(roomEntity.getRoomSize())
                .type(roomEntity.getRoomType())
                .price(roomEntity.getRoomPrice())
                .createdDate(roomEntity.getRoomCreated_at())
                .updatedDate(roomEntity.getRoomUpdated_at())
                .build();
    }
}
