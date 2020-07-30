package com.wlorente.omni.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.repositories.DepartmentRepository;

@Service
public class DepartmentInsertUseCase {
	
	@Autowired
	private DepartmentRepository repo;
	
	@Transactional
	public DepartmentEntity insert(DepartmentEntity obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

}
