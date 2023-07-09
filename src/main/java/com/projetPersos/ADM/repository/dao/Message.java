package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Column(name="message_content")
    private String content;

    @NotBlank
    @DateTimeFormat
    private Date date;

    @ManyToOne
    @JoinColumn(name="sendingMember_id")
    private Member sendingMember;

    @ManyToOne
    @JoinColumn(name="receivingMember_id")
    private Member receivingMember;
}
