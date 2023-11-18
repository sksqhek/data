package java_net;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.*;

import javax.swing.*;

public class ChatClient
{

	String serverAddress;
	Scanner in;
	PrintWriter out;
	JFrame frame = new JFrame("Chatter");
	JTextField textField = new JTextField(50);
	JTextArea messageArea = new JTextArea(16, 50);

	public ChatClient(String serverAddress)
	{
		this.serverAddress = serverAddress;

		textField.setEditable(false);
		messageArea.setEditable(false);
		frame.getContentPane().add(textField, BorderLayout.SOUTH);
		frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
		frame.pack();

		// Send on enter then clear to prepare for next message
		textField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				out.println(textField.getText());
				textField.setText("");
			}
		});
	}

	private String getName()
	{
		return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void run() throws IOException
	{
		try
		{
			Socket socket = new Socket(serverAddress, 59001);
			in = new Scanner(socket.getInputStream());
			out = new PrintWriter(socket.getOutputStream(), true);

			while (in.hasNextLine())
			{
				String line = in.nextLine();
				if (line.startsWith("SUBMITNAME"))
				{
					out.println(getName());
				} else if (line.startsWith("NAMEACCEPTED"))
				{
					this.frame.setTitle("Chatter - " + line.substring(13));
					textField.setEditable(true);
				} else if (line.startsWith("MESSAGE"))
				{
					messageArea.append(line.substring(8) + "\n");
				}
			}
		} finally
		{
			frame.setVisible(false);
			frame.dispose();
		}
	}

	public static void main(String[] args) throws Exception
	{

		ChatClient client = new ChatClient("127.0.0.1");
		client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.frame.setVisible(true);
		client.run();
	}

}