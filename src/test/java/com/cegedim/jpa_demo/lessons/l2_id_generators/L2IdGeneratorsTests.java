package com.cegedim.jpa_demo.lessons.l2_id_generators;

import com.cegedim.jpa_demo.lessons.l2_id_generators.entites.EmployeeLessonTwo;
import com.cegedim.jpa_demo.lessons.l2_id_generators.repos.EmployeeLessonTwoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class L2IdGeneratorsTests {

	@Autowired
	EmployeeLessonTwoRepository er;

	@Test
	public void testCreateEmployee() {

		EmployeeLessonTwo employee = new EmployeeLessonTwo();
		employee.setName("John");

		er.save(employee);
	}

}
