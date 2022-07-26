package com.example.vuminhhieuteam2be.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomModel {
    private Long id;
    private String name;
    private String description;
    private String image;
    private boolean status;
    private String type;
    private double price;
}
