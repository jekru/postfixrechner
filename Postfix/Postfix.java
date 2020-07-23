/* See LICENSE file for copyright and license details. */
package Postfix;
import Postfix.Mathcore;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.util.EmptyStackException;



/**
 * Programmierpraktikum (Sommersemester 2020)
 * 
 * M.Sc. Laslo Hunhold
 * Dept. Math./Inf., Abt. Informatik
 * Universität zu Köln
 * Meilenstein 1 (18.05.2020)
 * 
 * +++ Postfix-Klasse +++
 * 
 * Diese Klasse enthält nur die Methode eval(String txt).
 * Diese Methode hat die Aufgabe, die Eingabe aus der GUI zu verarbeiten und das berechnete Ergebnis als String zurückzugeben.
 * 
 * +++ +++ +++ +++ +++ +++
 * 
 * @author Jerome Kruse
 * 
 */
public class Postfix {

	/**
	 * Berechnet aus einem String mittels der Postfix-Notation das zugehörige Ergebnis.
	 * @param txt Eingabe-String
	 * @return String Ausgabe-Ergebnis
	 * @throws IllegalArgumentException Bei falscher Eingabe (z.B. Verletzung der Postfix-Notation).
	 */
	public static String eval(String txt) {
		
		
		String result; 												//Das Ergebnis der Berechnung, die ausgegeben wird.
		StringTokenizer tokenizer= new StringTokenizer(txt); 		//Ein neuer Tokenizer wird dem String, der eval() übermittelt wurde, initialisiert.
		OStack oStack= new OStack();								//Eine Instanz der Klasse OStack wird erstellt.
		
		//While-Schleife wird so lange durchlaufen bis keine Tokens mehr vorhanden sind.
		while (tokenizer.hasMoreTokens()) {
			
			String token= tokenizer.nextToken();
			
			switch (token) {
			
			case "+":
				try {
					BigDecimal a= oStack.pop();
					BigDecimal b= oStack.pop();
					oStack.push(Mathcore.add(a, b));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Addition benötigt zwei Zahlen.");
				}
				break;
			case "-":
				try {
					BigDecimal b= oStack.pop();
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.sub(a, b));
				
				} catch (Exception e) {
					throw new IllegalArgumentException("Die Substraktion benötigt zwei Zahlen.");
				}
				break;
			case "*":
				try {
					BigDecimal a= oStack.pop();
					BigDecimal b= oStack.pop();
					oStack.push(Mathcore.mul(a, b));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Multiplikation benötigt zwei Zahlen.");
				}
				break;
			case "/":
				try {
					BigDecimal b= oStack.pop();
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.div(a, b));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Division benötigt zwei Zahlen.");
				}
				break;
			case "!":
				try {
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.fak(a));
				} catch(EmptyStackException e) {
					throw new IllegalArgumentException("Die Fakultät benötigt mindestens eine Zahl.");
				}
				break;
			case "exp":
				try {
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.exp(a));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Exponentialfunktion benötigt mindestens eine Zahl.");
				}
				break;
			case "ln":
				try {
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.ln(a));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Logarithmusfunktion benötigt eine Zahl.");
				}
				break;
			case "lg":
				try {
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.lg(a));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Logarithmusfunktion benötigt eine Zahl.");
				}
				break;
			case "log":
				try {
					BigDecimal a= oStack.pop();
					BigDecimal b= oStack.pop();
					oStack.push(Mathcore.log(a, b));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("log(a,b) benötigt eine Basis und eine Stelle.");
				}
				break;
			case "^":
				try {
					BigDecimal b= oStack.pop();
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.pot(a, b));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Potenz benötigt eine Basis und einen Exponent");
				}
				break;
			case "sqrt":
				try {
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.sqrt(a));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Quadratwurzel benötigt eine Zahl.");
				}
				break;
			case "root":
				try {
					BigDecimal b= oStack.pop();
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.root(a, b));
				} catch (Exception e) {
					throw new IllegalArgumentException("root(a,b) benötigt zwei Zahlen.");
				}
				break;
			case "sin":
				try {
					BigDecimal x= oStack.pop();
					oStack.push(Mathcore.sin(x));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Sinusfunktion benötigt eine Zahl");
				}
				break;
			case "cos":
				try {
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.cos(a));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Kosinusfunktion benötigt eine Zahl");
				}
				break;
			case "tan":
				try {
					BigDecimal a= oStack.pop();
					oStack.push(Mathcore.tan(a));
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Die Tangensfunktion benötigt eine Zahl");
				}
				break;
			case "e":
				oStack.push(Mathcore.e);
				break;
			case "-e":
				oStack.push(Mathcore.createNewBigDecimalNumber("-" + Mathcore.E));
				break;
			case "pi":
				oStack.push(Mathcore.pi);
				break;
			case "-pi":
				oStack.push(Mathcore.createNewBigDecimalNumber("-" + Mathcore.PI));
				break;
			default:
				try {
					oStack.push(Mathcore.createNewBigDecimalNumber(token));
				//Bei Eintritt der Exception ist die Erstellung einer BigDecimal-Instanz fehlgeschlagen, Eingabe war also keine korrekt formatierte Zahl.
				} catch (Exception e) {
					throw new IllegalArgumentException("Keine symbolisch gültige Zahlen-Eingabe.");
				}
				break;
			}
			
		}
		
		
		/**
		 * Die while-Schleife wurde durchlaufen und alle notwendigen Berechnungen wurden durchgeführt.
		 * Bei korrekter Eingabe muss der OperandenStack nun die Länge 1 haben (= Ergebnis).
		 * 
		 * Ist dies nicht der Fall, so wurde die Postfix-Notation verletzt oder keine sinnigen Eingaben getätigt.
		 */
		
		
		if (oStack.size() == 1) {
			result= Mathcore.createFinalBigDecimalNumber(oStack.pop().toString()).toString();
		}
		else {
			throw new IllegalArgumentException("Überprüfe deine Eingabe (Postfix-Notation beachten!).");
		}
		
		
		return result;
		
	}
	
	
}
