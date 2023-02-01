package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name="Adm_posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private long id;

    @NotBlank
    @Column(name="post_content")
    private String content;

    @NotBlank
    private Date date;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;



}
