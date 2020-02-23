import java.awt.event.*;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
public class TextAreaActionListener implements KeyListener{
	Sender f;
	public TextAreaActionListener(Sender f)
	{
		this.f=f;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		String text = f.ta.getText();
		if("".equals(text))
		{
		   /* System.out.println("empty string");  */
		}else {
			//System.out.printf("Text written : "+ text + "\n");
			String message = text;
			try (Connection connection= f.f.newConnection(); Channel channel=connection.createChannel())
				{
				channel.queueDeclare(this.f.QUEUE_NAME,false,false,false,null);
				channel.basicPublish("", this.f.QUEUE_NAME, null, message.getBytes());
				//System.out.println(" [x] Sent '"+ message + "'");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TimeoutException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
