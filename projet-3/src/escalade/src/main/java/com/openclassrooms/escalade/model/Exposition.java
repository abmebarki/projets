package com.openclassrooms.escalade.model;

public enum Exposition {

    N,
    NE,
	E,
	SE,
	S,
	SO,
	O,
	NO;
    
	public String value() {
        return name();
    }

    public static Exposition fromValue(String v) {
        return valueOf(v);
    }

}
