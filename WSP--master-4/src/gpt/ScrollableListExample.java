package gpt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollableListExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Scrollable List Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Пример данных для списка
            String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            // Создание JList
            JList<String> list = new JList<>(data);

            // Оборачивание JList в JScrollPane
            JScrollPane scrollPane = new JScrollPane(list);

            // Создание кнопки для вызова выдвижения списка
            JButton showListButton = new JButton("Show List");
            showListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, scrollPane, "List", JOptionPane.PLAIN_MESSAGE);
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
