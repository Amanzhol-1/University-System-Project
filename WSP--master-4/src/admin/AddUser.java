package admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import enums.UserType;

import system.DatabaseUtils; 

public class AddUser {

    private JFrame frmAddUser;
    private JTextField nameField;
    private JTextField surnameField;
    private JButton btnAddUser;
    private JLabel statusLabel;

    public AddUser() {
        initialize();
    }

    public String passwordGenerator() {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%^&*()_+";
        String combination = upperCase + lowerCase + numbers + special;
        int len = 8;
        char[] password = new char[len];
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }

    private void initialize() { 
        frmAddUser = new JFrame();
        frmAddUser.setTitle("Add User");
        frmAddUser.setBounds(100, 100, 592, 433);
        frmAddUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAddUser.getContentPane().setLayout(null);
        frmAddUser.setVisible(true);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameLabel.setBounds(10, 98, 60, 14);
        frmAddUser.getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setHorizontalAlignment(SwingConstants.LEFT);
        nameField.setBounds(52, 97, 119, 20);
        frmAddUser.getContentPane().add(nameField);
        nameField.setColumns(10);

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        surnameLabel.setBounds(193, 98, 60, 14);
        frmAddUser.getContentPane().add(surnameLabel);

        surnameField = new JTextField();
        surnameField.setHorizontalAlignment(SwingConstants.LEFT);
        surnameField.setColumns(10);
        surnameField.setBounds(254, 97, 119, 20);
        frmAddUser.getContentPane().add(surnameField);

        JComboBox<UserType> userType = new JComboBox<UserType>(UserType.values());
        userType.setBounds(411, 96, 133, 22);
        frmAddUser.getContentPane().add(userType);

        btnAddUser = new JButton("Add user");
        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DatabaseUtils.connectToDB();
                    String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement query = con.prepareStatement(sql);
                    query.setString(1, (nameField.getText().charAt(0) + "_" + surnameField.getText()).toLowerCase());
                    query.setString(2, passwordGenerator());
                    query.setObject(3, userType.getSelectedItem(), Types.OTHER);
                    query.setString(4, nameField.getText());
                    query.setString(5, surnameField.getText());

                    query.executeUpdate();
                    Admin.createLogFile("Event_Add",(nameField.getText().charAt(0) + "_" + surnameField.getText()));
                    statusLabel.setText("Success");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    statusLabel.setText("Fail");
                }
            } 
        });
        btnAddUser.setFocusable(false);
        btnAddUser.setForeground(new Color(255, 255, 255));
        btnAddUser.setBackground(new Color(0, 0, 128));
        btnAddUser.setBounds(244, 202, 89, 23);
        frmAddUser.getContentPane().add(btnAddUser);

        statusLabel = new JLabel("STATUS");
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBounds(220, 255, 138, 42);
        frmAddUser.getContentPane().add(statusLabel);
    }
}

