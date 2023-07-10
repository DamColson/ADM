package com.projetPersos.ADM.services.itf;

import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.ui.dto.CreateMessageDTO;
import com.projetPersos.ADM.ui.dto.MessageDTO;

import java.util.List;

public interface IMessageService {

    List<MessageDTO> findAll();
    MessageDTO findById(long messageId) throws Adm404Exception;
    MessageDTO create(CreateMessageDTO createMessageDTO) throws Adm404Exception;
    /*
    Probablement pas nécessaire
    MessageDTO update(long messageId, CreateMessageDTO createMessageDTO) throws Adm404Exception;
     */
    void delete(long messageId) throws Adm404Exception;
    List<MessageDTO> findBySendingMemberAndReceivingMember(String senderPseudo, long memberId) throws Adm404Exception;
    List<MessageDTO> findBySendingMember(Member sendingMember);
    List<MessageDTO> findByReceivingMember(Member receivingMember);
    List<MessageDTO> findByContent(String content,long memberId) throws Adm404Exception;

}
