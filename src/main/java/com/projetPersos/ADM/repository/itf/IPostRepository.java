package com.projetPersos.ADM.repository.itf;

import com.projetPersos.ADM.repository.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post,Long> {
}
