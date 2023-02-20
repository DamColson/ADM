package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.repository.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepository extends JpaRepository<Member,Long> {
}
