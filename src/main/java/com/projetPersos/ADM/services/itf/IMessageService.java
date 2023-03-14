package com.projetPersos.ADM.services.itf;

import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.ui.dto.MessageDTO;
import com.projetPersos.ADM.ui.dto.UpdateMessageDTO;

import java.util.Date;
import java.util.List;

public interface IMessageService {

    List<MessageDTO> findAll();
    MessageDTO findById(long messageId) throws Adm404Exception;
    MessageDTO create(String content, Date date, long memberId) throws Adm404Exception, Adm400Exception;
    MessageDTO update(long messageId, UpdateMessageDTO updateMessageDTO) throws Adm404Exception;
    void delete(long messageId) throws Adm404Exception;

    /* A voir pour ajouter :
    *
    * findAllByMember => recherche tout les message d'un utilisateur
    * findByContent => recherche les messages contenant le contenu recherché.
    *
    * */

}
