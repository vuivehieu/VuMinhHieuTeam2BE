package com.example.vuminhhieuteam2be.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
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
    String roomName;
    @Column(name = "room_price")
    Double roomPrice;
    @Column(name = "room_status")
    Boolean roomStatus;
    @Column(name = "room_description")
    String roomDescription;
    @Column(name = "room_image")
    String roomImage;
    @Column(name = "room_type")
    String roomType;
    @Column(name = "room_size")
    int roomSize;
    @CreationTimestamp
    @Column(name = "room_created_at")
    Date roomCreated_at;
    @UpdateTimestamp
    @Column(name = "room_updated_at")
    Date roomUpdated_at;
}
