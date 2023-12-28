package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import system.User;
import system.isEmployee;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Admin extends User implements isEmployee{

	private JFrame adminFrame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Admin window = new Admin();
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
	public Admin(String username, String name, String surname) {
		super(username, name, surname);
//		logIn();

	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminFrame = new JFrame();
		adminFrame.setTitle("Admin");
		adminFrame.setBounds(100, 100, 634, 479);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.getContentPane().setLayout(null);
		adminFrame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Hello, " + surname + " " + name );
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 295, 14);
		adminFrame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add user");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		btnNewButton.setBounds(10, 62, 124, 42);
		adminFrame.getContentPane().add(btnNewButton);
		
		JButton btnUpdateUser = new JButton("Update user");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUser();
			} 
		});
		btnUpdateUser.setBounds(248, 62, 124, 42);
		adminFrame.getContentPane().add(btnUpdateUser);
		
		JButton btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser();
			}
		});
		btnDeleteUser.setBounds(486, 62, 124, 42);
		adminFrame.getContentPane().add(btnDeleteUser);
	}

	@Override
	public void logIn() {
		
		initialize();
		
	}
	
	protected void addUser()
	{
		AddUser addUser = new AddUser();
	}
	
	protected void updateUser()
	{
		UpdateUser updateUser = new UpdateUser();
	}
	
	protected void deleteUser()
	{
		DeleteUser deleteUser = new DeleteUser();
	}

	
	protected static void createLogFile(String eventName, String newUser)
	{
		LocalDateTime current = LocalDateTime.now();
		String currentDate =  current.toString();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fileName = eventName + "_" + current.format(formatter) + ".txt";
		try {
            
            File logDirectory = new File("C:\\Users\\Arlan\\eclipse-workspace\\WSP--master\\src\\logFiles");
            if (!logDirectory.exists()) {
                logDirectory.mkdirs();
            }
            File logfile = new File(logDirectory, fileName);
            if (logfile.createNewFile())
            {
            	FileWriter writer = new FileWriter(logfile);
            	writer.write("currentDate" + ": " + eventName + newUser);
            	writer.close();
//                System.out.println("File created");
            }
            else {
                throw new FileExistsException("File already exists");
            }
        }
        catch (Exception e) {
        	
            System.err.println(e);
        }
		
	}
	
	private static String updateFileName(String fileName) {
        return fileName.replaceAll(" [\\\\/:*?\"<>|]", "");
    }
	
	public static class FileExistsException extends Exception {
		public FileExistsException(String message) {
	        super(message);
	    }
	}

	
	@Override
	public void sendMessage(String username) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void checkEmail() {
		// TODO Auto-generated method stub
		
	}
}
