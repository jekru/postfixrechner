/* See LICENSE file for copyright and license details. */
package Postfix;
import java.math.BigDecimal;
import java.util.Stack;


/**
 * Programmierpraktikum (Sommersemester 2020)
 * 
 * M.Sc. Laslo Hunhold
 * Dept. Math./Inf., Abt. Informatik
 * Universität zu Köln
 * Meilenstein 1 (18.05.2020)
 * 
 * +++ OStack-Klasse +++
 * 
 * Diese Klasse implementiert einen Stack.
 * Grund für eine eigene Klasse ist, dass hier Zwischenergebnisse überprüft werden und gegebenenfalls auf 0 gerundet werden.
 * 
 * +++ +++ +++ +++ +++ +++
 * 
 * @author Jerome Kruse
 * 
 */
public class OStack {

	
	Stack<BigDecimal> oStack;
	BigDecimal partSolutionZeroChecker= new BigDecimal("10E-195");
	BigDecimal zero= new BigDecimal("0");
	
	
	public OStack() {
		
		this.oStack= new Stack<>();
		
	}
	
	
	
	/**
	 * Pusht eine BigDecimal-Zahl auf den Stack.
	 * Überprüft die übergebene Zahl und rundet gegebenenfalls auf 0.
	 * @param BigDecimal a
	 */
	public void push(BigDecimal a) {
		
		if (a.abs().compareTo(partSolutionZeroChecker) == -1 ) {
			
			oStack.push(zero);
		}
		else {
			
			oStack.push(a);
		}
		
	}
	
	
	/**
	 * Nimmt das oberste Element vom Stack und gibt dieses aus.
	 * @return BigDecimal a
	 */
	public BigDecimal pop() {
		
		return oStack.pop();
		
	}
	
	
	/**
	 * Gibt die Size des Stacks aus.
	 * 
	 * @return Integer size
	 */
	public int size() {
		
		return oStack.size();
		
	}
	
	
}
