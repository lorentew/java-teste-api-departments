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
import com.wlorente.omni.services.DepartmentService;


@RestController
@Validated
@RequestMapping(value="/api/departments")
public class DepartmentResource {
	
	@Autowired
	private DepartmentService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DepartmentEntity> find(@PathVariable Integer id) {
		DepartmentEntity obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<DepartmentDTO>> findAll() {
		List<DepartmentEntity> list = service.findAll();
		List<DepartmentDTO> listDto = list.stream().map(obj -> new DepartmentDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	//http://localhost:8080/api/departments/state-search?state=SC
	@RequestMapping(value="/state-search", method=RequestMethod.GET)
	public ResponseEntity<List<DepartmentDTO>> findByState(@RequestParam(value="state", defaultValue="") String state) {
		List<DepartmentEntity> list = service.findByState(state);
		List<DepartmentDTO> listDto = list.stream().map(obj -> new DepartmentDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody DepartmentDTO objDto) {
		DepartmentEntity obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody DepartmentDTO objDto, @PathVariable Integer id) {
		DepartmentEntity obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
