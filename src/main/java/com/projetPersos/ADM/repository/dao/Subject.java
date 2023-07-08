package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "Adm_subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long id;

    @NotBlank
    private String title;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE)
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
