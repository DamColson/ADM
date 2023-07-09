package com.projetPersos.ADM.repository.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name="Adm_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private long id;

    @NotBlank
    @Column(unique = true)
    private String pseudo;

    @NotBlank
    @Email(message = "E-mail non valide")
    @Column(unique = true)
    private String mail;

    @NotBlank
    @Size(min = 8,message = "Votre mot de passe doit contenir au moins 8 caractère")
    private String password;

    @ManyToOne
    @JoinColumn(name = "rank_id")
    private Rank rank;

    @OneToMany(mappedBy = "member",cascade = {CascadeType.REMOVE})
    private List<Post> posts;

    @OneToMany(mappedBy = "sendingMember",cascade = {CascadeType.REMOVE})
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "receivingMember",cascade = {CascadeType.REMOVE})
    private List<Message> receivedMessages;

    @OneToMany(mappedBy = "member",cascade = {CascadeType.REMOVE})
    private List<Table> tables;

    @OneToMany(mappedBy = "pk.member",cascade = {CascadeType.REMOVE})
    private List<MembersToTables> membersToTables;

    @OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE})
    private List<Article> articles;

}
