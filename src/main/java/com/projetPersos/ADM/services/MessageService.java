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
import com.projetPersos.ADM.ui.dto.CreateMessageDTO;
import com.projetPersos.ADM.ui.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public MessageDTO create(CreateMessageDTO createMessageDTO) throws Adm404Exception {
        Member sendingMember = memberRepository.findById(createMessageDTO.getSendingMemberId()).orElseThrow(()-> new Adm404Exception("Membre inexistant"));
        Member receivingMember = memberRepository.findById(createMessageDTO.getReceivingMemberId()).orElseThrow(()-> new Adm404Exception("Membre inexistant"));

        Message message = new Message();
        message.setContent(createMessageDTO.getContent());
        message.setDate(createMessageDTO.getDate());
        message.setSendingMember(sendingMember);
        message.setReceivingMember(receivingMember);
        return messageTransformator.modelToDto(messageRepository.save(message));
    }

    /*
    Probablement pas nécessaire

    @Override
    public MessageDTO update(long messageId, CreateMessageDTO createMessageDTO) throws Adm404Exception {
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new Adm404Exception("Message inexistant"));
        Member sendingMember = memberRepository.findById(createMessageDTO.getSendingMemberId()).orElseThrow(()->new Adm404Exception("Membre inexistant"));
        Member receivingMember = memberRepository.findById(createMessageDTO.getReceivingMemberId()).orElseThrow(()-> new Adm404Exception("Membre inexistant"));

        message.setContent(createMessageDTO.getContent());
        message.setDate(createMessageDTO.getDate());
        message.setSendingMember(sendingMember);
        message.setReceivingMember(receivingMember);

        return messageTransformator.modelToDto(messageRepository.save(message));
    }
    */
    @Override
    public void delete(long messageId) throws Adm404Exception {
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new Adm404Exception("Message inexistant"));
        messageRepository.delete(message);
    }

    @Override
    public List<MessageDTO> findBySendingMemberAndReceivingMember(String senderPseudo, long receivingMemberId) throws Adm404Exception {
        Member sendingMember = memberRepository.findMemberByPseudo(senderPseudo).orElseThrow(()-> new Adm404Exception("Membre inexistant"));
        Member receivingMember = memberRepository.findById(receivingMemberId).orElseThrow(()-> new Adm404Exception("Membre inexistant"));

        return messageTransformator.modelsToDtos(messageRepository.findBySendingMemberAndReceivingMember(sendingMember,receivingMember));
    }

    @Override
    public List<MessageDTO> findBySendingMember(Member sendingMember){
        return messageTransformator.modelsToDtos(messageRepository.findBySendingMember(sendingMember));
    }

    @Override
    public List<MessageDTO> findByReceivingMember(Member receivingMember){
        return messageTransformator.modelsToDtos(messageRepository.findByReceivingMember(receivingMember));
    }

    @Override
    public List<MessageDTO> findByContent(String content, long memberId) throws Adm404Exception {

        Member member = memberRepository.findById(memberId).orElseThrow(()-> new Adm404Exception("Membre inexistant"));
        List<Message> messageSent = messageRepository.findBySendingMember(member);
        List<Message> messageReceived = messageRepository.findByReceivingMember(member);
        List<Message> messageList =  new ArrayList<>();
        Stream.of(messageSent,messageReceived).forEach(messageList::addAll);

        List<Message> messageToReturn = messageList.stream()
                .filter(message -> message.getContent().contains(content))
                .collect(Collectors.toList());

        /*

        Stream alternatif, probablement moins performant

        messageList.stream()
                .forEach(message -> {
                    if (message.getContent().contains(content)) {
                        messageToReturn.add(message);
                    }
                }
                );
         */

        return messageTransformator.modelsToDtos(messageToReturn);

        /*
        *
        * Stream à tester ! Devrait marcher !
        *
        * */
    }
}
