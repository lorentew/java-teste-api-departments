package com.wlorente.omni.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wlorente.omni.dto.DepartmentDTO;
import com.wlorente.omni.entities.DepartmentEntity;
import com.wlorente.omni.usercases.DepartmentConsultUseCase;
import com.wlorente.omni.usercases.DepartmentDeleteUseCase;
import com.wlorente.omni.usercases.DepartmentInsertUseCase;
import com.wlorente.omni.usercases.DepartmentSearchStateUseCase;
import com.wlorente.omni.usercases.DepartmentSearchUseCase;
import com.wlorente.omni.usercases.DepartmentUpdateUseCase;
import com.wlorente.omni.usercases.UtilUseCase;


@RestController
@Validated
@RequestMapping(value="/api/departments")
public class DepartmentResource {
	
	@Autowired
	private DepartmentSearchUseCase departmentSearchUseCase;
	@Autowired
	private DepartmentConsultUseCase departmentConsultUseCase;
	@Autowired
	private DepartmentSearchStateUseCase departmentSearchStateUseCase;
	@Autowired
	private DepartmentInsertUseCase departmentInsertUseCase;
	@Autowired
	private UtilUseCase utilUseCase;
	@Autowired
	DepartmentDeleteUseCase departmentDeleteUseCase;
	@Autowired
	DepartmentUpdateUseCase departmentUpdateUseCase;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DepartmentEntity> find(@PathVariable Integer id) {
		DepartmentEntity obj = departmentSearchUseCase.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<DepartmentDTO>> findAll() {
		List<DepartmentEntity> list = departmentConsultUseCase.findAll();
		List<DepartmentDTO> listDto = list.stream().map(obj -> new DepartmentDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	//http://localhost:8080/api/departments/state-search?state=SC
	@RequestMapping(value="/state-search", method=RequestMethod.GET)
	public ResponseEntity<List<DepartmentDTO>> findByState(@RequestParam(value="state", defaultValue="") String state) {
		List<DepartmentEntity> list = departmentSearchStateUseCase.findByState(state);
		List<DepartmentDTO> listDto = list.stream().map(obj -> new DepartmentDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody DepartmentDTO objDto) {
		DepartmentEntity obj = utilUseCase.fromDTO(objDto);
		obj = departmentInsertUseCase.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody DepartmentDTO objDto, @PathVariable Integer id) {
		DepartmentEntity obj = utilUseCase.fromDTO(objDto);
		obj.setId(id);
		obj = departmentUpdateUseCase.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		departmentDeleteUseCase.delete(id);
		return ResponseEntity.noContent().build();
	}

}
