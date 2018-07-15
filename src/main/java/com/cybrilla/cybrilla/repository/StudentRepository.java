package com.cybrilla.cybrilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybrilla.cybrilla.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
