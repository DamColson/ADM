package repository.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name="AdmRank")
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

}
