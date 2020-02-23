import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.swing.*;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender_bis extends JFrame{
	public final static String QUEUE_NAME = "Text-editor";
	JPanel panel = new JPanel();
	TextArea ta= new TextArea("");
	ConnectionFactory f;
	public Sender_bis() throws IOException, TimeoutException {
		//interface
		panel.add(ta);
		this.add(panel);
		this.setBounds(10,10,500,400);
		this.setVisible(true);
		this.addWindowListener( new WindowAdapter(){
		public void windowClosing( WindowEvent e)
		{
			System.exit(0);
		}});
		
		//mqrabbit 
		
		TextAreaActionListener listener= new TextAreaActionListener(this);
		ta.addKeyListener(listener);
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		this.f = factory;
		
	}
	public static void main(String[] args)
	{
		//instanciating interface
		try{
			Sender s = new Sender();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
