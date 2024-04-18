package com.system.inventary;

import com.system.inventary.models.Category;
import com.system.inventary.repositories.RepositoryCategory;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

/**
 * @author perez
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RepositoryCategoryTest {
    
    @Autowired
    private RepositoryCategory RC;
    
    @Test
    public void testCreateCategory(){
        Category newCategory=RC.save(new Category(1,"Tecnologia","https://cdn.pixabay.com/photo/2020/02/03/00/12/fiber-4814456_1280.jpg","hola"));
        assertThat(newCategory.getId()).isGreaterThan(0);
    }
    
}
