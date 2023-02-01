package repository.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name="AdmMembers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private long id;

    @NotBlank
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




}
