package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.repository.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findMemberByMail(String mail);
}
