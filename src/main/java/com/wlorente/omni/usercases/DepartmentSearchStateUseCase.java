package com.wlorente.omni.usercases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.repositories.DepartmentRepository;

@Service
public class DepartmentSearchStateUseCase {
	
	@Autowired
	private DepartmentRepository repo;
	
	public List<DepartmentEntity> findByState(String state) {
		return repo.findByState(state);
	}

}
