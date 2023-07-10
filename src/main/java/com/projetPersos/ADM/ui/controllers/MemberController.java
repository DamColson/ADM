package com.projetPersos.ADM.ui.controllers;

import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.services.itf.IMemberService;
import com.projetPersos.ADM.ui.dto.MemberDTO;
import com.projetPersos.ADM.ui.dto.RegisterDTO;
import com.projetPersos.ADM.ui.dto.UpdateMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/members/")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @CrossOrigin
    @GetMapping()
    public List<MemberDTO> getAll(){
        return memberService.findAll();
    }

    @CrossOrigin
    @GetMapping("{memberId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDTO getById(@PathVariable long memberId) throws Adm404Exception{
        return memberService.findById(memberId);
    }

    @CrossOrigin
    @PostMapping("register")
    public MemberDTO create(@RequestBody RegisterDTO registerDTO) throws Adm404Exception,Adm400Exception{
        return memberService.create(registerDTO);
    }

    @CrossOrigin
    @PutMapping("{memberId}")
    public MemberDTO update(@PathVariable long memberId,@RequestBody UpdateMemberDTO updateMemberDTO) throws Adm404Exception{
        return memberService.update(memberId,updateMemberDTO);
    }

    @CrossOrigin
    @DeleteMapping("{memberId}")
    public void delete(@PathVariable long memberId) throws Adm404Exception{
        memberService.delete(memberId);
    }
}
