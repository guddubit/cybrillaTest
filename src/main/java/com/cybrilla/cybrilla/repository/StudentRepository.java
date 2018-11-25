package com.cybrilla.cybrilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybrilla.cybrilla.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
