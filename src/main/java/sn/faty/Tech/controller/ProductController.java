package sn.faty.Tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sn.faty.Tech.entity.Product;

import sn.faty.Tech.service.ProductService;

@RestController

public class ProductController {
		
	@Autowired
	
	ProductService service;
	
	@PostMapping("/ajoutProduit")
	
	public  Product addProduct(@RequestBody Product product)
	{
	return	service.saveProduct(product);
		
	}
	
	@PostMapping("/ajoutProduits")
	
	public List<Product> addManyProducts(@RequestBody List<Product> products)
	{
		
		return service.saveProducts(products);
	}
	
	@GetMapping("/rechercheProduit/{id}")
	
	public Product getProduct(@PathVariable int id)
	{
		
return 		service.getProductById( id);
	}

	@GetMapping("/rechercheToutProduits")
	
    public List<Product> getProducts()
    {
    	
    	return service.getProduct();
    }
	
	
	@GetMapping("/rechercheNom/{name}")
	
	public Product getProductByName(@PathVariable String name)
	{
		
	
       return  service.getProductByName(name);
	}
	
	
	@PutMapping("/modifierProduit")
	
	public Product updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
	
	}
	
	@DeleteMapping("/supprimerProduit/{id}")
	
	public String removProduct(@PathVariable int id)
	{	
		return service.deleteProduct(id);
		
	}
	
}
