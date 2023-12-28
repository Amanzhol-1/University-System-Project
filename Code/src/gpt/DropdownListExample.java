package gpt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownListExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dropdown List Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Пример данных для списка
            String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            // Создание JComboBox
            JComboBox<String> comboBox = new JComboBox<>(data);

            // Создание кнопки для отображения выпадающего списка
            JButton showListButton = new JButton("Show List");
            showListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, comboBox, "List", JOptionPane.PLAIN_MESSAGE);
                }
            });

            // Создание панели для размещения компонентов
            JPanel panel = new JPanel();
            panel.add(showListButton);

            // Добавление панели в окно
            frame.getContentPane().add(panel);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
