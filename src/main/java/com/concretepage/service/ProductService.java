package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IProductDAO;
import com.concretepage.entity.Product;
@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductDAO productDAO;
	@Override
	public Product getProductById(int productId) {
		Product obj = productDAO.getProductById(productId);
		return obj;
	}	
	@Override
	public List<Product> getAllProducts(){
		return productDAO.getAllProducts();
	}
	@Override
	public synchronized boolean addProduct(Product product){
       if (productDAO.productExists(product.getTitle(), product.getDescription())) {
    	   return false;
       } else {
    	   productDAO.addProduct(product);
    	   return true;
       }
	}
	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}
}
