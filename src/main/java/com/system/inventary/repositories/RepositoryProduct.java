package com.system.inventary.repositories;

import com.system.inventary.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author perez
 */
public interface RepositoryProduct extends JpaRepository<Product,Integer>{

}
