import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.swing.*;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender extends JFrame{
	public String QUEUE_NAME;
	JPanel panel = new JPanel();
	TextArea ta= new TextArea("");
	ConnectionFactory f;
	public Sender(String q,int loc) throws IOException, TimeoutException {
		this.QUEUE_NAME = q;
		//interface
		panel.add(ta);
		this.add(panel);
		this.setBounds(10,10,550,250);
		this.setVisible(true);
		this.addWindowListener( new WindowAdapter(){
		public void windowClosing( WindowEvent e)
		{
			System.exit(0);
		}});
		this.setLocation(50,loc);
		this.setTitle(q);
		//mqrabbit 
		
		TextAreaActionListener listener= new TextAreaActionListener(this);
		ta.addKeyListener(listener);
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		this.f = factory;
		
	}
	
}
