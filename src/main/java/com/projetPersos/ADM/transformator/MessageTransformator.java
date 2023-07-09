package com.projetPersos.ADM.transformator;

import com.projetPersos.ADM.repository.dao.Message;
import com.projetPersos.ADM.ui.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageTransformator {

    @Autowired
    MemberTransformator memberTransformator;

    public MessageDTO modelToDto(Message message){
        if(message==null){
            return null;
        }
        return new MessageDTO(message.getId(), message.getContent(), message.getDate(), memberTransformator.modelToDto(message.getSendingMember()), memberTransformator.modelToDto(message.getReceivingMember()));
    }
    public List<MessageDTO> modelsToDtos(List<Message> messages){
        return messages.stream().map(this::modelToDto).collect(Collectors.toList()) ;
    }
    public Message dtoToModel(MessageDTO messageDTO){
        if(messageDTO==null){
            return null;
        }
        return new Message(messageDTO.getId(), messageDTO.getContent(),messageDTO.getDate(),memberTransformator.dtoToModel(messageDTO.getSendingMemberDTO()),memberTransformator.dtoToModel(messageDTO.getReceivingMemberDTO()));
    }
    public List<Message> dtosToModels(List<MessageDTO> messageDTOList){
        return messageDTOList.stream().map(this::dtoToModel).collect(Collectors.toList());
    }
}
