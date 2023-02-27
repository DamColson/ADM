package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRankRepository extends JpaRepository<Rank,Long> {
    Optional<Rank> findByName(String rankName) throws Adm404Exception;
}
