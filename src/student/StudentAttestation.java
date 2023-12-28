package student;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.DatabaseUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StudentAttestation {

	private JFrame frmAttestation;
	private JTable attTable;
	
	private String studentName;
	private String studentSurname;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Attestation window = new Attestation();
//					window.frmAttestation.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public StudentAttestation(String name, String surname){
		this.studentName = name;
		this.studentSurname = surname;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAttestation = new JFrame();
		frmAttestation.setTitle("Attestation");
		frmAttestation.setBounds(100, 100, 575, 185);
		frmAttestation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAttestation.getContentPane().setLayout(null);
		frmAttestation.setVisible(true);
		
		attTable = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
		attTable.setModel(model);
		
		attTable.setBounds(49, 92, 463, 40);
		frmAttestation.getContentPane().add(attTable);
		
		JButton viewButton = new JButton("View");
		viewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable(model);
			}
		});
		viewButton.setBounds(209, 41, 142, 40);
		frmAttestation.getContentPane().add(viewButton);
	}
	
	private void fillTable(DefaultTableModel model) {
	    Connection connection = null;
	    try {
	        connection = DatabaseUtils.connectToDB();
	        String sqlQuery = "SELECT type, grade FROM attestation WHERE name = ? AND surname = ?;";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
	            preparedStatement.setString(1, studentName);
	            preparedStatement.setString(2, studentSurname);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                int columnCount = resultSet.getMetaData().getColumnCount();
	                for (int i = 1; i <= columnCount; i++) {
	                    model.addColumn(resultSet.getMetaData().getColumnName(i));
	                }

	                while (resultSet.next()) {
	                    Object[] row = new Object[columnCount];
	                    for (int i = 1; i <= columnCount; i++) {
	                        row[i - 1] = resultSet.getObject(i);
	                    }
	                    model.addRow(row);
	                }
	            }
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

}

