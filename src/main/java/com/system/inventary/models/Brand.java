package com.system.inventary.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author perez
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 45, nullable=false, unique=false)
    private String name;
    
    @Column(nullable=false, unique=false)
    private String img;
    
    @Column(nullable=true, unique=false)
    private String Description;
    
    @ManyToOne
    @JoinColumn(name="id_category")
    private Category c;
}
