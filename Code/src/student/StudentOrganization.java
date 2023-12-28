package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class StudentOrganization {

	JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentOrganization window = new StudentOrganization();
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
	public StudentOrganization() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 29));
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Organizations");
		lblNewLabel.setBounds(194, 49, 429, 111);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 34));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Members");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton.setBounds(95, 288, 150, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leave From Organization");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton_1.setBounds(541, 288, 218, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Organization News");
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton_2.setBounds(293, 288, 206, 50);
		frame.getContentPane().add(btnNewButton_2);
	}
	
	 public void setVisible(boolean visible) {
	        frame.setVisible(visible);
	    }
}
