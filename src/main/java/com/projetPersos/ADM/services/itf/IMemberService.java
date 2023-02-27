package com.projetPersos.ADM.services.itf;

import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.ui.dto.MemberDTO;
import com.projetPersos.ADM.ui.dto.RegisterDTO;
import com.projetPersos.ADM.ui.dto.UpdateMemberDTO;

import java.util.List;

public interface IMemberService {
    List<MemberDTO> findAll();
    MemberDTO findById(long memberId) throws Adm404Exception;
    MemberDTO create(RegisterDTO registerDTO) throws Adm404Exception, Adm400Exception;
    MemberDTO update(long memberId, UpdateMemberDTO updateMemberDTO) throws Adm404Exception;
    void delete(long memberId) throws Adm404Exception;
}
