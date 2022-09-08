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
import javax.swing.ScrollPaneConstants;

import plantLiber.Pianta;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlantsGUI {

	private JFrame frame;
	private JTextField fieldNomeComune;
	private JTextField fieldSpecie;
	private JTextField fieldNomeScientifico;
	private TablePanel tablePanelRisultati;
	//private TextAreaPanel textAreaRisultati;
	private JTextArea textAreaRisultati;
	private JScrollPane scrollPaneRisultati;

	private JLabel labelBottoni;
	
	//bottoni query
	private JButton btnPiantePerArea;
	
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
		
		//inserimento specie
		JLabel labelSpecie = new JLabel("Specie:");
		labelSpecie.setBounds(60, 170, 111, 28);
		frame.getContentPane().add(labelSpecie);
		
		JLabel labelRicercaAvanzata = new JLabel("Ricerca Avanzata:");
		labelRicercaAvanzata.setFont(new Font("Dialog", Font.BOLD, 17));
		labelRicercaAvanzata.setBounds(12, 220, 177, 20);
		frame.getContentPane().add(labelRicercaAvanzata);
		
		JLabel labelNomeScientifico = new JLabel("Caratteri iniziali del nome:");
		labelNomeScientifico.setBounds(43, 240, 129, 23);
		frame.getContentPane().add(labelNomeScientifico);
		
		//campi input
		fieldNomeComune = new JTextField();
		fieldNomeComune.setBounds(189, 139, 114, 23);
		frame.getContentPane().add(fieldNomeComune);
		fieldNomeComune.setColumns(10);
		
		fieldSpecie = new JTextField();
		fieldSpecie.setBounds(189, 170, 114, 23);
		frame.getContentPane().add(fieldSpecie);
		fieldSpecie.setColumns(10);
		
		fieldNomeScientifico = new JTextField();
		fieldNomeScientifico.setBounds(190, 240, 114, 21);
		frame.getContentPane().add(fieldNomeScientifico);
		fieldNomeScientifico.setColumns(10);
		
		//tabella per vedere i risultati della ricerca
		tablePanelRisultati = new TablePanel();
		tablePanelRisultati.setBounds(500, 100, 400, 200);
		frame.getContentPane().add(tablePanelRisultati);
		tablePanelRisultati.setVisible(false);

		//Scroll panel per vedere i risultati delle query che non prevedono inserimento di input dall'utente
		textAreaRisultati = new JTextArea();
		textAreaRisultati.setEditable(false);

		scrollPaneRisultati = new JScrollPane(textAreaRisultati);
		scrollPaneRisultati.setBounds(500, 350, 400, 150);
		frame.getContentPane().add(scrollPaneRisultati);
		scrollPaneRisultati.setVisible(false);

		
		JButton ricercaSemplice = new JButton("cerca");
		ricercaSemplice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome, specie, query;
				ArrayList<Pianta> listaPiante = new ArrayList<>();
		
				nome = fieldNomeComune.getText();
				specie = fieldSpecie.getText();
				query = "SELECT idCampione, nomeComune, nomeScientifico, nomeSpecie, famiglia "
						+ "FROM PlantLiber.Pianta, PlantLiber.Classificazione "
						+ "WHERE nomeComune=\""+ nome+"\" and nomeSpecie=\""+ specie +"\"";

				System.out.println(query);
				tablePanelRisultati.setVisible(true);
				
				try {
		
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					
					//if(stmt.execute(query)) {
						//if(query.equalsIgnoreCase("default")) {
							//rs = stmt.getResultSet();
					while(rs.next()) {
						
						String idCampione = rs.getString("idCampione");
					    String nomeScientifico =rs.getString("nomeScientifico");
					    String nomeSpecie = rs.getString("nomeSpecie");
					    String famiglia = rs.getString("famiglia");
					    
					    listaPiante.add(new Pianta(idCampione, nomeScientifico, nomeSpecie, famiglia));
					    tablePanelRisultati.aggiorna();		
						fieldNomeComune.setText("");
						fieldNomeComune.requestFocus();  //per rimettere il cursore su Common Name 
					
						}						
						
					if(!listaPiante.isEmpty())
					{
						textAreaRisultati.repaint();
						tablePanelRisultati.setDataRicercaSemplice(listaPiante);
							
					} else {
						JOptionPane.showMessageDialog(frame, "Elemento non trovato.\nControllare di aver inserito i dati corretti.");
					}
							stmt.close();		
					
				
					} catch (SQLException e1) {
					e1.printStackTrace();
			
					}
				}

			}
		);
		
		ricercaSemplice.setBounds(306, 155, 84, 24);
		frame.getContentPane().add(ricercaSemplice);
		
		JButton ricercaAvanzata = new JButton("cerca");
		ricercaAvanzata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String caratteri, query;
				ArrayList<Pianta> listaPiante = new ArrayList<>();
		
				caratteri = fieldNomeScientifico.getText();
				query = "SELECT nomeScientifico, specie, famiglia, regno, divisione, fasciaClimatica "
						+ "FROM PlantLiber.Pianta as P, PlantLiber.Classificazione as C, PlantLiber.Habitat as H"
						+ " WHERE nomeScientifico LIKE '"+ caratteri +"%' and P.specie = C.nomeSpecie and P.ambiente = H.nome";

				System.out.println(query);
				
				try {
		
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					
					//if(stmt.execute(query)) {
						//if(query.equalsIgnoreCase("default")) {
							//rs = stmt.getResultSet();
					while(rs.next()) {
						
					    String nomeScientifico =rs.getString("nomeScientifico");
					    String nomeSpecie = rs.getString("specie");
					    String famiglia = rs.getString("famiglia");
					    String regno =rs.getString("regno");
					    String divisione = rs.getString("divisione");
					    String clima = rs.getString("fasciaClimatica");
					    
					    listaPiante.add(new Pianta(nomeScientifico, nomeSpecie, famiglia, regno, divisione, clima));
						textAreaRisultati.append(nomeScientifico +" "+ nomeSpecie + " "+ famiglia +" "+regno+" "+ divisione +" "+ clima);
						textAreaRisultati.append("\n");
						textAreaRisultati.setVisible(true);
						scrollPaneRisultati.setVisible(true);
						
					}						
						
					if(listaPiante.isEmpty())
						JOptionPane.showMessageDialog(frame, "Elemento non trovato.\nControllare di aver inserito i dati corretti.");
					
							stmt.close();		
					
				
					} catch (SQLException e1) {
					e1.printStackTrace();
			
					}
				}

			}
		);
		ricercaAvanzata.setBounds(306, 240, 84, 20);
		frame.getContentPane().add(ricercaAvanzata);
		
		//label sezione dei bottoni
		JLabel labelBottoni = new JLabel("Ricerche frequenti");
		labelBottoni.setFont(new Font("Dialog", Font.BOLD, 17));
		labelBottoni.setBounds(100, 300, 200, 28);
		frame.getContentPane().add(labelBottoni);
		
		//bottone per la ricerca delle piante per area
		JButton btnPiantePerArea = new JButton("Piante per Area");
		btnPiantePerArea.setBounds(60, 350, 150, 30);
		frame.getContentPane().add(btnPiantePerArea);
		
		btnPiantePerArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query = "SELECT nome, count "
						+ "FROM PlantLiber.piante_per_area "
						+ "where count > 30";
		
				try {
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						String nome = rs.getString("nome");
						int count = rs.getInt("count");
					   
						textAreaRisultati.append(nome +" "+ count);
						textAreaRisultati.append("\n");
						textAreaRisultati.setVisible(true);
						scrollPaneRisultati.setVisible(true);
						
						}
				}catch (SQLException e1) {
					e1.printStackTrace();
			
					}
				}
			});
				
				
				
				
				
				
				
				
				
	}
}
