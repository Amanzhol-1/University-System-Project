package dean;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import system.DatabaseUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CheckComplaint {

	private JFrame frmCheckComplaints;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CheckComplaint window = new CheckComplaint();
//					window.frmCheckComplaints.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public CheckComplaint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckComplaints = new JFrame();
		frmCheckComplaints.setTitle("Check Complaints");
		frmCheckComplaints.setBounds(100, 100, 560, 370);
		frmCheckComplaints.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckComplaints.getContentPane().setLayout(null);
		frmCheckComplaints.setVisible(true);
		
		table = new JTable();
		table.setBounds(10, 105, 526, 217);
		frmCheckComplaints.getContentPane().add(table);
		
		model = new DefaultTableModel();
        table.setModel(model);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateButton.setBounds(213, 54, 119, 40);
		frmCheckComplaints.getContentPane().add(updateButton);
		
		JLabel descLabel = new JLabel("Complaints");
		descLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		descLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descLabel.setBounds(173, 0, 200, 65);
		frmCheckComplaints.getContentPane().add(descLabel);
	}
	
	private void updateTable()
	{
		try {
			Connection connection = DatabaseUtils.connectToDB();
			String sqlQuery = "SELECT * FROM complaints";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
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
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
