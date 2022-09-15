package gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import plantLiber.Pianta;


public class TablePanel extends JPanel
{
	
	private JTable table;
	private TableModelPianta tableModelPianta;	//modello
	//menu tasto destro
	private JPopupMenu popupMenu;
	
	public TablePanel() {
		
		tableModelPianta = new TableModelPianta();
		table = new JTable(tableModelPianta);

		//MENU TASTO DESTRO -> elimina pianta
		popupMenu = new JPopupMenu();
		
		JMenuItem menuItemEliminaPianta = new JMenuItem("Elimina pianta");
		popupMenu.add(menuItemEliminaPianta);
		
		table.addMouseListener(new MouseAdapter()
				{
			@Override
			public void mousePressed(MouseEvent e) {
				//button 1: click sinistro, button 2: rotella, button3: tasto destro
				if(e.getButton() == MouseEvent.BUTTON3)
				{
					popupMenu.show(table, e.getX(), e.getY());
				}
			}
				});

		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}

	//dati presi dal db per la ricerca semplice
//	public void setDataRicercaSemplice(String idCampione, String nomeComune, String nomeScientifico)
//	{
//		tableModelPianta.setDataRicercaSemplice(idCampione, nomeComune, nomeScientifico);
//	}
	public void setDataRicercaSemplice(ArrayList<Pianta> listaPiante)
	{
		tableModelPianta.setDataRicercaSemplice(listaPiante);
	}
	public void aggiorna()
	{
		tableModelPianta.fireTableDataChanged();
	}
	
}
