package com.system.inventary.repositories;

import com.system.inventary.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author perez
 */
public interface RepositoryCategory extends JpaRepository<Category,Integer>{

}
