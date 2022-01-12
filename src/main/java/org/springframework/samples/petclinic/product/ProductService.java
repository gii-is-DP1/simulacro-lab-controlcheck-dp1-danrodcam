package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetRepository;
import org.springframework.samples.petclinic.pet.VisitRepository;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
    
	public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.typefindByName(typeName);
    }
    

    public Product save(Product p){
        return productRepository.save(p);   
    }
    
    public List<ProductType> tiposProductos(){
    	return productRepository.findAllProductTypes();
    }

    
}
