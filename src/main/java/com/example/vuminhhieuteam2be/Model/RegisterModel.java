package com.example.vuminhhieuteam2be.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterModel {
    public String username;
    public String password;
    public String email;
}
