package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import plantLiber.Pianta;

/**
 * classe a cui vengono passati i dati delle piante a seguito di una query al database per essere mostrati all'utente.
 * 
 * @author ann
 *
 */
public class TableModelPianta extends AbstractTableModel
{
	private ArrayList<Pianta> listaPiante;
	
	private String[] nomiColonne = {"nome comune", "nome scientifico"};

	public TableModelPianta()
	{
		
	}

	@Override
	public String getColumnName(int column) {
		return nomiColonne[column];
	}
	public void setDataRicercaSemplice(ArrayList<Pianta> listaPiante) {
		this.listaPiante = listaPiante;	
		
	}

	@Override
	public int getRowCount() {
		return listaPiante!=null? listaPiante.size() : 0;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			
		Pianta pianta = listaPiante.get(rowIndex);

		//recuperiamo dalla riga l'elemento nella colonna cercata
		return switch(columnIndex)
		{
		case 0 -> pianta.getNomeComune();
		case 1 -> pianta.getNomeScientifico();
		default -> null;
		};
		
		}
	}


