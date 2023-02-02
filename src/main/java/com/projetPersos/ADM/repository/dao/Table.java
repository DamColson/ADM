package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity(name="Adm_tables")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    @DateTimeFormat
    private Date date;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "pk.table",cascade = {CascadeType.REMOVE})
    private List<MembersToTables> membersToTables;
}
