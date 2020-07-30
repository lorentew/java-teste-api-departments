package com.wlorente.omni.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.repositories.DepartmentRepository;

@Service
public class DepartmentUpdateUseCase {
	
	@Autowired
	private DepartmentRepository repo;
	
	@Autowired
	private DepartmentSearchUseCase departmentSearch;
	
	@Transactional
	public DepartmentEntity update(DepartmentEntity obj) {
		DepartmentEntity newObj = departmentSearch.find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(DepartmentEntity newObj, DepartmentEntity obj) {
		newObj.setCity(obj.getCity());
		newObj.setId(obj.getId());
		newObj.setIdBoard(obj.getIdBoard());
		newObj.setName(obj.getName());
		newObj.setRegion(obj.getRegion());
		newObj.setState(obj.getState());
	}

}
