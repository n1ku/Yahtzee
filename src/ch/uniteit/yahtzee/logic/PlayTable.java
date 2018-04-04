/**
 * PlayTisch ist der Spieltisch im Backend/in der Logik.
 * Es wird gewürfelt mit allen Würfeln im Spiel im Bezug auf Klasse Dice, danach Resultat zusammengerechnen.
 * Vorbereiten für Übergabe an GUI.
 *
 * @autor Fernando Maniglio
 * @autor Besnik Istrefi
 * @version 2018.01
 */
package ch.uniteit.yahtzee.logic;

import java.util.ArrayList;
import java.util.Objects;

//TODO würfeln und befüllen und so
public class PlayTable {
	protected int wuerfelAnzahl;
	protected ArrayList<Dices> dieWuerfel;
	protected int wuerfelScore;
	/**
	 * Konstruktor default.
	 * Setzt die Anzahl Würfel die im Spiel sind, und generiert diese in einem array..
	 */
	public PlayTable() {
		this.wuerfelAnzahl = 5;
		this.dieWuerfel = new ArrayList<>();
		//TODO prüfen ob 0 oder 1 richtig ist
		//int i = 0;
		//while(i <= wuerfelAnzahl){
		//	dieWuerfel.add(new Dices(index));
		//	i++;
		//}

		String[] columnNames = {"Oberer Teil",
				"Du", "Gegner"};

		Object[][] data = {
				{"Einer",new Integer(-1),new Integer(-1)},
				{"Zweier",new Integer(-1),new Integer(-1)},
				{"Dreier",new Integer(-1),new Integer(-1)},
				{"Vierer",new Integer(-1),new Integer(-1)},
				{"Fünfer",new Integer(-1),new Integer(-1)},
				{"Sechser",new Integer(-1),new Integer(-1)},
				{"Bonus (62)",new Integer(-1),new Integer(-1)},
				{"Zwischensumme Oben",new Integer(-1),new Integer(-1)},
				{"Unterer Teil",new Integer(-1),new Integer(-1)},
				{"Viererparsch",new Integer(-1),new Integer(-1)},
				{"Full-House",new Integer(-1),new Integer(-1)},
				{"Kleine Strasse",new Integer(-1),new Integer(-1)},
				{"Grosse Strasse",new Integer(-1),new Integer(-1)},
				{"Yahtzee",new Integer(-1),new Integer(-1)},
				{"Chance",new Integer(-1),new Integer(-1)},
				{"Zwischensumme Unten",new Integer(-1),new Integer(-1)},
				{"Gesamtpunktzahl",new Integer(0),new Integer(0)}
		};
	}

	/**
	 * Konstrukor custom
	 * Ermöglicht das Definieren der Anzahl Würfel die im Spiel sind..
	 * @param wuerfelAnzahl
	 */
	public PlayTable(int wuerfelAnzahl) throws Exception {
		if(wuerfelAnzahl <= 0){
			throw new Exception("Sie wollen ohne Würfel spielen? Like magic, haa? Leider nicht möglich.");
		}
		else {	this.wuerfelAnzahl = wuerfelAnzahl; }

		String[] columnNames = {"Oberer Teil",
				"Du", "Gegner"};

		Object[][] data = {
				{"Einer",new Integer(-1),new Integer(-1)},
				{"Zweier",new Integer(-1),new Integer(-1)},
				{"Dreier",new Integer(-1),new Integer(-1)},
				{"Vierer",new Integer(-1),new Integer(-1)},
				{"Fünfer",new Integer(-1),new Integer(-1)},
				{"Sechser",new Integer(-1),new Integer(-1)},
				{"Bonus (62)",new Integer(-1),new Integer(-1)},
				{"Zwischensumme Oben",new Integer(-1),new Integer(-1)},
				{"Unterer Teil",new Integer(-1),new Integer(-1)},
				{"Viererparsch",new Integer(-1),new Integer(-1)},
				{"Full-House",new Integer(-1),new Integer(-1)},
				{"Kleine Strasse",new Integer(-1),new Integer(-1)},
				{"Grosse Strasse",new Integer(-1),new Integer(-1)},
				{"Yahtzee",new Integer(-1),new Integer(-1)},
				{"Chance",new Integer(-1),new Integer(-1)},
				{"Zwischensumme Unten",new Integer(-1),new Integer(-1)},
				{"Gesamtpunktzahl",new Integer(0),new Integer(0)}
		};
	}
	// Würfeln, für jeden gespielten Würfel einmal würfeln
	public void wuerfeln () {
		for(Dices d: dieWuerfel) d.roll();
		this.berechneTisch();
	}
	// Rechnet alle Würfel zusammen
	public void berechneTisch(){
		for(Dices d: dieWuerfel){
			this.wuerfelScore = this.wuerfelScore + d.getRollScore();
		}
		System.out.println("Ergebnis ist " + this.wuerfelScore);
	}
	// commong methods and functions
	public int getWuerfelAnzahl() {
		return wuerfelAnzahl;
	}

	public void setWuerfelAnzahl(int wuerfelAnzahl) {
		this.wuerfelAnzahl = wuerfelAnzahl;
	}

	public int getWuerfelScore() {
		return wuerfelScore;
	}

	public void setWuerfelScore(int wuerfelScore) {
		this.wuerfelScore = wuerfelScore;
	}


}
