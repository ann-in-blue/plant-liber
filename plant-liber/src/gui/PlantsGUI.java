package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import plantLiber.Pianta;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlantsGUI {

	private JFrame frame;
	private JTextField fieldNomeComune;
	private JTextField fieldNomeScientifico;
	private TablePanel tablePanelRisultati;

	
	static Connection conn = null;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlantsGUI window = new PlantsGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlantsGUI() {
		
		initialize();
		Connect();
	}
		
	public void Connect()
	{
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql//localhost/provaDB", "root","");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PlantLiber","root","P1nkk1");

		}catch (SQLException ex) {
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 23));
		frame.setBounds(100, 100, 988, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//TITOLI
		JLabel labelPlantliber = new JLabel("PlantLiber");
		labelPlantliber.setFont(new Font("Dialog", Font.BOLD, 23));
		labelPlantliber.setBounds(379, 23, 172, 39);
		frame.getContentPane().add(labelPlantliber);
		
		JLabel labelRicercaSemplice = new JLabel("Ricerca Semplice:");
		labelRicercaSemplice.setFont(new Font("Dialog", Font.BOLD, 17));
		labelRicercaSemplice.setBounds(12, 94, 194, 28);
		frame.getContentPane().add(labelRicercaSemplice);
		
		JLabel labelNomeComune = new JLabel("Nome comune:");
		labelNomeComune.setBounds(60, 134, 111, 28);
		frame.getContentPane().add(labelNomeComune);
		
		JLabel labelRicercaAvanzata = new JLabel("Ricerca Avanzata:");
		labelRicercaAvanzata.setFont(new Font("Dialog", Font.BOLD, 17));
		labelRicercaAvanzata.setBounds(12, 195, 177, 20);
		frame.getContentPane().add(labelRicercaAvanzata);
		
		JLabel labelNomeScientifico = new JLabel("Nome Scientifico:");
		labelNomeScientifico.setBounds(43, 227, 129, 23);
		frame.getContentPane().add(labelNomeScientifico);
		
		//campi input
		fieldNomeComune = new JTextField();
		fieldNomeComune.setBounds(189, 139, 114, 23);
		frame.getContentPane().add(fieldNomeComune);
		fieldNomeComune.setColumns(10);
		
		fieldNomeScientifico = new JTextField();
		fieldNomeScientifico.setBounds(190, 228, 114, 21);
		frame.getContentPane().add(fieldNomeScientifico);
		fieldNomeScientifico.setColumns(10);
		
		//tabella per vedere i risultati
		tablePanelRisultati = new TablePanel();
		tablePanelRisultati.setBounds(500, 100, 400, 200);
		frame.getContentPane().add(tablePanelRisultati);
		tablePanelRisultati.setVisible(false);

		
		JButton ricercaSemplice = new JButton("cerca");
		ricercaSemplice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome, query;
				ArrayList<Pianta> listaPiante = new ArrayList<>();
		
				nome = fieldNomeComune.getText();
				query = "SELECT * FROM PlantLiber.Pianta WHERE nomeComune=\""+ nome+"\"";

				tablePanelRisultati.setVisible(true);
				
				try {
		
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					
					//if(stmt.execute(query)) {
						//if(query.equalsIgnoreCase("default")) {
							//rs = stmt.getResultSet();
							
					while(rs.next()) {
						
						String idCampione = rs.getString("idCampione");
					    String nomeComune = rs.getString("nomeComune");
					    String nomeScientifico =rs.getString("nomeScientifico");
					    
					    listaPiante.add(new Pianta(idCampione, nomeComune, nomeScientifico));
					    tablePanelRisultati.aggiorna();
						System.out.println(idCampione + nomeComune + nomeScientifico);
						//tablePanelRisultati.setDataRicercaSemplice(idCampione, nomeComune, nomeScientifico);		 
		
						fieldNomeComune.setText("");
						fieldNomeComune.requestFocus();  //per rimettere il cursore su Common Name 
					
					
						}						
						
							tablePanelRisultati.setDataRicercaSemplice(listaPiante);		 

							System.out.println(listaPiante);
							stmt.close();
							//}
						//}
					} catch (SQLException e1) {
					e1.printStackTrace();
			
		}
				}

			}
		);
		
		ricercaSemplice.setBounds(306, 138, 84, 24);
		frame.getContentPane().add(ricercaSemplice);
		
		JButton ricercaAvanzata = new JButton("cerca");
		ricercaAvanzata.setBounds(306, 226, 84, 24);
		frame.getContentPane().add(ricercaAvanzata);
		
			}
		}
