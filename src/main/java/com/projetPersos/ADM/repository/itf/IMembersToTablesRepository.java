package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.repository.dao.MembersToTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembersToTablesRepository extends JpaRepository<MembersToTables,Long> {
}
