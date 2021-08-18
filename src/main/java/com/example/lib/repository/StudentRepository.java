package com.example.lib.repository;

import com.example.lib.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    Student findByNameAndLastname(String name, String lastname);

    @Query(value="select * from Student s where s.name like %:keyword% or s.lastname like %:keyword%", nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);
}
