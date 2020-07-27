package com.wlorente.omni.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.entities.enums.BoardType;
import com.wlorente.omni.repositories.DepartmentRepository;

@Service
public class DBService {
	
	@Autowired
	private DepartmentRepository departmentRepository;


	public void instantiateTestDatabase() throws ParseException {
		
		DepartmentEntity dep1 = new DepartmentEntity(null,"Departamento 1","Centro","São Paulo","SP",BoardType.NEGOCIOS);
		DepartmentEntity dep2 = new DepartmentEntity(null,"Departamento 2","Santo Amaro","São Paulo","SP",BoardType.EIS);
		DepartmentEntity dep3 = new DepartmentEntity(null,"Departamento 3","Florianópolis","Florianópolis","SC",BoardType.RECUPERACAO);
		DepartmentEntity dep4 = new DepartmentEntity(null,"Departamento 4","Pedra Alta","Natal","RN",BoardType.NEGOCIOS);
		departmentRepository.saveAll(Arrays.asList(dep1, dep2, dep3, dep4));
		
		
	}
}
