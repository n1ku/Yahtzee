package ch.uniteit.yahtzee.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SimpleTableDemo extends JPanel {
	private boolean DEBUG = false;

	public SimpleTableDemo() {
		super(new GridLayout(1,0));

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
				{"Gesamtpunktzahl",new Integer(-1),new Integer(-1)}
		};

		Table table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}

		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		//Add the scroll pane to this panel.
		add(scrollPane);
	}

	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();
		System.out.println("Value of data: ");
		for (int i=0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j=0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("SimpleTableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		SimpleTableDemo newContentPane = new SimpleTableDemo();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
