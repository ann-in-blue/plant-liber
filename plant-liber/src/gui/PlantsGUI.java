package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import plantLiber.Pianta;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.ActionEvent;

public class PlantsGUI {

	public JFrame frame;
	private JTextField fieldNomeComune;
	private JTextField fieldSpecie;
	private JTextField fieldNomeScientifico;
	private TablePanel tablePanelRisultati;
	//private TextAreaPanel textAreaRisultati;
	private JTextArea textAreaRisultati;
	private JScrollPane scrollPaneRisultati;
	private JFileChooser fileChooser;
	
//	private JLabel labelBottoni;
	
	//BOTTONI PER LE QUERY
	private JButton ricercaSemplice;
	private JButton ricercaAvanzata;
	private JButton btnPiantePerArea;
	private JButton btnHabitatOfficinali;
	private JButton btnCollezioneENumeroPiante;
	private JButton btnMediaPiantePerArea;
	
	static Connection conn = null;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
			

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
				
		/**
		 * Inizializzazione del frame principale
		 */
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 23));
		frame.setBounds(100, 100, 988, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//aggiunta il menu al frame
		frame.setJMenuBar(creaBarraMenu());

		
		//TITOLO DELL'APPLICAZIONE
		JLabel labelPlantliber = new JLabel("PlantLiber");
		labelPlantliber.setFont(new Font("Dialog", Font.BOLD, 23));
		labelPlantliber.setBounds(430, 23, 172, 39);
		frame.getContentPane().add(labelPlantliber);
		
		//TITOLO RICERCA SEMPLICE
		JLabel labelRicercaSemplice = new JLabel("Ricerca Semplice:");
		labelRicercaSemplice.setFont(new Font("Dialog", Font.BOLD, 17));
		labelRicercaSemplice.setBounds(12, 94, 194, 28);
		frame.getContentPane().add(labelRicercaSemplice);
		
		//Field per Inserimento nome comune
		JLabel labelNomeComune = new JLabel("Nome comune:");
		labelNomeComune.setBounds(60, 134, 111, 28);
		frame.getContentPane().add(labelNomeComune);
		
		//Field per Inserimento specie
		JLabel labelSpecie = new JLabel("Specie:");
		labelSpecie.setBounds(60, 170, 111, 28);
		frame.getContentPane().add(labelSpecie);
		
		//Titolo Ricerca Avanzata
		JLabel labelRicercaAvanzata = new JLabel("Ricerca Avanzata:");
		labelRicercaAvanzata.setFont(new Font("Dialog", Font.BOLD, 17));
		labelRicercaAvanzata.setBounds(12, 220, 177, 20);
		frame.getContentPane().add(labelRicercaAvanzata);
		
		//Titolo Nome Scientifico
		JLabel labelNomeScientifico = new JLabel("Caratteri iniziali del nome:");
		labelNomeScientifico.setBounds(43, 240, 129, 23);
		frame.getContentPane().add(labelNomeScientifico);
		
		//CAMPI IN INPUT
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
		
		//Tabella per vedere i risultati della ricerca
		tablePanelRisultati = new TablePanel();
		tablePanelRisultati.setBounds(500, 100, 400, 200);
		frame.getContentPane().add(tablePanelRisultati);
		tablePanelRisultati.setVisible(false);

		//Scroll panel per vedere i risultati delle query che non prevedono inserimento di input dall'utente
		textAreaRisultati = new JTextArea();
		textAreaRisultati.setEditable(false);

		scrollPaneRisultati = new JScrollPane(textAreaRisultati);
		scrollPaneRisultati.setBounds(550, 350, 400, 150);
		frame.getContentPane().add(scrollPaneRisultati);
		scrollPaneRisultati.setVisible(false);

		/**
		 * BOTTONE PER LA RICERCA SEMPLICE:
		 * E' collegato ad un Action Listener che, una volta cliccato il bottone, permette di eseguire la query specifica.
		 */
		ricercaSemplice = new JButton("cerca");
		
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
		
		
		/**
		 * BOTTONE PER LA RICERCA AVANZATA:
		 * E' collegato ad un Action Listener che, una volta cliccato il bottone, permette di eseguire la query specifica.
		 */
		ricercaAvanzata = new JButton("cerca");
		
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
					
					while(rs.next()) {
					//while(!rs.isAfterLast()) {
						
						String nomeScientifico =rs.getString("nomeScientifico");
					    String nomeSpecie = rs.getString("specie");
					    String famiglia = rs.getString("famiglia");
					    String regno =rs.getString("regno");
					    String divisione = rs.getString("divisione");
					    String clima = rs.getString("fasciaClimatica");
					    
					    listaPiante.add(new Pianta(nomeScientifico, nomeSpecie, famiglia, regno, divisione, clima));
					    
					    System.out.println(nomeScientifico +" "+ nomeSpecie + " "+ famiglia +" "+regno+" "+ divisione +" "+ clima);
					   
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
		
		//Label sezione dei bottoni per le altre query dell'applicazione
		JLabel labelBottoni = new JLabel("Ricerche frequenti");
		labelBottoni.setFont(new Font("Dialog", Font.BOLD, 17));
		labelBottoni.setBounds(100, 300, 200, 28);
		frame.getContentPane().add(labelBottoni);
		
		/**
		 * Bottone per la ricerca delle piante per area
		 */
		btnPiantePerArea = new JButton("Piante per Area");
		btnPiantePerArea.setBounds(70, 350, 150, 35);
		frame.getContentPane().add(btnPiantePerArea);
		
		btnPiantePerArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query = "SELECT nome, count "
						+ "FROM PlantLiber.piante_per_area "
						+ "where count > 30 ORDER BY nome";
		
				try {
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						String nome = rs.getString("nome");
						int count = rs.getInt("count");
					   
						textAreaRisultati.append(nome +":   "+ count);
						textAreaRisultati.append("\n");
						textAreaRisultati.setVisible(true);
						scrollPaneRisultati.setVisible(true);
						
						}
				}catch (SQLException e1) {
					e1.printStackTrace();
			
					}
				}
			});
				
		/**
		 * Bottone per gli ambienti con più piante officinali
		 */
		btnHabitatOfficinali = new JButton("Habitat con più Piante Officinali");
		btnHabitatOfficinali.setBounds(240, 350, 275, 35);
		frame.getContentPane().add(btnHabitatOfficinali);
		
		btnHabitatOfficinali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query = "select nome, count(*) from piante_per_habitat "
								+ "where idCampione IN (Select idCampione "
												+ "from PiantaOfficinale) "
								+ "group by nome "
								+ "order by count(*) DESC "
								+ "limit 5";
		
				try {
					
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						String nome = rs.getString("nome");
						int count = rs.getInt("count(*)");
					   
						textAreaRisultati.append(nome +":   "+ count);
						textAreaRisultati.append("\n");
						textAreaRisultati.setVisible(true);
						scrollPaneRisultati.setVisible(true);
						
						}
				}catch (SQLException e1) {
					e1.printStackTrace();
			
					}
				}
			});	
				
	
	/**
	 * Bottone per avere le collezioni e i numeri di piante presenti in esse
	 */
	btnCollezioneENumeroPiante = new JButton("Collezioni e numero di piante");
	btnCollezioneENumeroPiante.setBounds(70, 400, 250, 35);
	frame.getContentPane().add(btnCollezioneENumeroPiante);
	
	btnCollezioneENumeroPiante.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String query = "SELECT nomeCollezione, sum(count) FROM PlantLiber.collezione_per_area_e_numero\n"
					+ "group by nomeCollezione\n"
					+ "order by nomeCollezione";
	
			try {
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					
					String nome = rs.getString("nomeCollezione");
					int count = rs.getInt("sum(count)");
				   
					textAreaRisultati.append(nome +":   "+ count);
					textAreaRisultati.append("\n");
					textAreaRisultati.setVisible(true);
					scrollPaneRisultati.setVisible(true);
					
					}
			}catch (SQLException e1) {
				e1.printStackTrace();
		
				}
			}
		});
	
	
	/**
	 * Bottone che restituisce la media delle piante presenti nelle varie collezioni divise per area.
	 */
	btnMediaPiantePerArea = new JButton("Media piante per area");
	btnMediaPiantePerArea.setBounds(340, 400, 200, 35);
	frame.getContentPane().add(btnMediaPiantePerArea);
	
	btnMediaPiantePerArea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String query = "SELECT luogoRaccolta, avg(count) as media\n"
					+ "FROM PlantLiber.collezione_per_area_e_numero\n"
					+ "group by luogoRaccolta\n"
					+ "order by media;";
			
			try {
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					
					String luogo = rs.getString("luogoRaccolta");
					int media = rs.getInt("media");
				   
					textAreaRisultati.append(luogo +":   "+ media);
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
			
	
	/**
	 * METODO CHE CREA LA BARRA PER IL MENU.
	 * @return
	 */
	
	private JMenuBar creaBarraMenu()
	{
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		
		//items dentro la sezione 'file'
		JMenuItem menuFileAggiungiPianta = new JMenuItem("Aggiungi una pianta");
		JMenuItem menuFileAggiungiRaccoglitore = new JMenuItem("Aggiungi un raccoglitore");
		JMenuItem menuFileEliminaPianta = new JMenuItem("Elimina una pianta");
		
		//file chooser per caricare i dati da un file
		fileChooser = new JFileChooser();
		
		//aggiunta item al menu file
		menuFile.add(menuFileAggiungiPianta);
		menuFile.add(menuFileAggiungiRaccoglitore);
		menuFile.addSeparator();
		menuFile.add(menuFileEliminaPianta);

		//OPZIONE AGGIUNGI PIANTA
		menuFileAggiungiPianta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(menuFileAggiungiPianta) == JFileChooser.APPROVE_OPTION){
					caricaDaFile(fileChooser.getSelectedFile(), "Pianta");
					}
				}
			});
		
		//OPZIONE AGGIUNGI RACCOGLITORE
		menuFileAggiungiRaccoglitore.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(menuFileAggiungiRaccoglitore) == JFileChooser.APPROVE_OPTION){
					caricaDaFile(fileChooser.getSelectedFile(), "Raccoglitore");
					}
				}
			});
		
		//OPZIONE ELIMINA PIANTA
		menuFileEliminaPianta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//finestra per l inserimento dell'id della pianta in input
				String input = JOptionPane.showInputDialog(frame,  "Inserisci l'id del campione da eliminare...", "Inserimento id", JOptionPane.QUESTION_MESSAGE);
				int id = Integer.parseInt(input);
									
				String query = "DELETE FROM Pianta WHERE idCampione = "+ id;
				System.out.println(query);
				
				//connessione al db
				try {
					stmt = conn.createStatement();					
					stmt.execute(query);
					//stampa messaggio dopo l'eliminazione
					textAreaRisultati.append("Record eliminato");
					textAreaRisultati.append("\n");
					textAreaRisultati.setVisible(true);
					scrollPaneRisultati.setVisible(true);
					

				} catch (SQLException e1) {
					e1.printStackTrace();
					}
				}
			});
		
		barraMenu.add(menuFile);
		return barraMenu;
		} //creaBarraMenu

	/**
	 * Metodo per caricare dei dati da un file e inserirli nel database
	 * @param file
	 * @param entita -> indica in quale tabella inserire i dati
	 */
	public void caricaDaFile(File file, String entita)
	{
		try {
			
			Path filePath = Path.of(file.getAbsolutePath());	//recupera il Path del file
			String content = Files.readString(filePath);		//lettura stringa completa da file (stringa divisa in due da un trattino
			String query1, query2; //query per gli inserimenti
			
			//divisione della stringa a metà: prima metà in cui sono presenti i dati delle entità principali (pianta e raccoglitore) e seconda metà per i dati delle entita secondarie (istituto di ricerca e specie)
			String[] dati = content.split("-");
			
			//dati prima metà: pianta/raccoglitore -> datiPrimaMeta[3] contiene il nome della specie
			String[] datiPrimaMeta = dati[0].split(",");
			
			System.out.println(dati[0]);
			System.out.println("\n");
			System.out.println(datiPrimaMeta[3]);
			
			switch(entita){
					case "Pianta" :
						{ 
						query1 ="INSERT INTO Pianta(idCampione,nomeComune,nomeScientifico,specie,caratteristica,regione,area,ambiente,tipo)VALUES("+ dati[0] +")";
						query2 = "INSERT INTO Specie(nome)VALUES("+datiPrimaMeta[3]+")";
						break;
					}
					case "Raccoglitore":
					{
						query1 = "INSERT INTO Raccoglitore(CF,nome,cognome,istituto)VALUES("+dati[0]+")";
//							query2 = "INSERT INTO IstitutoDiRicerca(cod,via,numeroCivico,CAP,denominazione)VALUES("+ dati[1]+")";
						query2="";
						
						break;
					}
					default :
						{
							query1 = "";
							query2 = "";
							break;
						}
					}
		
			//connessione al db
			stmt = conn.createStatement();
			stmt.execute(query1);
			
			//query relativa agli istituti di ricerca/specie associati agli elementi già inseriti nel database
			if(entita.equals("Pianta"))
					stmt.execute(query2);

			//stampa messaggio dopo l'aggiunta
			textAreaRisultati.append("Record inserito correttamente");
			textAreaRisultati.append("\n");
			textAreaRisultati.setVisible(true);
			scrollPaneRisultati.setVisible(true);

			}catch (IOException i) {
				i.printStackTrace();
				
			} catch (SQLException e) {
				
			 textAreaRisultati.append("Errore nell'inserimento:\n");
			 textAreaRisultati.append(e.getMessage());
			 textAreaRisultati.append("\n");
			 textAreaRisultati.setVisible(true);
			 scrollPaneRisultati.setVisible(true);	
			}			
		}			
}
