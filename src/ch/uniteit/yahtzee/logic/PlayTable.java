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


import ch.uniteit.yahtzee.gui.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;


//TODO würfeln und befüllen und so
public class PlayTable extends ScoreTable implements ListSelectionListener{
	private int wuerfelAnzahl;
	private ArrayList<Dices> dieWuerfel;
	private int wuerfelScore;
	private int spielerZug; // hält den Spaltenindex des Spieler der gerade dran ist
	private Rules regelnScore;
	private Rules localRules;
	private JTable tabelle;

	/**
	 * Konstruktor default.
	 * Setzt die Anzahl Würfel die im Spiel sind, und generiert diese in einem array..
	 */
	public PlayTable() {
		super();
		this.localRules = new Rules();
		this.wuerfelAnzahl = 5;
		this.dieWuerfel = new ArrayList<>();
		this.spielerZug = 1;
		int i = 0;
		while (i < wuerfelAnzahl) {
			dieWuerfel.add(new Dices(i));
			i++;
		}
		this.tabelle = scoreTable;
		addSelectionListener();
	}

	/**
	 * Konstrukor custom
	 * Ermöglicht das Definieren der Anzahl Würfel die im Spiel sind..
	 *
	 * @param wuerfelAnzahl
	 */
	public PlayTable(int wuerfelAnzahl, int index) throws Exception {
		super();

		if (wuerfelAnzahl <= 0) {
			//TODO GUI handling?
			String expStr = "Sie wollen ohne Würfel spielen? Like magic, haa? Leider nicht möglich.";
			throw new Exception(expStr);
		} else {
			this.wuerfelAnzahl = wuerfelAnzahl;
		}

		int i = 0;
		while (i <= wuerfelAnzahl) {
			dieWuerfel.add(new Dices(index));
			i++;
		}
	}

	// Würfeln, für jeden gespielten Würfel. Alle Würfel als ArrayList zurückliefert
	public ArrayList<Dices> gibWuerfel() {
		if (dieWuerfel != null) return dieWuerfel;
		else return null;
	}

	public void alleWuerfeln() {

		for (Dices d : dieWuerfel) {
			if (d.getOnHold() == false) {
				d.roll();
				d.repaint();
			}
		}

	}

	// Rechnet alle Würfel zusammen
	public void berechneTisch() {
		for (Dices d : dieWuerfel) {

			this.wuerfelScore = this.wuerfelScore + d.getRollScore();


		}

	}

	public void addSelectionListener() {


		this.cellSelectionModel.addListSelectionListener(this);
		
	}
			@Override
			public void valueChanged(ListSelectionEvent e) {
			
				if (!e.getValueIsAdjusting()) {
				//int sc = scoreTable.getSelected();
				//sc = scoreTable.getSelectedColumn(); //
				//String selRule = scoreTable.getValueAt(sr, 0).toString();
				//String isLocked;
				//isLocked = (scoreTable.getValueAt(sr, sc)).toString();
				//getSelectedColumn();
				
				wertEinfuellenTabelle(tabelle.getSelectedRow(),tabelle.getSelectedColumn());
				}
			}

			
	// werte der Tabelle setzten und Regeln überprüfen
		
	public void wertEinfuellenTabelle(int sr, int sc) {



		int punktzahl = 0;

		switch (sr) {

			case 0:
				
				punktzahl = rl.einerPruefung(dieWuerfel);

				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				
				
				if(sc != 0 && sc != 2 && sc != 4) scoreTable.setValueAt(punktzahl, sr, sc);
				tabelle.setValueAt(punktzahl,sr,sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();



				break;
			case 1:

				punktzahl = rl.zweierPruefung(dieWuerfel);

				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4) scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();


				
				break;
			case 2:

				punktzahl = rl.dreierPruefung(dieWuerfel);

				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();

				break;
			case 3:

				punktzahl = rl.viererPruefung(dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();


				break;
			case 4:

				punktzahl = rl.fuenferPruefung(dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();

				break;
			case 5:

				punktzahl = rl.sechserPruefung(dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();


				break;
			case 6:
				punktzahl = rl.ruleCheck("Dreierpasch",dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();
;
				break;
			case 7:
				punktzahl = rl.ruleCheck("Vierpasch",dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();

				break;
			case 8:
				punktzahl = rl.ruleCheck("FullHouse",dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();

				break;
			case 9:
				punktzahl = rl.ruleCheck("KleineStrasse",dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();


				break;
			case 10:
				punktzahl = rl.ruleCheck("GrosseStrasse",dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();

				break;
			case 11:
				punktzahl = rl.ruleCheck("Kniffel",dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();

				break;

			case 12:
				punktzahl = rl.ruleCheck("Chance",dieWuerfel);
				tabelle.setValueAt(new Boolean(true), sr,this.spielerZug+1);
				if(sc != 0 && sc != 2 && sc != 4)scoreTable.setValueAt(punktzahl, sr, sc);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();

				break;
				
			default:
				punktzahl = 0;
				break;
		}

		
		
		for(Dices d : dieWuerfel) {
			
			d.setRollScore(0);
			
		}
	}
	
		

		/*if(scoreTable.getSpielTisch().getSpielerZug() ==1) {


			scoreTable.getSpielTisch().gibScoreTable().setValueAt(bonus(), 0, 1);
			sumTable.setValueAt(summeOben(), 1, 1);
			sumTable.setValueAt(summeUnten(), 1, 2);



		}
		else {
			sumTable.setValueAt(bonus(), 1, 1);
			sumTable.setValueAt(summeOben(), 1, 2);
			sumTable.setValueAt(summeUnten(), 1, 3);
		}

		System.out.println("Rules liefert " + punktzahl);


		if(sc != 0) {
			scoreTable.setValueAt(punktzahl, sr, sc);
		}

		String isLocked = (scoreTable.getValueAt(sr, getSpielerZug()).toString());
		String selRule = (scoreTable.getValueAt(sr, 0)).toString();
		if (isLocked.equals("false")) {
			scoreTable.setValueAt(punktzahl, sr, sc);
			//scoreTable.setValueAt(new Boolean(true), getSpielerZug(), sc);

		} else {
			System.out.println(selRule + " ist gesperrt..");
		}

		//if(getSpielerZug() == 1) setSpielerZug(3);
		//else if(getSpielerZug() == 3) setSpielerZug(1);

	=======
		getSelectedColumn();
		getSelectedRow();






	}*/

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

	public int getSpielerZug() {
		return spielerZug;
	}

	public void setSpielerZug(int spieler) {
		this.spielerZug = spielerZug;
	}
}