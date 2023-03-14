package com.projetPersos.ADM.services;

import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.repository.dao.Message;
import com.projetPersos.ADM.repository.itf.IMemberRepository;
import com.projetPersos.ADM.repository.itf.IMessageRepository;
import com.projetPersos.ADM.services.itf.IMessageService;
import com.projetPersos.ADM.transformator.MemberTransformator;
import com.projetPersos.ADM.transformator.MessageTransformator;
import com.projetPersos.ADM.ui.dto.MemberDTO;
import com.projetPersos.ADM.ui.dto.MessageDTO;
import com.projetPersos.ADM.ui.dto.UpdateMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements IMessageService {

    private final IMessageRepository messageRepository;
    private final IMemberRepository memberRepository;
    private final MemberTransformator memberTransformator;
    private final MessageTransformator messageTransformator;

    @Autowired
    public MessageService(IMessageRepository messageRepository, IMemberRepository memberRepository, MemberTransformator memberTransformator,
                          MessageTransformator messageTransformator){
        this.memberRepository = memberRepository;
        this.messageRepository = messageRepository;
        this.memberTransformator = memberTransformator;
        this.messageTransformator = messageTransformator;
    }


    @Override
    public List<MessageDTO> findAll() {
        return messageTransformator.modelsToDtos(messageRepository.findAll());
    }

    @Override
    public MessageDTO findById(long messageId) throws Adm404Exception {
        Optional<Message> messageById = messageRepository.findById(messageId);
        return messageTransformator.modelToDto(messageById.orElseThrow(()->new Adm404Exception("Message inexistant")));
    }

    @Override
    public MessageDTO create(String content, Date date, long memberId) throws Adm404Exception, Adm400Exception {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new Adm404Exception("Membre inexistant"));

        Message message = new Message();
        message.setContent(content);
        message.setDate(date);
        message.setMember(member);
        return messageTransformator.modelToDto(messageRepository.save(message));
    }

    @Override
    public MessageDTO update(long messageId, UpdateMessageDTO updateMessageDTO) throws Adm404Exception {
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new Adm404Exception("Message inexistant"));

        message.setContent(updateMessageDTO.getContent());
        message.setDate(updateMessageDTO.getDate());
        message.setMember(updateMessageDTO.getMember());

        return messageTransformator.modelToDto(messageRepository.save(message));
    }

    @Override
    public void delete(long messageId) throws Adm404Exception {
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new Adm404Exception("Message inexistant"));
        messageRepository.delete(message);
    }
}
