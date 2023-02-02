package com.projetPersos.ADM.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableDTO {

    private long id;

    private Date date;

    private String name;

    private MemberDTO memberDTO;


}
