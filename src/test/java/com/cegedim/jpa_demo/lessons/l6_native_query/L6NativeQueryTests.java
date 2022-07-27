package com.cegedim.jpa_demo.lessons.l6_native_query;

import com.cegedim.jpa_demo.lessons.l6_native_query.entities.StudentLessonSix;
import com.cegedim.jpa_demo.lessons.l6_native_query.repos.StudentLessonSixRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class L6NativeQueryTests {

	@Autowired
	StudentLessonSixRepository repository;

	@Test
	public void testStudentCreate() {
		StudentLessonSix student = new StudentLessonSix();
		student.setFirstName("John");
		student.setLastName("Ferguson");
		student.setScore(88);

		StudentLessonSix student2 = new StudentLessonSix();
		student2.setFirstName("Bill");
		student2.setLastName("Gates");
		student2.setScore(75);

		repository.save(student);
		repository.save(student2);
	}

	@Test
	public void testFindAllStudents() {
		System.out.println(repository.findAllStudents(PageRequest.of(0, 5, Sort.by(Direction.DESC, "id"))));
	}

	@Test
	public void testFindAllStudentsPartial() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(repository.findAllStudentsByFirstName("Bill"));
	}

	@Test
	public void testFindAllStudentsByScores() {
		System.out.println(repository.findStudentsForGivenScores(80, 90));
	}

	@Test
	@Transactional
	// Because you are doing an (Insert/Update/Delete) not a read query so without this annotation spring will throw an exception
	@Rollback(false)
	//since it is a junit test its default behaviour is to rollback the transaction so no data will be deleted from db, so we disable this behaviour
	public void testDeleteStudentsByFirstName() {
		repository.deleteStudentsByFirstName("Bill");
	}

	@Test
	public void testFindAllStudentNQ() {
		System.out.println(repository.findAllStudentNQ());
	}

	@Test
	public void testFindByFirstNameNQ() {
		System.out.println(repository.findByFirstNQ("Bill"));
	}
}









