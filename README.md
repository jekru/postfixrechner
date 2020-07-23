# :heavy_plus_sign: :heavy_minus_sign: :heavy_multiplication_x: :heavy_division_sign: Postfix Rechner :heavy_plus_sign: :heavy_minus_sign: :heavy_multiplication_x: :heavy_division_sign:

![](https://abload.de/img/postfixcalcinj2k.png)

Dieses Projekt ist im Zuge des Programmierpraktikums im Sommersemester 2020 an der Universität zu Köln (Department Mathematik/Informatik, Abteilung Informatik) entstanden und hat den Grundstudiumszyklus "Informatik" abgeschlossen. Ziel war im wesentlichen die Vertiefung des Umgangs mit höheren Programmiersprachen (in diesem Fall Java) und der Einsatz von Algorithmen im Rahmen eines größeren Programms. Das Projekt wurde mit 1.0 bewertet.

Der folgende Abschnitt wurde aus der Aufgabenstellung des Praktikums übernommen und ist hierfür freundlicherweise vom Dozenten Laslo Hunhold zur Verfügung gestellt worden.

## Einführung

Die Motivation dieses Projektes war die Entwicklung eines Programms, welches auch im Alltag nützlich ist und einen Mehrwert bietet. Ein Beispiel für ein solches Programm ist ein Taschenrechner, der bei kleineren Berechnungen hilfreich ist. Die heutzutage häufigste Verwendung erfolgt auf mobilen Endgeräten. Die Funktionen reichen aus, um beispielsweise Beträge zu addieren oder Prozentsätze auszurechnen, stoßen aber an ihre Grenzen, wenn es um die Lösung komplexer Ausdrücke geht. Aber auch in Bezug auf Benutzbarkeit ("Wie schnell kann ich meine Gleichung in den Rechner übertragen?") und Genauigkeit ("Inwieweit kann ich dem Ergebnis trauen?") gibt es Grenzen. Gegenstand dieses Projektes ist die Entwicklung eines Taschenrechners, der sowohl eine einfache als auch eine zweifelsfreie beliebige Genauigkeit als Zielsetzung hat.

## Postfixnotation

In Bezug auf die Benutzbarkeit ist eine Leitfrage und ein häufig ignorierter Aspekt, wie sich ein gegebener Ausdruck möglichst schnell in den Rechner übertragen lässt. Betrachten wir dazu folgenden Ausdruck:

![](https://latex.codecogs.com/svg.latex?(2%20+%204)%20*%20(6%20+%209))

Es ist auffällig, dass man relativ viele Klammern setzen muss, um Beziehungen zwischen den Operatoren und Operanden korrekt wiederzugeben. Mehr Klammern bedeuten natürlich auch mehr notwendige Eingaben. Die Ursache für diese Notwendigkeit von Klammern sind Präzedenzregeln von Operatoren, z.B. Punkt-vor-Strich, welche häufig mit Klammern "überschrieben" werden müssen. Es stellt sich also die Frage, ob Klammern überhaut notwendig sind. Eine alternative Schreibweise von Ausdrücken ist nämlich mit der Postfixnotation möglich. Wandeln wir nun den betrachteten Ausdruck in Postfixnotation um, so erhalten wir:

![](https://latex.codecogs.com/svg.latex?%202\%20\4%20+%206\%20\9%20+%20*)

Der enorme Vorteil dieser Notation ist also, dass es keine Präzedenzregeln zwischen Operatoren gibt. Die Auswertungsreihenfolge wird allein durch die Notation an sich vorgegeben, was die Eingabekomplexität massiv verringert.

[Mehr zur Postfixnotation auf Wikipedia](https://de.wikipedia.org/wiki/Umgekehrte_polnische_Notation)

## Die Methoden

### Elementare Rechenoperationen

* Addition (+, add(a,b)): Berechne die Summe von a und b.
* Subtraktion (-, sub(a,b)): Ziehe b von a ab.
* Division (/, div(a,b)): Teile a durch b und werfe eine Exception, falls b = 0.
* Multiplikation (*, mul(a,b)): Berechne das Produkt von a und b.

### Fakultät

Der Fakultätsoperator ist einer der wenigen Operatoren, die auch sonst immer in PostfixNotation geschrieben werden. Insofern ist die Benutzung dieses Operators im Rechner intuitiv.

* Fakultät (!, fak(a)): Berechne die Fakultät von a, falls a ganzzahlig und a ≥ 0 ist, und
werfe sonst eine Exception

### Exponentialfunktion

* Exponentialfunktion (exp, exp(a)): Werte die Exponentialfunktion an der Stelle a aus.


#### Berechnung


Mittels der [Taylorreihe](https://de.wikipedia.org/wiki/Taylorreihe) kann die Exponentialfunktion wie folgt dargestellt werden:

![](https://image.prntscr.com/image/oQUn_gjwTMCbH4zaN8RbCQ.png)

Aus dem [Satz von Taylor](https://de.wikipedia.org/wiki/Taylor-Formel) folgt eine obere Schranke, mit der man eine Restgliedabschätzung durchführen kann. Dieses Restglied sollte eine vorher definierte Fehlertoleranz nicht überschreiten. Präzisere Erklärungen wurden der Übersichtlichkeit halber weggelassen.


### Logarithmen

*  Natürlicher Logarithmus (ln, ln(a)): Werte den natürlichen Logarithmus (Basis e) an der
Stelle a aus.
* Dekadischer Logarithmus (lg, lg(a)): Werte den dekadischen Logarithmus (Basis 10) an
der Stelle a aus.
* Allgemeiner Logarithmus (log, log(a,b)): Werte den Logarithmus zur Basis a an der
Stelle b aus. Werfe eine Exception, falls a kleiner gleich 0 oder gleich 1 ist.

Natürlich werfen alle Logarithmus-Funktionen eine Exception, falls das Argument kleiner
gleich 0 ist.

#### Berechnung

Auch der natürliche Logarithmus lässt sich über eine Reihendarstellung auswerten. Diese Reihe lässt sich aus einem Zusammenhang des natürlichen Logarithmus mit dem [Areatangens hyperbolicus](https://de.wikipedia.org/wiki/Areatangens_hyperbolicus_und_Areakotangens_hyperbolicus) herleiten. Man erhält folgende Reihe:

![](https://image.prntscr.com/image/UsA7Jm5jSDui4rLNTPR-5Q.png)

Auch hier kann man kann man mit dem [Satz von Taylor](https://de.wikipedia.org/wiki/Taylor-Formel) wieder eine Restgliedabschätzung durchführen, genauere Erklärungen wurden auch hier der Übersichtlichkeit halber weggelassen.

Um den dekadischen und den allgemeinen Logarithmus zu berechnen, kann man folgende Eigenschaft nutzen:

![](https://image.prntscr.com/image/1f3jBQy0SFeHH0gAiCQzdw.png)


### Potenzierung

Für die Potenzierung ![](https://latex.codecogs.com/gif.latex?a%5E%7Bb%7D) wird nur der Fall betrachtet, dass a positiv ist.

* Potenz (^, pot(a,b)): Berechne die Potenz ![](https://latex.codecogs.com/gif.latex?a%5E%7Bb%7D) und werfe eine Exception, falls a negativ ist oder a = 0 und b kleiner gleich 0.

### Wurzel

* Quadratwurzel (sqrt, sqrt(a)): Berechne die Quadratwurzel von a und werfe eine Exception, falls a < 0.
* Wurzel (root, root(a,b)): Berechne die a-te Wurzel von b und werfe eine Exception, falls a kleiner gleich 0 oder b < 0.

### Trigonometrische Funktionen

* Sinus (sin, sin(a)): Werte den Sinus an der Stelle a aus.
* Kosinus (cos, cos(a)): Werte den Kosinus an der Stelle a aus.
* Tangens (tan, tan(a)): Werte den Tangens an der Stelle a aus. Werfe eine Exception,
falls cos(a) = 0 ist.

#### Berechnung

Man betrachtet die Reihenentwicklung der Sinusfunktion, die wie folgt lautet:

![](https://image.prntscr.com/image/DH51kTFMQOGv9Dpvd0iI_w.png)

Mit dem [Satz von Taylor](https://de.wikipedia.org/wiki/Taylor-Formel) kann man wieder eine Restgliedabschätzung durchführen, was hier der Übersichtlichkeit halber auch weggelassen wurde.

Der Kosinus ist lediglich eine horizontale Verschiebung und Spiegelung des Sinus, nämlich:

![](https://image.prntscr.com/image/z6RI33o2QcmDs9QQvuS9Bg.png)

Ähnlich sieht es beim Tangens aus, der wie folgt definiert ist:

![](https://image.prntscr.com/image/Hc8Z8HJbTNiPTDPtnljcEA.png)
