package com.projetPersos.ADM.transformator;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.ui.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberTransformator {

    @Autowired
    RankTransformator rankTransformator;

    public MemberDTO modelToDto(final Member member){
        if(member==null){
            return null;
        }
        return new MemberDTO(member.getId(), member.getPseudo(), rankTransformator.modelToDto(member.getRank()));
    }
    public List<MemberDTO> modelsToDtos(final List<Member> members){
        return members.stream().map(this::modelToDto).collect(Collectors.toList());
    }
    public Member dtoToModel(final MemberDTO memberDTO){
        if(memberDTO==null){
            return null;
        }
        return new Member(memberDTO.getId(), memberDTO.getPseudo(), null, null, rankTransformator.dtoToModel(memberDTO.getRankDTO()), null,null,null,null);
    }

    public List<Member> dtosToModels(final List<MemberDTO> memberDTOS){
        return memberDTOS.stream().map(this::dtoToModel).collect(Collectors.toList());
    }
}
