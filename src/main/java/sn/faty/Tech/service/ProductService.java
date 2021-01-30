package sn.faty.Tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.faty.Tech.entity.Product;

import sn.faty.Tech.repositry.ProductRepository;


@Service

public class ProductService {
	
	@Autowired
	
	private  ProductRepository productrepo;
		
	public Product saveProduct(Product product)
	{
		
		  return productrepo.save(product);
		  
	}
	
	  //Ajout des produits 
	
	public List<Product> saveProducts(List<Product> products)
	{
		return productrepo.saveAll(products);
		
	}
	
	
	public List<Product> getProduct() {
		
		return productrepo.findAll();  
	}
	
	
	public Product getProductById(int id) {
		
		return productrepo.findById(id).orElse(null);
		
	}
	
	public Product getProductByName(String name) {
		
		return  productrepo.getProductByName(name);
		
	}
	

	public String deleteProduct(int id) {
		
         productrepo.deleteById(id);		
		
         return "le produit d'identifiant"+id + "a été supprime avec succés";
		
	}
	
	
	   public  Product updateProduct(Product product) {
		   
		   
		   Product existingProduct=productrepo.findById(product.getId()).orElse(null);
		   
		   
		     existingProduct.setName(product.getName());
		     
		     existingProduct.setPrice(product.getPrice());
		     
		     existingProduct.setQuantity(product.getQuantity());
 
		     return productrepo.save(existingProduct);
		    		     
	   }
	   
}
