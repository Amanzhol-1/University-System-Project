package student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

public class StudentAddDrop {

    JFrame frame;
    private List<String> availableCourses; 
    private List<String> enrolledCourses;

    public StudentAddDrop() {
        availableCourses = new ArrayList<>();
        enrolledCourses = new ArrayList<>();

        availableCourses.add("OOP");
        availableCourses.add("Calculus I");
        availableCourses.add("Linear Algebra");
        availableCourses.add("ADS");
        availableCourses.add("Research Methods");

        initialize();
    } 

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComboBox<String> comboBoxCourses = new JComboBox<>();
        comboBoxCourses.setBounds(40, 123, 160, 20);
        for (String course : availableCourses) {
            comboBoxCourses.addItem(course);
        }
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(comboBoxCourses);

        JButton btnEnroll = new JButton("Add");
        btnEnroll.setBounds(249, 122, 89, 23);
        btnEnroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) comboBoxCourses.getSelectedItem();
                if (!enrolledCourses.contains(selectedCourse)) {
                    enrolledCourses.add(selectedCourse);
                    StudentSchedule.addCourse(selectedCourse);
                }
            }
        });
        frame.getContentPane().add(btnEnroll);

        JButton btnDrop = new JButton("Drop");
        btnDrop.setBounds(366, 122, 89, 23);
        btnDrop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) comboBoxCourses.getSelectedItem();
                if (enrolledCourses.contains(selectedCourse)) {
                    enrolledCourses.remove(selectedCourse);
                    StudentSchedule.removeCourse(selectedCourse); 
                }
            } 
        });
        frame.getContentPane().add(btnDrop);
        
        JLabel lblNewLabel = new JLabel("ADD/DROP ");
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
        lblNewLabel.setBounds(200, 6, 123, 35);
        frame.getContentPane().add(lblNewLabel);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
