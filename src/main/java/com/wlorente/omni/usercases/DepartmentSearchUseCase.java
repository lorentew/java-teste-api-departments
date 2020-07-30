package com.wlorente.omni.usercases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.repositories.DepartmentRepository;
import com.wlorente.omni.services.exceptions.ObjectNotFoundException;

@Service
public class DepartmentSearchUseCase {
	
	@Autowired
	private DepartmentRepository repo;
	
	public DepartmentEntity find(Integer id) {
		Optional<DepartmentEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DepartmentEntity.class.getName()));
	}

}
