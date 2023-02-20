package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.repository.dao.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends JpaRepository<Message,Long> {
}
