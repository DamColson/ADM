package com.projetPersos.ADM.ui.dto;

import com.projetPersos.ADM.repository.dao.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMessageDTO {
    private long id;
    private String content;
    private Date date;
    private Member member;
}
