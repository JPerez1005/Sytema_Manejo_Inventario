package com.system.inventary.drivers;

import com.system.inventary.models.Brand;
// import com.system.inventary.models.Category;
import com.system.inventary.models.Product;
import com.system.inventary.repositories.RepositoryBrand;
import com.system.inventary.repositories.RepositoryProduct;
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
public class ControllerProduct {
    @Autowired
    private RepositoryProduct RP;
    @Autowired
    private RepositoryBrand RB;
    
    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = RP.findAll();
        List<Brand> brands = RB.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("products", products);
        model.addAttribute("newProduct", new Product());
        return "views/Products";
    }
    
    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("newProduct") Product newProduct) {
        RP.save(newProduct);
        return "redirect:/products";
    }

    @GetMapping("/products/modify/{id}")
    public String showEditBrandForm(@PathVariable("id") Integer id, Model model) {
        Product product = RP.findById(id).orElse(null);
        if (product != null) {
            List<Brand> brands = RB.findAll();
            List<Product> products = RP.findAll();
            model.addAttribute("brands", brands);
            model.addAttribute("products", products);
            model.addAttribute("newProduct", new Product()); // Agregar newBrand al modelo
            model.addAttribute("editProduct", product); // Cambiar el nombre del atributo
            return "views/Products";
        } else {
            // Manejar la situación en la que no se encuentra la marca
            return "redirect:/products";
        }
    }

    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute("editProduct") Product editedProduct) {
        RP.save(editedProduct);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id")Integer id,Model model){
        RP.deleteById(id);
        return "redirect:/products";
    }
}
