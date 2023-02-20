package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.repository.dao.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRankRepository extends JpaRepository<Rank,Long> {
}
