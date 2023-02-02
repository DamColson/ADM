package com.projetPersos.ADM.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name="members_to_tables")
@Data
@AllArgsConstructor
@NoArgsConstructor
@AssociationOverrides({
        @AssociationOverride(name = "pk.member",
                joinColumns = @JoinColumn(name = "member_id")),
        @AssociationOverride(name = "pk.table",
                joinColumns = @JoinColumn(name = "table_id"))
})
public class MembersToTables implements Serializable {

    @Autowired
    @EmbeddedId
    private MembersToTablesId pk;
}
