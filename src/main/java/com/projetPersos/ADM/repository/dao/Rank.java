package com.projetPersos.ADM.repository.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name="Adm_rank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rank_id")
    private long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "rank",cascade = {CascadeType.REMOVE})
    private List<Member> members;

}
