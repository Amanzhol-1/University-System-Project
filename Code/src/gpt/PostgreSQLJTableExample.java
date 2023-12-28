package gpt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLJTableExample {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/Wsp_Database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Stebster";

    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        JTable table = new JTable();

        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);

        // Заполняем таблицу данными из базы данных
        fillTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void fillTable(DefaultTableModel model) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Выполняем SQL-запрос для выборки данных из таблицы
            String sqlQuery = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Добавляем заголовки столбцов
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(resultSet.getMetaData().getColumnName(i));
                }

                // Добавляем данные из таблицы
                while (resultSet.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = resultSet.getObject(i);
                    }
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Закрываем соединение
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
