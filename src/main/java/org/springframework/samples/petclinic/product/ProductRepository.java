package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product,Integer> {
    
	
	List<Product> findAll();
    
    @Query("SELECT prtypes FROM ProductType prtypes")
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    
    @Query("SELECT prtype FROM ProductType prtype WHERE prtype.name =:name")
    ProductType typefindByName(String name);
    
    @Query("SELECT products FROM Product products WHERE products.price< :coste")
    List<Product>findByPriceLessThan(Double coste);
    
    //void save(Product p) throws DataAccessException;
}
