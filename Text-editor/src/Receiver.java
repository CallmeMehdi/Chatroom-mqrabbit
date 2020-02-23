import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.swing.*;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.util.ArrayList;


public class Receiver extends JFrame{
	public ArrayList<String> queues;
	JPanel panel = new JPanel();
	public ArrayList<TextArea> ta;
	public Receiver(int n) throws IOException, TimeoutException {
		this.queues = new ArrayList<String>();
		for(int i=0;i<n;i++)
		{
			String queue = "Text-editor"+i;
			this.queues.add(queue);
		}
		
		this.ta = new ArrayList<TextArea>();
		for (int i=0;i<n;i++)
		{
			TextArea textArea= new TextArea(" ");
			this.ta.add(textArea);
		}

		//interface
		for (int i=0;i<ta.size();i++)
		{
			ta.get(i).setEditable(false);
			panel.add(ta.get(i));
		}
		/*panel.add(ta);
		panel.add(ta1);*/
		this.add(panel);
		this.setBounds(10,10,550,n*200);
		this.setVisible(true);
		this.addWindowListener( new WindowAdapter(){
		public void windowClosing( WindowEvent e)
		{
			System.exit(0);
		}});
		this.setLocation(1000,50);
		this.setTitle("Receiver");
		
		//mqrabbit
		
		
		//QUEUE 
		for (int i=0;i<n;i++)
		{
			String q = queues.get(i);
			TextArea currentTextArea = ta.get(i);
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			
			Connection connection = factory.newConnection();
			
			Channel channel = connection.createChannel();
			
			channel.queueDeclare(q, false, false, false, null);
			//System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
			
			DeliverCallback deliverCallback = (consumertag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			//System.out.println(" [x] Received '" + message + "'");
			currentTextArea.setText(message);
			};

			channel.basicConsume(q, true, deliverCallback, consumerTag -> {});
		}
		
		
		
	}
	
}
