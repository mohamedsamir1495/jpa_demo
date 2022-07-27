package com.cegedim.jpa_demo.lessons.l1_simple_crud_operations;

import com.cegedim.jpa_demo.lessons.l1_simple_crud_operations.entites.ProductLessonOne;
import com.cegedim.jpa_demo.lessons.l1_simple_crud_operations.repos.ProductLessonOneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class L1SimpleCRUDOperationsTests {

	@Autowired
	ProductLessonOneRepository repository;
	

	@Test
	public void testCreate() {
		ProductLessonOne product = new ProductLessonOne();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(1000d);

		repository.save(product);
	}

	@Test
	public void testRead() {
		ProductLessonOne product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
	}

	@Test
	public void testUpdate() {
		ProductLessonOne product = repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);
	}

	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting a product");
			repository.deleteById(1);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total Records===============>>>>>>>>>>>>>>>" + repository.count());

	}

}
