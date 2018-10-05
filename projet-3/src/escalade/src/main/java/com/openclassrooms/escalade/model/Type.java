package com.openclassrooms.escalade.model;

public enum Type {

    BLOC,
    FALAISE;
    
	public String value() {
        return name();
    }

    public static Type fromValue(String v) {
        return valueOf(v);
    }

}
