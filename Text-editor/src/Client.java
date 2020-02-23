import java.util.Scanner;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.swing.*;



public class Client extends JFrame{
	JPanel panel = new JPanel();
	JLabel labelName = new JLabel("Donner un entier de Senders: ");
	JTextField textName = new JTextField("",20);
	JButton jButton = new JButton("OK");
	public Client() {
		panel.add(labelName);
		panel.add(textName);
		panel.add(jButton);
		this.add(panel);
		this.setBounds(10,10,550,100);
		this.setVisible(true);
		this.setTitle("Welcome !");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.addWindowListener( new WindowAdapter(){
		public void windowClosing( WindowEvent e)
		{
			System.exit(0);
		}});
		
		ButtonListener listener= new ButtonListener(this);
		jButton.addActionListener(listener);
		
	}
	public static void main(String[] args)
	{
		//instanciating interface
		Client c = new Client();

		
	
	}
}
