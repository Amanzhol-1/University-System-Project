package teacher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import enums.AttestationType;
import system.DatabaseUtils;
import system.User;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MarkAttestation{

	private JFrame frmTeacher;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField markField;
	private JComboBox attTypeBox;
	private JLabel statusLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Teacher window = new Teacher();
//					window.frmTeacher.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	
	public MarkAttestation() {
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		/**
		 * @wbp.parser.entryPoint
		 */
		frmTeacher = new JFrame();
		frmTeacher.setTitle("Teacher");
		frmTeacher.setBounds(100, 100, 285, 259);
		frmTeacher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTeacher.getContentPane().setLayout(null);
		frmTeacher.setVisible(true);
		
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(21, 52, 123, 14);
		frmTeacher.getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(101, 49, 140, 20);
		frmTeacher.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(21, 72, 123, 14);
		frmTeacher.getContentPane().add(surnameLabel);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(101, 72, 140, 20);
		frmTeacher.getContentPane().add(surnameField);
		
		attTypeBox = new JComboBox(AttestationType.values());
		attTypeBox.setBounds(101, 95, 103, 22);
		frmTeacher.getContentPane().add(attTypeBox);
		
		JLabel attTypeLabel = new JLabel("Attestation");
		attTypeLabel.setBounds(21, 99, 111, 14);
		frmTeacher.getContentPane().add(attTypeLabel);
		
		markField = new JTextField();
		markField.setBounds(101, 138, 27, 20);
		frmTeacher.getContentPane().add(markField);
		markField.setColumns(10);
		((AbstractDocument) markField.getDocument()).setDocumentFilter(new NumericFilter());
		
		JLabel markLabel = new JLabel("Mark");
		markLabel.setBounds(21, 141, 49, 14);
		frmTeacher.getContentPane().add(markLabel);
		
		JButton gradeButton = new JButton("Grade");
		gradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				grade();
				statusLabel.setText("Operation done");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				statusLabel.setText("Operation failed");
			}
			}
		});
		gradeButton.setBackground(new Color(0, 0, 255));
		gradeButton.setForeground(new Color(255, 255, 255));
		gradeButton.setBounds(91, 187, 89, 23);
		frmTeacher.getContentPane().add(gradeButton);
		
		statusLabel = new JLabel("STATUS");
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBounds(33, 11, 205, 14);
		frmTeacher.getContentPane().add(statusLabel);
	}
	protected void grade() throws ClassNotFoundException, SQLException
	{
		Connection con = DatabaseUtils.connectToDB();
		String sql = "INSERT INTO attestation VALUES (?, ?, ?, ?);";
        PreparedStatement query = con.prepareStatement(sql);
        query.setString(1, nameField.getText());
        query.setString(2, surnameField.getText());
        query.setString(3, attTypeBox.getSelectedItem().toString());
        query.setFloat(4, Float.parseFloat(markField.getText()));
        query.executeUpdate();
	}
	
//	@Override
//	public void logIn() {
//		initialize();
//		
//	}
	
	static class NumericFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("[0-9]+") || string.equals(".")) {
                super.insertString(fb, offset, string, attr);
            }
        }
 
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("[0-9]+") || text.equals(".")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
