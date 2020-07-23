/* See LICENSE file for copyright and license details. */
package Postfix;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;



/**
 * Programmierpraktikum (Sommersemester 2020)
 * 
 * M.Sc. Laslo Hunhold
 * Dept. Math./Inf., Abt. Informatik
 * Universität zu Köln
 * Meilenstein 1 (18.05.2020)
 * 
 * +++ Mathcore Klasse +++
 * 
 * Die Mathcore-Klasse ist hauptsächlich für die Logik der verschiedenen Funktionen verantwortlich,
 * die zur Berechnung genutzt werden. Außerdem ist die Kreiszahl, sowie die Eulersche Zahl in der Klasse gespeichert.
 * 
 * +++ +++ +++ +++ +++ +++
 * 
 * @author Jerome Kruse
 *
 */
public class Mathcore {
	
	
	public static final int STELLEN_INTERN = 200;
	public static final int STELLEN_OUTPUT = 30;
	public static final MathContext mc = new MathContext(STELLEN_INTERN, RoundingMode.HALF_EVEN);		// 200 Stellen Genauigkeit
	public static final MathContext mc_out = new MathContext(STELLEN_OUTPUT, RoundingMode.HALF_EVEN);	// 30 Stellen Genauigkeit
	public static final BigDecimal epsilon = BigDecimal.ONE.scaleByPowerOfTen(-(STELLEN_INTERN + 1));	// Fehlertoleranz
	public static final String PI =
			"3.141592653589793238462643383279502884197169399375105820974944592307816406286208" +
		    "99862803482534211706798214808651328230664709384460955058223172535940812848111745" +
			"02841027019385211055596446229489549303819644288109756659334461284756482337867831" +
		    "65271201909145648566923460348610454326648213393607260249141273724587006606315588" +
			"17488152092096282925409171536436789259036001133053054882046652138414695194151160" +
		    "94330572703657595919530921861173819326117931051185480744623799627495673518857527" +
			"24891227938183011949129833673362440656643086021394946395224737190702179860943702" +
		    "77053921717629317675238467481846766940513200056812714526356082778577134275778960" +
			"91736371787214684409012249534301465495853710507922796892589235420199561121290219" +
		    "60864034418159813629774771309960518707211349999998372978049951059731732816096318" +
			"59502445945534690830264252230825334468503526193118817101000313783875288658753320" +
		    "83814206171776691473035982534904287554687311595628638823537875937519577818577805" +
			"32171226806613001927876611195909216420198938095257201065485863278865936153381827" +
		    "96823030195203530185296899577362259941389124972177528347913151557485724245415069" +
			"59508295331168617278558890750983817546374649393192550604009277016711390098488240" +
		    "12858361603563707660104710181942955596198946767837449448255379774726847104047534" +
			"64620804668425906949129331367702898915210475216205696602405803815019351125338243" +
		    "00355876402474964732639141992726042699227967823547816360093417216412199245863150" +
			"30286182974555706749838505494588586926995690927210797509302955321165344987202755" +
		    "96023648066549911988183479775356636980742654252786255181841757467289097777279380" +
			"00816470600161452491921732172147723501414419735685481613611573525521334757418494" +
		    "68438523323907394143334547762416862518983569485562099219222184272550254256887671" +
			"79049460165346680498862723279178608578438382796797668145410095388378636095068006" +
		    "42251252051173929848960841284886269456042419652850222106611863067442786220391949" +
			"450471237137869609563643719172874677646575739624138908658326459958133904780275901";
	
	public static final String E =
			"2.718281828459045235360287471352662497757247093699959574966967627724076630353547" +
			"59457138217852516642742746639193200305992181741359662904357290033429526059563073" +
			"81323286279434907632338298807531952510190115738341879307021540891499348841675092" +
			"44761460668082264800168477411853742345442437107539077744992069551702761838606261" +
			"33138458300075204493382656029760673711320070932870912744374704723069697720931014" +
			"16928368190255151086574637721112523897844250569536967707854499699679468644549059" +
			"87931636889230098793127736178215424999229576351482208269895193668033182528869398" +
			"49646510582093923982948879332036250944311730123819706841614039701983767932068328" +
			"23764648042953118023287825098194558153017567173613320698112509961818815930416903" +
			"51598888519345807273866738589422879228499892086805825749279610484198444363463244" +
			"96848756023362482704197862320900216099023530436994184914631409343173814364054625" +
			"31520961836908887070167683964243781405927145635490613031072085103837505101157477" +
			"04171898610687396965521267154688957035035402123407849819334321068170121005627880" +
			"23519303322474501585390473041995777709350366041699732972508868769664035557071622" +
			"68447162560798826517871341951246652010305921236677194325278675398558944896970964" +
			"09754591856956380236370162112047742722836489613422516445078182442352948636372141" +
			"74023889344124796357437026375529444833799801612549227850925778256209262264832627" +
			"79333865664816277251640191059004916449982893150566047258027786318641551956532442" +
			"58698294695930801915298721172556347546396447910145904090586298496791287406870504" +
			"89585867174798546677575732056812884592054133405392200011378630094556068816674001" +
			"69842055804033637953764520304024322566135278369511778838638744396625322498506549" +
			"95886234281899707733276171783928034946501434558897071942586398772754710962953741" +
			"52111513683506275260232648472870392076431005958411661205452970302364725492966693" +
			"81151373227536450988890313602057248176585118063036442812314965507047510254465011" +
			"727211555194866850800368532281831521960037356252794495158284188294787610852639814";

	public static final BigDecimal minus_one= new BigDecimal("-1", mc);
	public static final BigDecimal zero= new BigDecimal("0", mc);
	public static final BigDecimal zeropointfive= new BigDecimal("0.1", mc);
	public static final BigDecimal one= new BigDecimal("1", mc);
	public static final BigDecimal two= new BigDecimal("2", mc);
	public static final BigDecimal three= new BigDecimal("3", mc);
	public static final BigDecimal nineteen= new BigDecimal("19", mc);
	public static final BigDecimal one_hundred_eighty= new BigDecimal("180", mc);
	public static final BigDecimal ten= new BigDecimal("10", mc);
	public static final BigDecimal pi= new BigDecimal(PI, mc);
	public static final BigDecimal two_pi= two.multiply(pi, mc);
	public static final BigDecimal e= new BigDecimal(E, mc);
	
	
	
	
	/**
	 * Hat als Eingabe einen String und übergibt diesen an den
	 * Konstruktor von BigDecimal, um eine neue Instanz von BigDecimal zu erstellen.
	 * Dabei wird der MathContext "mc" (200 Stellen Genauigkeit) genutzt.
	 * @param String number
	 * @return BigDecimal
	 */
	public static BigDecimal createNewBigDecimalNumber(String number) {
		
		return new BigDecimal(number, mc);
		
	}
	
	
	
	/**
	 * Hat als Eingabe einen String und übergibt diesen an den
	 * Konstruktor von BigDecimal, um eine neue Instanz von BigDecimal zu erstellen.
	 * Dabei wird der MathContext "mc_out" (30 Stellen Genauigkeit) genutzt.
	 * @param String number
	 * @return BigDecimal
	 */
	public static BigDecimal createFinalBigDecimalNumber(String number) {
		
		return new BigDecimal(number, mc_out);
		
	}
	
	
	
	/**
	 * Berechnet die Summe von a und b.
	 * @param BigDecimal a
	 * @param BigDecimal b
	 * @return BigDecimal a+b
	 */
	public static BigDecimal add(BigDecimal a, BigDecimal b) {
		
		return a.add(b, mc);
		
	}

	
	
	/**
	 * Berechnet die Differenz von a und b.
	 * @param BigDecimal a
	 * @param BigDecimal b
	 * @return BigDecimal a-b
	 */
	public static BigDecimal sub(BigDecimal a, BigDecimal b) {
		
		return a.subtract(b, mc);
		
	}
	
	
	
	/**
	 * Berechnet die Division von a und b.
	 * @param BigDecimal a
	 * @param BigDecimal b
	 * @return BigDecimal a/b
	 * @throws IllegalArgumentException Bei Null-Division.
	 */
	public static BigDecimal div(BigDecimal a, BigDecimal b) {
		
		if (b.compareTo(zero) == 0) {
			throw new IllegalArgumentException("Durch 0 teilen = Böse!");
		}
		
		return a.divide(b, mc);
		
	}
	
	

	/**
	 * Berechnet das Produkt von a und b.
	 * @param BigDecimal a
	 * @param BigDecimal b
	 * @return BigDecimal a*b
	 */
	public static BigDecimal mul(BigDecimal a, BigDecimal b) {
		
		return a.multiply(b, mc);
		
	}



	/**
	 * Berechnet die Fakultät von a.
	 * @param BigDecimal a Zahl, von der die Fakultät berechnet werden soll.
	 * @return BigDecimal a!
	 * @throws IllegalArgumentException Bei Nicht-Ganzzahligkeit oder Negativität.
	 */
	public static BigDecimal fak(BigDecimal a) {
		
		if (a.scale() != 0) {
			throw new IllegalArgumentException("Keine ganzzahlige Zahl! (Fakultät)");
		}
		else if (a.compareTo(zero) == -1) {
			throw new IllegalArgumentException("Negative Zahl! (Fakultät)");
		}
		else {
			BigDecimal i= new BigDecimal("1", mc);
			BigDecimal result= new BigDecimal("1", mc);

			if (a.compareTo(zero) == 0 || a.compareTo(one) == 0) { 
				return one;
			}
			else {
				while (a.compareTo(i) != 0) {
					
					i= i.add(one, mc);				  // i= i + 1
					result= result.multiply(i, mc);   // a * (a-1) * (a-2) * ... * 1
				}
				
				return result;
			}
		}
		
	}
	
	
	
	/**
	 * Wertet die Exponentialfunktion an der Stelle x aus.
	 * @param BigDecimal x
	 * @return BigDecimal exp(x)
	 */
	public static BigDecimal exp(BigDecimal x) {
		
		int b= 0;
		
		//Finde kleinstes b, sodass |x| < 10^b
		while (x.abs(mc).compareTo(ten.pow(b, mc)) == 1) {
			b++;
		}
		
		
		BigDecimal a= x.divide(ten.pow(b, mc), mc);		// a= x / 10^b
		BigDecimal r= new BigDecimal("0", mc);			// r= 0
		BigDecimal k= new BigDecimal("0", mc);			// k= 0
		BigDecimal kFak= new BigDecimal("1", mc);		// kFak= 1 (Da Fakultät von 0 = 1 ist)
		int kInt= 0;									// kInt= 0 (Wird parallel mit k inkrementiert, jedoch als Integer)
		
		
		//Durchlaufe while-Schleife, so lange e / (k+1)! >= epsilon gilt.
		while (e.divide(kFak.multiply(k.add(one, mc), mc), mc).compareTo(epsilon) != -1) {
			
			r= r.add(a.pow(kInt, mc).divide(kFak, mc), mc);		// r= r + a^k / k!
			
			k= k.add(one, mc);									// k= k + 1
			kFak= kFak.multiply(k, mc);							// kFak= kFak * k= k* (k-1) * (k-2) * ... * 1 (Um Fakultäten-Neuberechnung bei jeder Iteration zu vermeiden)
			kInt++;												// kInt= kInt + 1
		}
		
		
		//Durchlaufe while-Schleife, so lange b > 0 gilt.
		while (b > 0) {
			
			r= r.pow(10, mc);	// r= r^10
			b--;				// b= b - 1
		}
		
		return r;
		
	}
	
	
	
	/**
	 * Wertet den natürlichen Logarithmus (Basis e) an der Stelle x aus.
	 * @param BigDecimal x Die zu berechnende Stelle
	 * @return BigDecimal ln(x)
	 * @throws IllegalArgumentException Wenn x < 0 oder x = 0 ist.
	 */
	public static BigDecimal ln(BigDecimal x) {
		
		if (x.compareTo(zero) != 1) {
			throw new IllegalArgumentException("Der Logarithmus akzeptiert nur Stellen >= 0");
		}
		
		BigDecimal a= x;										// a= x
		BigDecimal w= new BigDecimal("0", mc);					// w= 0
		
		
		//Die while-Schleife wird so lange durchlaufen bis |1 - a| >= 0.1 nicht mehr gilt.
		while (one.subtract(a, mc).abs(mc).compareTo(zeropointfive) != -1) {
			
			a= a.sqrt(mc);										// a= sqrt(a)
			w= w.add(one, mc);									// w= w + 1
		}
		
		BigDecimal r= new BigDecimal("0", mc);					// r= 0
		BigDecimal k= new BigDecimal("0", mc);					// k= 0
		int kInt= 0;											// kInt= 0
		
		
		//Die while-Schleife wird so lange durchlaufen bis 1 / [ 180 * (2k + 3) * 19^(2k + 1) ] >= epsilon nicht mehr gilt.
		while (one.divide(one_hundred_eighty.multiply(k.multiply(two, mc).add(three, mc).multiply(nineteen.pow(2*kInt+1, mc), mc), mc), mc).compareTo(epsilon) != -1) {
			
			
			r= r.add(two.divide(two.multiply(k, mc).add(one, mc), mc).multiply(a.subtract(one, mc).divide(a.add(one, mc), mc).pow(2*kInt+1, mc)));	// r= r + [ 2 / (2k + 1) ] * [ (a -1) / (a + 1) ]^(2k + 1)
			k= k.add(one, mc);																														// k = k + 1
			kInt++;																																	// kInt= kInt + 1
		}
		
		
		//So lange w > 0 ist, wird while-Schleife durchlaufen.
		while (w.compareTo(zero) != 0) {	
			
			w= w.subtract(one, mc);								// r= 2*r
			r= r.multiply(two, mc);								// w= w - 1
		}
		
		return r;
		
	}
	
	
	
	/**
	 * Wertet den dekadischen Logarithmus (Basis 10) an Stelle x aus.
	 * @param BigDecimal x Die zu berechnende Stelle
	 * @return BigDecimal lg(x)
	 * @throws IllegalArgumentException Wenn x kleiner oder gleich 0 ist.
	 */
	public static BigDecimal lg(BigDecimal x) {
		
		BigDecimal zaehler= ln(x);
		BigDecimal nenner= ln(ten);
		
		return zaehler.divide(nenner, mc);		// ln(x) / ln(10)
		
	}
	
	
	
	/**
	 * Berechnet den allgemeinen Logarithmus zur Basis a an der Stelle b.
	 * @param BigDecimal a Basis
	 * @param BigDecimal b Die zu berechnende Stelle
	 * @return BigDecimal log(a, b)
	 * @throws IllegalArgumentException Wenn a kleiner oder gleich 0 ist oder a gleich 1 ist.
	 */
	public static BigDecimal log(BigDecimal a, BigDecimal b) {
		
		if (a.compareTo(one) == 0) {
			throw new IllegalArgumentException("Der Logarithmus akzeptiert keine Basis = 1.");
		}
	
		
		BigDecimal zaehler= ln(a);
		BigDecimal nenner= ln(b);
		
		
		return zaehler.divide(nenner, mc);		// ln(a) / ln(b)
		
	}
	
	
	
	/**
	 * Berechnet den Potenzwert der Basis a und des Exponenten b.
	 * @param BigDecimal a Basis
	 * @param BigDecimal b Exponent
	 * @return BigDecimal Potenz a^b
	 * @throws IllegalArgumentException Wenn a negativ ist oder wenn (a= 0 und b <= 0) ist.
	 */
	public static BigDecimal pot(BigDecimal a, BigDecimal b) {
		
	if (a.compareTo(zero) == -1 || (a.compareTo(zero) == 0 && b.compareTo(zero) != 1)) {
			if (a.compareTo(zero) == -1) {
				throw new IllegalArgumentException("Die Basis darf nicht negativ sein.");
			}
			else if (a.compareTo(zero) == 0 && b.compareTo(zero) != 1) {
				throw new IllegalArgumentException("Die Basis muss ungleich 0 und der Exponent > 0 sein.");
			}
		}
	
		BigDecimal ln_a= ln(a);
		
		return exp(ln_a.multiply(b, mc));		// exp( ln(a) * b )
		
	}
	

	
	/**
	 * Berechnet die Quadratwurzel von a
	 * @param BigDecimal a
	 * @return BigDecimal sqrt(a)
	 * @throws IllegalArgumentException Wenn a negativ ist.
	 */
	public static BigDecimal sqrt(BigDecimal a) {
		
		if (a.compareTo(zero) == -1) {
			throw new IllegalArgumentException("Die Quadratwurzelberechnung von negativen Zahlen ist nicht zulässig.");
		}	
		
		return pot(a, one.divide(two, mc));		// sqrt(a)= a^(1/2)
		
	}
	
	
	
	/**
	 * Berechnet die a-te Wurzel von b.
	 * @param BigDecimal a
	 * @param BigDecimal b
	 * @return BigDecimal root(a,b)
	 * @throws IllegalArgumentException Wenn a <= 0 oder b < 0.
	 */
	public static BigDecimal root(BigDecimal a, BigDecimal b) {
		
		if (a.compareTo(zero) != 1 || b.compareTo(zero) == -1) {
			if (b.compareTo(zero) == -1) {
				throw new IllegalArgumentException("Wurzelberechnung von negativen Zahlen ist nicht zulässig.");
			}
			else if (a.compareTo(zero) != 1) {
				throw new IllegalArgumentException("Die a-te Wurzel muss > 0 sein.");
			}
		}
		
		return pot(b, one.divide(a, mc));		// root(a, b)= b^(1/a)
		
	}
	
	
	
	/**
	 * Wertet den Sinus an der Stelle x aus.
	 * @param BigDecimal x
	 * @return BigDecimal sin(x)
	 */
	public static BigDecimal sin(BigDecimal x) {
		
		BigDecimal a= x.remainder(two_pi, mc);	// a= mod(2*PI)
		
		
		//Wenn a im Intervall (PI, 2*PI) liegt, dann substrahiere 2*PI von a.
		if (a.compareTo(pi) == 1 && a.compareTo(two_pi) == -1) {
			
			a= a.subtract(two_pi, mc);																						// a= a - 2*PI
		}
		else if (a.compareTo(pi) == 0) {
			return zero;
		}
		
		BigDecimal r= new BigDecimal("0", mc);																				// r= 0
		BigDecimal k= new BigDecimal("0", mc);																				// k= 0
		BigDecimal kFak1= new BigDecimal("6", mc);																			// (2k + 3)! (Wird auf 6 initialisiert, da (2 * 0 + 3)! = 3! = 6
		BigDecimal kFak2= new BigDecimal("1", mc);																			// (2k + 1)! (Wird auf 1 initialisiert, da (2 * 0 + 1)! = 1! = 1
		int kInt= 0;																										// Wird parallel zu k inkrementiert, jedoch als Integer-Variante

		
		//Durchlaufe while-Schleife, so lange PI^(2k + 3) / (2k + 3)! >= epsilon gilt.
		while (pi.pow(2*kInt+3, mc).divide(kFak1, mc).compareTo(epsilon) != -1) {
			
			r= r.add(minus_one.pow(kInt, mc).multiply(a.pow(2*kInt+1, mc).divide(kFak2, mc), mc), mc);						//r = r + (-1)^k * [ a^(2k + 1) / (2k + 1)! ]

			k= k.add(one, mc);																								// k= k + 1
			kInt++;																											// kInt= kInt + 1
			kFak1= kFak1.multiply(two.multiply(k, mc).add(two, mc), mc).multiply(two.multiply(k, mc).add(three, mc), mc);	// (2k + 3)!= (2k + 3) * [ (2k + 3) -1 ] * ... * 1
			kFak2= kFak2.multiply(two.multiply(k, mc), mc).multiply(two.multiply(k, mc).add(one, mc), mc);					// (2k + 1)!= (2k + 1) * [ (2k + 1) -1 ] * ... * 1
		}

		return r;
		
	}
	
	

	/**
	 * Berechnet den Kosinus an der Stelle a.
	 * @param BigDecimal a Die zu berechnende Kosinus-Stelle.
	 * @return BigDecimal cos(a)
	 */
	public static BigDecimal cos(BigDecimal a) {
		
		return sin(pi.divide(two, mc).subtract(a, mc));		// cos(a)= sin( PI/2 - a )
		
	}
	
	
	
	/**
	 * Berechnet den Tangens an der Stelle a.
	 * @param BigDecimal a Die zu berechnende Tangens-Stelle.
	 * @return BigDecimal tan(a)
	 * @throws IllegalArgumentException Wenn cos(a)= 0 (Null-Division).
	 */
	public static BigDecimal tan(BigDecimal a) {
		
		BigDecimal sin= sin(a);
		BigDecimal cos= cos(a);
		
		if (cos.compareTo(zero) == 0) {
			throw new IllegalArgumentException("Durch 0 teilen = Böse!");
		}
		
		return sin.divide(cos, mc);			// tan(a)= sin(a) / cos(a)
		
	}
	
	
}