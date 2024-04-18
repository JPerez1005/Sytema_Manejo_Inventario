package com.system.inventary.drivers;

import com.system.inventary.models.Category;
import com.system.inventary.repositories.RepositoryCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author perez
 */
@Controller
public class ControllerCategory {
    @Autowired
    private RepositoryCategory RC;
    
    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = RC.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("newCategory", new Category());
        return "views/categories";
    }
    
    @PostMapping("/categories")
    public String saveCategory(@ModelAttribute("newCategory") Category newCategory) {
        RC.save(newCategory);
        return "redirect:/categories";
    }
    
    @GetMapping("/home")
    public String back(){
        return "redirect:/";
    }
}
