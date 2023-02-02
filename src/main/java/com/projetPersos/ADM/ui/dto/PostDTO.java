package com.projetPersos.ADM.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private long id;

    private String content;

    private Date date;

    private MemberDTO memberDTO;
}
