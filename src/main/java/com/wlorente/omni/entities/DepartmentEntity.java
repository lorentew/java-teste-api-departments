package com.wlorente.omni.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wlorente.omni.entities.enums.BoardType;

@Entity (name="Departments")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String  name;
	private String  region;
	private String  city;
	private String  state;
	private Integer idBoard; // codigo da diretoria
	
	public DepartmentEntity() {
		
	}

	public DepartmentEntity(Integer id, String name, String region, String city, String state, Integer tipoDiretoria) {
		super();
		this.id = id;
		this.name = name;
		this.region = region;
		this.city = city;
		this.state = state;
		//this.idBoard = (tipoDiretoria==null) ? null : tipoDiretoria.getId();
		this.idBoard = tipoDiretoria;
	}

    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(columnDefinition="character varying (100) not null",length=100,nullable=false)
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

	public BoardType getIdBoard() {
		return BoardType.toEnum(idBoard);
	}

	public void setIdBoard(BoardType idBoard) {
		this.idBoard = idBoard.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentEntity other = (DepartmentEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
