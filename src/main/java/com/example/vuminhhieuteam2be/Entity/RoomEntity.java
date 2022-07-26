package com.example.vuminhhieuteam2be.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tbl_room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "room_name")
    String room_name;
    @Column(name = "room_price")
    Double room_price;
    @Column(name = "room_status")
    Boolean room_status;
    @Column(name = "room_description")
    String room_description;
    @Column(name = "room_image")
    String room_image;
    @Column(name = "room_type")
    String room_type;
    @Column(name = "room_size")
    int room_size;
    @Column(name = "room_created_at")
    String room_created_at;
    @Column(name = "room_updated_at")
    String room_updated_at;
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    UserEntity userEntity;
}
