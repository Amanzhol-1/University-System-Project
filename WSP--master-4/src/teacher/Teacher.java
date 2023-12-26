package teacher;

import java.awt.EventQueue;

import javax.swing.JFrame;

import system.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teacher extends User{

	private JFrame frmTeacher;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Teacher window = new Teacher();
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
	public Teacher(String username, String name, String surname) {
		super(username, name, surname);
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmTeacher = new JFrame();
		frmTeacher.setTitle("Teacher");
		frmTeacher.setBounds(100, 100, 471, 162);
		frmTeacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeacher.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome, " + surname + " " + name);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 361, 50);
		frmTeacher.getContentPane().add(lblNewLabel);
		
		JButton markAttButton = new JButton("Mark attestation");
		markAttButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markAtt();
			}
		});
		markAttButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		markAttButton.setBounds(10, 72, 135, 35);
		frmTeacher.getContentPane().add(markAttButton);
		
		JButton complaintButton = new JButton("Complaint");
		complaintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				complaint();
			}
		});
		complaintButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		complaintButton.setBounds(312, 72, 135, 35);
		frmTeacher.getContentPane().add(complaintButton);
		frmTeacher.setVisible(true);
	}

	@Override
	public void logIn() {
		initialize();
		
	}
	
	protected void markAtt()
	{
		MarkAttestation markAtt = new MarkAttestation();
	}
	protected void complaint()
	{
		Complaint complaint = new Complaint();
	}

}
