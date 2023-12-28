package admin;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import system.DatabaseUtils; 

public class UpdateUser {

    private JFrame frmUpdateUser;
    private JTextField usernameField;
    private JTextField passwordField;
    private JLabel statusLabel;

    public UpdateUser() {
        initialize();
    }

    private void initialize() {
        frmUpdateUser = new JFrame();
        frmUpdateUser.setTitle("Update User");
        frmUpdateUser.setBounds(100, 100, 713, 155);
        frmUpdateUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmUpdateUser.getContentPane().setLayout(null);
        frmUpdateUser.setVisible(true);
        
        JLabel UsernameLabel = new JLabel("Username");
        UsernameLabel.setBounds(26, 28, 74, 14);
        frmUpdateUser.getContentPane().add(UsernameLabel);
        
        usernameField = new JTextField();
        usernameField.setBounds(90, 25, 116, 20);
        frmUpdateUser.getContentPane().add(usernameField);
        usernameField.setColumns(10);
        
        JLabel PasswordLabel = new JLabel("New password");
        PasswordLabel.setBounds(231, 29, 110, 14);
        frmUpdateUser.getContentPane().add(PasswordLabel);
        
        passwordField = new JTextField();
        passwordField.setBounds(331, 26, 116, 20);
        frmUpdateUser.getContentPane().add(passwordField);
        passwordField.setColumns(10);
        
        JButton btnChange = new JButton("Change");
        btnChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DatabaseUtils.connectToDB();
                    String sql = "UPDATE users SET password = (?) WHERE username = (?)";
                    PreparedStatement query = con.prepareStatement(sql);
                    query.setString(1, passwordField.getText());
                    query.setString(2, usernameField.getText());
                    query.executeUpdate();
                    
                    
                    Admin.createLogFile("Event_Update",usernameField.getText());
                    statusLabel.setText("Changing was successful");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    statusLabel.setText("Changing failed");
                }
            }
        });
        btnChange.setBounds(517, 25, 89, 23);
        frmUpdateUser.getContentPane().add(btnChange);
        
        statusLabel = new JLabel("STATUS");
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBounds(185, 72, 328, 14);
        frmUpdateUser.getContentPane().add(statusLabel);
    }
}

