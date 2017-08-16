package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Article;
import com.concretepage.entity.Product;
@Transactional
@Repository
public class ProductDAO implements IProductDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Product getProductById(int productId) {
		return entityManager.find(Product.class,  productId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		String hql = "FROM Product as prod ORDER BY prod.productId";
		return (List<Product>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
	}
	@Override
	public void updateProduct(Product product) {
		Product prod= getProductById(product.getProductId());
		prod.setTitle(product.getTitle());
		prod.setDescription(product.getDescription());
		entityManager.flush();
	}
	@Override
	public void deleteProduct(int productId) {
		entityManager.remove(getProductById(productId));
	}
	@Override
	public boolean productExists(String title, String description) {
		String hql = "FROM Product as prod WHERE prod.title = ? and prod.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, description).getResultList().size();
		return count > 0 ? true : false;
	}
	 
}
