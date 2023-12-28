package dean;

import java.awt.EventQueue;

import javax.swing.JFrame;

import system.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dean extends User{

	private JFrame frmDean;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Dean window = new Dean();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Dean(String username, String name, String surname) {
		super(username, name, surname);
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmDean = new JFrame();
		frmDean.setTitle("Dean");
		frmDean.setBounds(100, 100, 514, 192);
		frmDean.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDean.getContentPane().setLayout(null);
		frmDean.setVisible(true);
		
		JLabel welcomeLabel = new JLabel("Welcome, " + surname + " " + name);
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		welcomeLabel.setBounds(10, 11, 462, 48);
		frmDean.getContentPane().add(welcomeLabel);
		
		JButton complainCheckButton = new JButton("Check complaints");
		complainCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkComplaint();
			}
		});
		complainCheckButton.setBounds(150, 89, 200, 48);
		frmDean.getContentPane().add(complainCheckButton);
	}

	@Override
	public void logIn() {
		initialize();
		
	}
	
	protected void checkComplaint()
	{
		CheckComplaint chkCmplt = new CheckComplaint();
	}

}
