package com.luv2code.springdemo.dao;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Category;
import com.luv2code.springdemo.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	final int COUNT=6;
	
	@Override
	public List<Product> getLatestProducts() {
		// TODO Auto-generated method stub
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = 
				currentSession.createQuery("FROM Product e WHERE e.status=1 ORDER BY e.id DESC",Product.class);
		
		theQuery.setMaxResults(COUNT);
		
		
		List<Product> products = theQuery.getResultList();
		
		// return the results		
		return  products;
	}
	
	@Override
	public List<Product> getProdactsListByCategory(int category,int page){
		
		/*Session currentSession = sessionFactory.getCurrentSession();
		
		Category tempCourse = currentSession.get(Category.class, category);
		
		List<Product> products = tempCourse.getProducts();
		
		return products;*/
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = 
				currentSession.createQuery("FROM Product e WHERE e.status=1 AND e.category_id=:categoryId ORDER BY e.id DESC",Product.class);
		
		theQuery.setParameter("categoryId", category);
		theQuery.setMaxResults(COUNT);
		theQuery.setFirstResult((page-1)*COUNT);
		
		List<Product> products = theQuery.getResultList();
		
		// return the results		
		return  products;
		
		
	}
	
	@Override
	public Product getProdactById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product tempProduct = currentSession.get(Product.class, id);
		
		return tempProduct;
	}

	@Override
	public int getTotalProdactsInCategory(int category) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Long> theQuery = 
				currentSession.createQuery("select count(e) FROM Product e WHERE e.status=1 AND e.category_id=:categoryId",Long.class);
		
		theQuery.setParameter("categoryId", category);

		
		int result = theQuery.getResultList().get(0).intValue();
		
		// return the results		
		return  result;

	}

	@Override
	public List<Product> getProdactsByIds(Set<Integer> ids) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = 
				currentSession.createQuery("FROM Product e WHERE e.id IN (:ids)",Product.class);
		
		theQuery.setParameter("ids", ids);
		
		List<Product> products = theQuery.getResultList();

		//Query<Long> theQuery1 = 
				//currentSession.createQuery("SELECT SUM(e.id*b.id) FROM Product e,Category b WHERE e.id=b.id AND e.price=123.0",Long.class);
		//System.out.println(theQuery1.getResultList());
		
		// return the results		
		return products;
	}

	@Override
	public List<Product> getProdactList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = 
				currentSession.createQuery("FROM Product e ORDER BY e.id ASC",Product.class);
		
		List<Product> products = theQuery.getResultList();
		return products;
	}

	@Override
	public void deleteProduct(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", id);
		
		theQuery.executeUpdate();		
		
	}

	@Override
	public int saveProduct(Product theProduct) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theProduct);
		return theProduct.getId();
		
	}

}
