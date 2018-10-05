package com.openclassrooms.escalade.model;

public enum Difficulte {

    FACILE,
    INTERMEDIAIRE,
    DIFFICILE;
    
	public String value() {
        return name();
    }

    public static Difficulte fromValue(String v) {
        return valueOf(v);
    }

}
