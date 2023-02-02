package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Embeddable
public class MembersToTablesId implements Serializable {

    @ManyToOne
    private Member member;

    @ManyToOne
    private Table table;

}
