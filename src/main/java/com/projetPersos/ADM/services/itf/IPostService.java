package com.projetPersos.ADM.services.itf;

import com.projetPersos.ADM.exceptions.Adm400Exception;
import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.ui.dto.CreatePostDTO;
import com.projetPersos.ADM.ui.dto.PostDTO;

import java.util.List;

public interface IPostService {
    List<PostDTO> findAll();
    PostDTO findById(long postId) throws Adm404Exception;
    PostDTO create(CreatePostDTO createPostDTO) throws Adm404Exception, Adm400Exception;
    PostDTO update(long postId, CreatePostDTO createPostDTO) throws Adm404Exception;
    void delete(long postId) throws Adm404Exception;
    List<PostDTO> findByMember(Member member) throws Adm404Exception;
    List<PostDTO> findByContent(String content);

    /*
    *
    * Les posts sont envisagés et donc préparés mais aucune certitude de leur existence future dans le site
    * Bdd devra probablement être modifiée pour un eventuel forum, Catégorie/Sujet/posts, Catégories et Sujets actuellement inexistant
    *
    * */
}
