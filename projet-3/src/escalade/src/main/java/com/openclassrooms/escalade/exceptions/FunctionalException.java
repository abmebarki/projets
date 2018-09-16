package com.openclassrooms.escalade.exceptions;

/**
 * Classe d'exception lev�e quand une erreur fonctionnelle survient
 *
 * @author amebarki
 */
public class FunctionalException extends Exception {

    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public FunctionalException(String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public FunctionalException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}
