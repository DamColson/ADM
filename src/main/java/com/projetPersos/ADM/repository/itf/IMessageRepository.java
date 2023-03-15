package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.repository.dao.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByMember(Member member) throws Adm404Exception;
    List<Message> findByContent(String content);
}
