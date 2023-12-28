package gpt;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleSelectionListExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Single Selection List Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Пример данных для списка
            String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            // Создание JList с одиночным выбором
            JList<String> list = new JList<>(data);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // Создание кнопки для отображения выбранного элемента
            JButton showSelectedButton = new JButton("Show Selected Item");
            showSelectedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Получение выбранного элемента
                    String selectedValue = list.getSelectedValue();
                    if (selectedValue != null) {
                        JOptionPane.showMessageDialog(frame, "Selected Item: " + selectedValue);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No item selected");
                    }
                }
            });

            // Создание панели для размещения компонентов
            JPanel panel = new JPanel();
            panel.add(new JScrollPane(list));
            panel.add(showSelectedButton);

            // Добавление панели в окно
            frame.getContentPane().add(panel);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}