package com.projetPersos.ADM.transformator;

import com.projetPersos.ADM.repository.dao.Post;
import com.projetPersos.ADM.ui.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostTransformator {

    @Autowired
    MemberTransformator memberTransformator;

    public PostDTO modelToDto(Post post){
        if(post==null){
            return null;
        }
        return new PostDTO(post.getId(), post.getContent(),post.getDate(), memberTransformator.modelToDto(post.getMember()));
    }

    public List<PostDTO> modelsToDtos(List<Post> posts){
        return posts.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    public Post dtoToModel(PostDTO postDTO){
        if(postDTO==null){
            return null;
        }
        return new Post(postDTO.getId(), postDTO.getContent(), postDTO.getDate(),memberTransformator.dtoToModel(postDTO.getMemberDTO()));
    }

    public List<Post> dtosToModels(List<PostDTO> postDTOS){
        return postDTOS.stream().map(this::dtoToModel).collect(Collectors.toList());
    }
}
