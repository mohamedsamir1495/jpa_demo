package com.cegedim.jpa_demo.lessons.l6_native_query.repos;

import com.cegedim.jpa_demo.lessons.l6_native_query.entities.StudentLessonSix;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("SqlResolve")
public interface StudentLessonSixRepository extends CrudRepository<StudentLessonSix, Long> {

	@Query("from StudentLessonSix")
	List<StudentLessonSix> findAllStudents(Pageable pageable);

	@Query("select st.firstName,st.lastName from StudentLessonSix st")
	List<Object[]> findAllStudentsPartialData();

	@Query("from StudentLessonSix where firstName=:firstName")
	List<StudentLessonSix> findAllStudentsByFirstName(@Param("firstName") String firstName);

	@Query("from StudentLessonSix where score>:min and score<:max")
	List<StudentLessonSix> findStudentsForGivenScores(@Param("min") int min, @Param("max") int max);

	@Modifying // Because you are doing an (Insert/Update/Delete) not a read query so without this annotation spring will throw an exception
	@Query("delete from StudentLessonSix where firstName = :firstName")
	void deleteStudentsByFirstName(@Param("firstName") String firstName);

	@Query(value = "select * from student_lesson_6", nativeQuery = true)
	List<StudentLessonSix> findAllStudentNQ();

	@Query(value = "select * from student_lesson_6 where fname=:firstName", nativeQuery = true)
	List<StudentLessonSix> findByFirstNQ(@Param("firstName") String firstName);

}
