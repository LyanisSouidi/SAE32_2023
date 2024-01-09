/**
 * The <code>IncalculableFormulaException</code> class represents an error while evaluating a correct formula.
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class IncalculableFormulaException extends Exception {
    /**
     * Constructor of the class.
     * @param s the error message.
     */
    public IncalculableFormulaException(String s) {
        super(s);
    }
}
