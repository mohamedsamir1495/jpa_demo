package com.cegedim.jpa_demo.lessons.l5_jpql.repos;

import com.cegedim.jpa_demo.lessons.l5_jpql.entities.StudentLessonFive;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentLessonFiveRepository extends CrudRepository<StudentLessonFive, Long> {

	@Query("from StudentLessonFive")
	List<StudentLessonFive> findAllStudents(Pageable pageable);

	@Query("select st.firstName,st.lastName from StudentLessonFive st")
	List<Object[]> findAllStudentsPartialData();

	@Query("from StudentLessonFive where firstName=:firstName")
	List<StudentLessonFive> findAllStudentsByFirstName(@Param("firstName") String firstName);

	@Query("from StudentLessonFive where score>:min and score<:max")
	List<StudentLessonFive> findStudentsForGivenScores(@Param("min") int min, @Param("max") int max);

	@Modifying // Because you are doing an (Insert/Update/Delete) not a read query so without this annotation spring will throw an exception
	@Query("delete from StudentLessonFive where firstName = :firstName")
	void deleteStudentsByFirstName(@Param("firstName") String firstName);

}
