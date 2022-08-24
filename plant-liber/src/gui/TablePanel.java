package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import plantLiber.Pianta;


public class TablePanel extends JPanel
{
	
	private JTable table;
	private TableModelPianta tableModelPianta;	//modello
	
	public TablePanel() {
		
		tableModelPianta = new TableModelPianta();
		table = new JTable(tableModelPianta);

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
