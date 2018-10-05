package com.openclassrooms.escalade.model;

public enum Saison {

    HIVER,
    PRINTEMPS,
	ETE,
	AUTOMNE;
    
	public String value() {
        return name();
    }

    public static Saison fromValue(String v) {
        return valueOf(v);
    }

}
