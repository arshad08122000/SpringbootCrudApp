package com.Sbprojects.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Sbprojects.entity.Product;
import com.Sbprojects.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private ProductRepository prodrepo;
	
	@GetMapping("/")
	public String index(Model model)
	{
		List<Product> products=prodrepo.findAll();
		model.addAttribute("products",products);
		return "index";
	}
	
	@GetMapping("/add")
	public String addme(Model model)
	{
		return "Add";
	}
	
	@GetMapping("/edit/{Id}")
	public String edit(@PathVariable(value="Id") Long Id,Model model )
	{
		Optional<Product> Prod=prodrepo.findById(Id);
		Product Pro=Prod.get();
		model.addAttribute("Pro",Pro);
		return "Edit";
	}
	
	@PostMapping("/save")
	public String saveproduct(@ModelAttribute Product product,RedirectAttributes redir)
	{
		prodrepo.save(product);
		redir.addFlashAttribute("msg","New Product Added");	
		return "redirect:/";
	}
	
	
	@PostMapping("/update")
	public String updateproduct(@ModelAttribute Product produc,RedirectAttributes redir)
	{
		prodrepo.save(produc);
		redir.addFlashAttribute("msg","Product Edited");	
		return "redirect:/";
	}
	
	@GetMapping("/delete/{Id}")
	public String deleteproduct(@PathVariable(value="Id") Long Id,RedirectAttributes redir)
	{
		prodrepo.deleteById(Id);
		redir.addFlashAttribute("msg","Product Deleted");
		return "redirect:/";
	}
	
	
}
