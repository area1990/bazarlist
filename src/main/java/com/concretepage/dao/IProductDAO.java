package com.concretepage.dao;

import java.util.List;
import com.concretepage.entity.Article;
import com.concretepage.entity.Product;

public interface IProductDAO {
	List<Product> getAllProducts();

	Product getProductById(int articleId);

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int productId);

	boolean productExists(String title, String description);
}
