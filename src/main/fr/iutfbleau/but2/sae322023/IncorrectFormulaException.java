package fr.iutfbleau.but2.sae322023;

/**
 * The <code>IncorrectFormulaException</code> class represents an error while parsing a formula.
 * 
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class IncorrectFormulaException extends Exception {
    /**
     * Constructor of the class.
     * 
     * @param s the error message.
     */
    public IncorrectFormulaException(String s) {
        super(s);
    }
}
