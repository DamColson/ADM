package com.projetPersos.ADM.ui.dto;

import com.projetPersos.ADM.repository.dao.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateMessageDTO {

    private String content;
    private Date date;
    private long memberId;
}
