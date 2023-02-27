package com.projetPersos.ADM.services;

import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.repository.dao.Rank;
import com.projetPersos.ADM.repository.itf.IMemberRepository;
import com.projetPersos.ADM.repository.itf.IRankRepository;
import com.projetPersos.ADM.services.itf.IMemberService;
import com.projetPersos.ADM.transformator.MemberTransformator;
import com.projetPersos.ADM.ui.dto.MemberDTO;
import com.projetPersos.ADM.ui.dto.RegisterDTO;
import com.projetPersos.ADM.ui.dto.UpdateMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {

    private final IMemberRepository memberRepository;
    private final IRankRepository rankRepository;
    private final MemberTransformator memberTransformator;
    private final PasswordEncoder bcryptEncoder;

    @Autowired
    public MemberService(IMemberRepository memberRepository, IRankRepository rankRepository,
                         MemberTransformator memberTransformator, PasswordEncoder bcryptEncoder){
        this.memberRepository = memberRepository;
        this.rankRepository = rankRepository;
        this.memberTransformator = memberTransformator;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public List<MemberDTO> findAll() {
        return memberTransformator.modelsToDtos(memberRepository.findAll());
    }

    @Override
    public MemberDTO findById(long memberId) throws Adm404Exception {
        Optional<Member> memberById = memberRepository.findById(memberId);
        return memberTransformator.modelToDto(memberById.orElseThrow(()->new Adm404Exception("Le Membre n'existe pas")));
    }

    @Override
    public MemberDTO create(RegisterDTO registerDTO) throws Adm404Exception,Adm400Exception {
        Optional<Member> optionalMember = memberRepository.findMemberByMail(registerDTO.getMail());
        if(optionalMember.isPresent()){
            throw new Adm400Exception("Le membre existe déjà");
        }

        if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            throw new Adm400Exception("Les mots de passe ne correspondent pas");
        }

        Rank memberRank = rankRepository.findByName("VISITING_MEMBER").orElseThrow(()->new Adm404Exception("Rôle inexistant"));

        Member member = new Member();
        member.setPseudo(registerDTO.getPseudo());
        member.setMail(registerDTO.getMail());
        member.setPassword(bcryptEncoder.encode(registerDTO.getPassword()));
        member.setRank(memberRank);

        return memberTransformator.modelToDto(memberRepository.save(member));
    }

    @Override
    public MemberDTO update(long memberId, UpdateMemberDTO updateMemberDTO) throws Adm404Exception {

        Member member = memberRepository.findById(memberId).orElseThrow(()->new Adm404Exception("Ce membre n'existe pas"));
        member.setPseudo(updateMemberDTO.getPseudo());
        member.setMail(updateMemberDTO.getMail());
        member.setPassword(bcryptEncoder.encode(updateMemberDTO.getPassword()));
        member.setRank(updateMemberDTO.getRank());

        return memberTransformator.modelToDto(memberRepository.save(member));
    }

    @Override
    public void delete(long memberId) throws Adm404Exception {

    }
}
