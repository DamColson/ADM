package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.repository.dao.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITableRepository extends JpaRepository<Table,Long> {
}
