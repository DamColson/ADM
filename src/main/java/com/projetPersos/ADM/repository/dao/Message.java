package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name="adm_messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="message_id")
    private long id;

    @NotBlank
    private Date date;

    @NotBlank
    @Column(name="message_content")
    private String content;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
}
