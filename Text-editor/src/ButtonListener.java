import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class ButtonListener implements ActionListener{
	Client f;
	public ButtonListener(Client f)
	{
		this.f=f;
	}
	public void actionPerformed(ActionEvent evt)
	{
		try{
			int n= Integer.parseInt(f.textName.getText());
			int dis=0;
				/*Scanner in = new Scanner(System.in);
				System.out.print("Donner un nombre de Senders: \n" );
				n = in.nextInt();*/
			
			for (int i=0;i<n;i++)
			{
				String queue = "Text-editor"+i;
				Sender s = new Sender(queue,dis +i*250);
			}
			Receiver r= new Receiver(n);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
