package system;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import admin.Admin;
import system.DatabaseUtils; 

public class LoginPage { 
 
    private JFrame frmWsp;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel msgLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage window = new LoginPage();
                    window.frmWsp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    } 

    public LoginPage() {
        initialize();
    }

    private void initialize() {
        frmWsp = new JFrame();
        frmWsp.setTitle("Wsp");
        frmWsp.setBounds(100, 100, 680, 402);
        frmWsp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmWsp.getContentPane().setLayout(null);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(0, 0, 255));
        btnLogin.setFocusable(false);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()) {
                    msgLabel.setText("All fields must be filled");
                    return;
                }

                try {
                    Connection con = DatabaseUtils.connectToDB();
                    String sql = "SELECT * FROM users WHERE username = (?)";
                    PreparedStatement query = con.prepareStatement(sql);
                    query.setString(1, usernameField.getText().toLowerCase());
                    ResultSet result = query.executeQuery();
                    if (result.next()) {
                        if (String.valueOf(passwordField.getPassword()).equals(result.getString("password"))) {
                            UserManager.login(usernameField.getText(), result.getString("name"), result.getString("surname"), result.getString("user_type").toLowerCase());
                            frmWsp.dispose();
                        } else {
                            msgLabel.setText("Invalid password");
                        }
                    } else {
                        msgLabel.setText("Invalid username");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();  
                }
            }
        });
        btnLogin.setBounds(288, 295, 89, 23);
        frmWsp.getContentPane().add(btnLogin);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(163, 97, 82, 14);
        frmWsp.getContentPane().add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(163, 147, 65, 14);
        frmWsp.getContentPane().add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(255, 94, 189, 20);
        frmWsp.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField(); 
        passwordField.setBounds(255, 144, 189, 20);
        frmWsp.getContentPane().add(passwordField);

        msgLabel = new JLabel("");
        msgLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        msgLabel.setBounds(149, 31, 367, 31);
        frmWsp.getContentPane().add(msgLabel);
    }
}

