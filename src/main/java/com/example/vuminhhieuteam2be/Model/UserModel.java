package com.example.vuminhhieuteam2be.Model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String username;
    private String password;
    private String email;
}
