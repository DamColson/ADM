package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "Adm_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    @NotBlank
    private String title;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<Subject> subjects;
}
