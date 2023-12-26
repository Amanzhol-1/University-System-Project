package gpt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Создаем JTabbedPane
        tabbedPane = new JTabbedPane();

        // Создаем панель для вкладки
        JPanel loginPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
        loginPanel.add(loginButton);

        // Добавляем вкладку с панелью для входа
        tabbedPane.addTab("Login", loginPanel);

        // Добавляем JTabbedPane в JFrame
        add(tabbedPane);

        setLocationRelativeTo(null);
    }

    private void onLogin() {
        // После успешного логина добавляем новую вкладку
        JPanel loggedInPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome!");
        loggedInPanel.add(welcomeLabel);

        tabbedPane.addTab("LoggedIn", loggedInPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
