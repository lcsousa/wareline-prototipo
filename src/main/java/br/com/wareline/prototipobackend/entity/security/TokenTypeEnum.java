package br.com.wareline.prototipobackend.entity.security;

import lombok.Getter;

@Getter
public enum TokenTypeEnum {
	ACCESS_TOKEN 
   ,REFRESH_TOKEN;
	
	private String label;
	
	
	public static TokenTypeEnum valueOfLabel(String label) {
	    for (TokenTypeEnum e : values()) {
	        if (e.toString().equalsIgnoreCase(label)) {
	            return e;
	        }
	    }
	    return null;
	}
}
