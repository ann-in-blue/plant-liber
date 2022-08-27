package gui;

import java.awt.*;

import javax.swing.*;

public class TextAreaPanel extends JPanel
{
	//JPanel è un contenitore in cui possiamo aggiungere altri componenti
	

	private JTextArea textArea;
	
	public TextAreaPanel()
	{
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		add(textArea, BorderLayout.CENTER);
		
	}
	
	public void appendiTesto(String testo)
	{
		textArea.append(testo);
	}
}
