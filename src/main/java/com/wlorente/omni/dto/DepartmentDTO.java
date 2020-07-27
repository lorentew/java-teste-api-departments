package com.wlorente.omni.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wlorente.omni.entities.DepartmentEntity;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull
	private String    name;
	
	@NotNull(message="Preenchimento obrigatório")
	private String    region;
	
	@NotNull(message="Preenchimento obrigatório")
	private String    city;
	
	@NotNull(message="Preenchimento obrigatório")
	private String    state;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer   idBoard; // codigo da diretoria
	
	public DepartmentDTO() {
		
	}
	
	public DepartmentDTO(DepartmentEntity obj) {
		id = obj.getId();
		name = obj.getName();
		region = obj.getRegion();
		city = obj.getCity();
		state = obj.getState();
		idBoard = (obj==null) ? null : obj.getIdBoard().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(Integer idBoard) {
		this.idBoard = idBoard;
	}
	
	

}
