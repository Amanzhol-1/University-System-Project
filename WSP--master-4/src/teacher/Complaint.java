package teacher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import enums.ComplaintLevel;
import system.DatabaseUtils;
import system.UserManager;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Complaint {

	private JFrame frmComplain;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField descField;
	private JComboBox complaintBox;
	private JLabel descLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Complaint window = new Complaint();
//					window.frmComplain.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Complaint() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmComplain = new JFrame();
		frmComplain.setTitle("Complain");
		frmComplain.setBounds(100, 100, 441, 238);
		frmComplain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmComplain.getContentPane().setLayout(null);
		frmComplain.setVisible(true);
		
		
		JLabel nameLabel = new JLabel("Student name");
		nameLabel.setBounds(10, 56, 140, 14);
		frmComplain.getContentPane().add(nameLabel);
		
		JLabel surnameLabel = new JLabel("Student surname");
		surnameLabel.setBounds(10, 81, 140, 14);
		frmComplain.getContentPane().add(surnameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(141, 56, 140, 20);
		frmComplain.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(141, 81, 140, 20);
		frmComplain.getContentPane().add(surnameField);
		
		complaintBox = new JComboBox(ComplaintLevel.values());
		complaintBox.setBounds(141, 109, 77, 22);
		frmComplain.getContentPane().add(complaintBox);
		
		JLabel complaintLvlLabel = new JLabel("Complaint level");
		complaintLvlLabel.setBounds(10, 109, 140, 14);
		frmComplain.getContentPane().add(complaintLvlLabel);
		
		JLabel statusLabel = new JLabel("STATUS");
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBounds(68, 11, 291, 14);
		frmComplain.getContentPane().add(statusLabel);
		
		JButton complainButton = new JButton("Complain");
		complainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Connection con = DatabaseUtils.connectToDB();
                    String sql = descField.getText().isEmpty() ? "INSERT INTO complaints (name, surname, complaint_lvl) VALUES(?, ?, ?);" : "INSERT INTO complaints (name, surname, complaint_lvl, description) VALUES(?, ?, ?, ?);";
                    PreparedStatement query = con.prepareStatement(sql);
                    query.setString(1, nameField.getText());
                    query.setString(2, surnameField.getText());
                    query.setString(3, complaintBox.getSelectedItem().toString());
                    if(!descField.getText().isEmpty()) query.setString(4, descField.getText());
                    query.executeUpdate();
                    statusLabel.setText("DONE");
                } catch (Exception e1) {
                	statusLabel.setText("FAILED");
                    e1.printStackTrace();  
                }
			}
		});
		complainButton.setBackground(new Color(0, 0, 255));
		complainButton.setForeground(new Color(255, 255, 255));
		complainButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		complainButton.setBounds(303, 52, 118, 65);
		frmComplain.getContentPane().add(complainButton);
		
		descLabel = new JLabel("Description (optional)");
		descLabel.setBounds(10, 142, 231, 14);
		frmComplain.getContentPane().add(descLabel);
		
		descField = new JTextField();
		descField.setHorizontalAlignment(SwingConstants.LEFT);
		descField.setColumns(10);
		descField.setBounds(141, 142, 276, 20);
		frmComplain.getContentPane().add(descField);
	}
}
