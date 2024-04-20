package Gk2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;

public class ManagerChatter extends JFrame implements Runnable{
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServerPort;
	
	ServerSocket srvSocket = null;
	BufferedReader bf = null;
	Thread t;
	private JTabbedPane tabbedPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerChatter frame = new ManagerChatter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerChatter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel mngPort = new JLabel("Port:   ");
		mngPort.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(mngPort);
		
		txtServerPort = new JTextField();
		txtServerPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtServerPort.setText("2024");
		panel.add(txtServerPort);
		txtServerPort.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		
		this.setSize(600, 300);
		int serverPort = Integer.parseInt(txtServerPort.getText());
		try {
			srvSocket = new ServerSocket(serverPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		t = new Thread(this);
		t.start();
		
	}
	
	public void run() {
		while(true) {
			try {
				Socket astaffSocket = srvSocket.accept();
				if(astaffSocket != null) {
					bf = new BufferedReader(new InputStreamReader(astaffSocket.getInputStream()));
					String S = bf.readLine();
					int pos = S.indexOf(":");
					String staffName = S.substring(pos + 1);
					Chatpanel p = new Chatpanel(astaffSocket, "Manager", staffName);
					tabbedPane.add(staffName, p);
					p.updateUI();
					
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
