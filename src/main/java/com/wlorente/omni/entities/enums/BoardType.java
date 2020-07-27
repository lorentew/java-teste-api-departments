package com.wlorente.omni.entities.enums;


public enum BoardType {
	
	EIS(1,"E.I.S"),
	RECUPERACAO(2,"Recuperação"),
	NEGOCIOS(3,"Negócios");
	
    private int id;
    private String description;
    
    private BoardType (int cod, String desc) {
    	this.id = cod;
    	this.description = desc;
    }

	public int getId() {
		return id;
	}

	public String getDesc() {
		return description;
	}

	public static BoardType toEnum(Integer id) {
		
		if (id == null) {
			return null;
		}
		
		for (BoardType x : BoardType.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + id);
	}
    
    
}
