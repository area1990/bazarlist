package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Article;
import com.concretepage.entity.Product;

public interface IProductService {
	List<Product> getAllProducts();

	Product getProductById(int articleId);

	boolean addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int productId);
}
