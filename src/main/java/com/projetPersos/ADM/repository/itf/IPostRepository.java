package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Member;
import com.projetPersos.ADM.repository.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post,Long> {
    List<Post> findByMember(Member member) throws Adm404Exception;
    List<Post> findByContent(String content);
}
