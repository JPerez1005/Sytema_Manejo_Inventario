package com.system.inventary.drivers;

import com.system.inventary.models.Category;
import com.system.inventary.models.Brand;
import com.system.inventary.repositories.RepositoryBrand;
import com.system.inventary.repositories.RepositoryCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author perez
 */

@Controller
public class ControllerBrand {
    @Autowired
    private RepositoryBrand RB;
    @Autowired
    private RepositoryCategory RC;

    @GetMapping("/brands")
    public String listBrands(Model m) {
        List<Brand> brands = RB.findAll();
        List<Category> categories = RC.findAll();
        m.addAttribute("categories", categories);
        m.addAttribute("brands", brands);
        m.addAttribute("newBrand", new Brand());
        m.addAttribute("editBrand", new Brand());
        return "views/Brands";
    }

    @PostMapping("/brands")
    public String saveBrand(@ModelAttribute("newBrand") Brand newBrand) {
        RB.save(newBrand);
        return "redirect:/brands";
    }

    @GetMapping("/brands/modify/{id}")
    public String showEditBrandForm(@PathVariable("id") Integer id, Model model) {
        Brand brand = RB.findById(id).orElse(null);
        if (brand != null) {
            List<Category> categories = RC.findAll();
            List<Brand> brands = RB.findAll();
            model.addAttribute("categories", categories);
            model.addAttribute("brands", brands);
            model.addAttribute("newBrand", new Brand()); // Agregar newBrand al modelo
            model.addAttribute("editBrand", brand); // Cambiar el nombre del atributo
            return "views/Brands";
        } else {
            // Manejar la situación en la que no se encuentra la marca
            return "redirect:/brands";
        }
    }

    @PostMapping("/brands/update")
    public String updateBrand(@ModelAttribute("editBrand") Brand editedBrand) {
        RB.save(editedBrand);
        return "redirect:/brands";
    }

    @GetMapping("/brands/delete/{id}")
    public String deleteBrand(@PathVariable("id")Integer id,Model model){
        RB.deleteById(id);
        return "redirect:/brands";
    }
}
