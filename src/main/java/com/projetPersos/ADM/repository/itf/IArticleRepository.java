package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.exceptions.Adm404Exception;
import com.projetPersos.ADM.repository.dao.Article;
import com.projetPersos.ADM.repository.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findByMember(Member member) throws Adm404Exception;
    List<Article> findByContent(String Content);
}
