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

public class DeleteUser {

    private JFrame frmDeleteUser;
    private JTextField usernameField;
    private JLabel statusLabel;

    public DeleteUser() {
        initialize();
    }

    private void initialize() {
        frmDeleteUser = new JFrame();
        frmDeleteUser.setTitle("Delete User");
        frmDeleteUser.setBounds(100, 100, 384, 243);
        frmDeleteUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDeleteUser.getContentPane().setLayout(null);
        frmDeleteUser.setVisible(true);

        JLabel UsernameLabel = new JLabel("Username");
        UsernameLabel.setBounds(107, 53, 71, 14);
        frmDeleteUser.getContentPane().add(UsernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(171, 50, 96, 20);
        frmDeleteUser.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DatabaseUtils.connectToDB();
                    String sql = "DELETE FROM users WHERE username = (?)";
                    PreparedStatement query = con.prepareStatement(sql);
                    query.setString(1, usernameField.getText());
                    query.executeUpdate();

                    statusLabel.setText("Deleting was successful");
                    Admin.createLogFile("Event_Delete",usernameField.getText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                    statusLabel.setText("Deleting failed");
                }
            }
        });
        btnDelete.setBounds(140, 119, 89, 23);
        frmDeleteUser.getContentPane().add(btnDelete);

        statusLabel = new JLabel("Status");
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBounds(10, 11, 349, 14);
        frmDeleteUser.getContentPane().add(statusLabel);
    }
}

