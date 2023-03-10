package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.Model.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }
	
	 @Override
	    public Product save(Product product) {
	        return productRepository.save(product);
	    }
	 
	 @Override
	    public void delete(Integer id) {
	    productRepository.deleteById(id);
	    }
	 
	 @Override
	    public List<Product> findByNombre(String term) {

	        return productRepository.findByName(term) ;
	    }
	 
	 @Override
	 @Transactional(readOnly = true)
	    public Optional<Product> findProductoByid(Integer id) {
	        return  productRepository.findById(id);
	    }
}
