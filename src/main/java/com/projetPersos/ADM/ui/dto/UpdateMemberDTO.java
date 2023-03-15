package com.projetPersos.ADM.ui.dto;

import com.projetPersos.ADM.repository.dao.Rank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberDTO {


    private String pseudo;
    private String mail;
    private String password;
    private Rank rank;

}
