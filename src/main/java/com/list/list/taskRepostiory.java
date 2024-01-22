package com.list.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface taskRepostiory extends JpaRepository<taskEntity,Long> {
    
}
