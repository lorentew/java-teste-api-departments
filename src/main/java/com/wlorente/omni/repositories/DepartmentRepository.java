package com.wlorente.omni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wlorente.omni.entities.DepartmentEntity;


@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
	
	List<DepartmentEntity>	findByState(@Param("state") String state);

}
