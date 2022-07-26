package com.example.vuminhhieuteam2be.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tbl_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "time_in")
    private Date checkIn;
    @Column(name = "time_out")
    private Date checkOut;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne(targetEntity = RoomEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
}
