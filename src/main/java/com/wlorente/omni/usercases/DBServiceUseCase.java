package com.wlorente.omni.usercases;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.repositories.DepartmentRepository;

@Service
public class DBServiceUseCase {

	@Autowired
	private DepartmentRepository departmentRepository;


	public void instantiateTestDatabase() throws ParseException {
		
		DepartmentEntity dep1 = new DepartmentEntity(null,"Departamento 1","Centro","São Paulo","SP",1);
		DepartmentEntity dep2 = new DepartmentEntity(null,"Departamento 2","Santo Amaro","São Paulo","SP",1);
		DepartmentEntity dep3 = new DepartmentEntity(null,"Departamento 3","Florianópolis","Florianópolis","SC",2);
		DepartmentEntity dep4 = new DepartmentEntity(null,"Departamento 4","Pedra Alta","Natal","RN",3);
		departmentRepository.saveAll(Arrays.asList(dep1, dep2, dep3, dep4));
		
		
	}
}
