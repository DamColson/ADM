package com.projetPersos.ADM.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String pseudo;

    private String mail;

    private String password;

    private String confirmPassword;
}
