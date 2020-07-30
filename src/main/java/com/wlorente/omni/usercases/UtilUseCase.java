package com.wlorente.omni.usercases;

import org.springframework.stereotype.Service;

import com.wlorente.omni.dto.DepartmentDTO;
import com.wlorente.omni.entities.DepartmentEntity;

@Service
public class UtilUseCase {
	
	public DepartmentEntity fromDTO(DepartmentDTO objDto) {
		
		return new DepartmentEntity(objDto.getId(), objDto.getName(), objDto.getRegion(), objDto.getCity(), objDto.getState(), objDto.getIdBoard().getId());
	}

}
