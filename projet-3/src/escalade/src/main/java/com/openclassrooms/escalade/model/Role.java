package com.openclassrooms.escalade.model;

public enum Role {

    ADMIN,
    USER;
    
	public String value() {
        return name();
    }

    public static Role fromValue(String v) {
        return valueOf(v);
    }

}
