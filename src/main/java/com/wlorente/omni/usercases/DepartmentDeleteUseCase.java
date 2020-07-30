package com.wlorente.omni.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.wlorente.omni.repositories.DepartmentRepository;
import com.wlorente.omni.services.exceptions.DataIntegrityException;

@Service
public class DepartmentDeleteUseCase {
	
	@Autowired
	private DepartmentRepository repo;
	
	@Autowired
	private DepartmentSearchUseCase departmentSearch;
	
	public void delete(Integer id) {
		departmentSearch.find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

}
