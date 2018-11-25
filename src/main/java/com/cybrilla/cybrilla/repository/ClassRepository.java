package com.cybrilla.cybrilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybrilla.cybrilla.model.ClassModel;

@Repository
public interface ClassRepository extends JpaRepository<ClassModel, Long>{

}
