package com.wlorente.omni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.wlorente.omni.services.exceptions.DataIntegrityException;
import com.wlorente.omni.dto.DepartmentDTO;
import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.entities.enums.BoardType;
import com.wlorente.omni.repositories.DepartmentRepository;

import com.wlorente.omni.services.exceptions.ObjectNotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repo;
	
	public DepartmentEntity find(Integer id) {
		Optional<DepartmentEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DepartmentEntity.class.getName()));
	}
	
	@Transactional
	public DepartmentEntity insert(DepartmentEntity obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	@Transactional
	public DepartmentEntity update(DepartmentEntity obj) {
		DepartmentEntity newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<DepartmentEntity> findAll() {
		return repo.findAll();
	}
	
	public List<DepartmentEntity> findByState(String state) {
		return repo.findByState(state);
	}
	
	private void updateData(DepartmentEntity newObj, DepartmentEntity obj) {
		newObj.setCity(obj.getCity());
		newObj.setId(obj.getId());
		newObj.setIdBoard(obj.getIdBoard());
		newObj.setName(obj.getName());
		newObj.setRegion(obj.getRegion());
		newObj.setState(obj.getState());
	}

	public DepartmentEntity fromDTO(DepartmentDTO objDto) {
		
		return new DepartmentEntity(objDto.getId(), objDto.getName(), objDto.getRegion(), objDto.getCity(), objDto.getState(), BoardType.toEnum(objDto.getIdBoard()));
	}
}
