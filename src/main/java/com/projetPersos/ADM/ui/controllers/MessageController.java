package com.projetPersos.ADM.ui.controllers;


import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.services.itf.IMessageService;
import com.projetPersos.ADM.ui.dto.CreateMessageDTO;
import com.projetPersos.ADM.ui.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages/")
class MessageController {

    @Autowired
    private IMessageService messageService;

    @CrossOrigin
    @GetMapping()
    public List<MessageDTO> getAll(){
        return messageService.findAll();
    }

    @CrossOrigin
    @GetMapping("{messageId}")
    public MessageDTO findById(@PathVariable long messageId) throws Adm404Exception{
        return messageService.findById(messageId);
    }

    @CrossOrigin
    @PostMapping("send")
    public MessageDTO create(@RequestBody CreateMessageDTO createMessageDTO) throws Adm404Exception {
        return messageService.create(createMessageDTO);
    }

    @CrossOrigin
    @DeleteMapping("{messageId}")
    public void delete(@PathVariable long messageId) throws Adm404Exception{
        messageService.delete(messageId);
    }
}
