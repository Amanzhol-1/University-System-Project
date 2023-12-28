package student;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StudentSchedule {

    private static List<String> scheduledCourses = new ArrayList<>();
    private JFrame frame;

    public StudentSchedule() {
        initialize(); 
    } 

    private void initialize() {
        frame = new JFrame("Student Schedule");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        updateScheduleDisplay();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    private void updateScheduleDisplay() {
    	System.out.print(scheduledCourses.size());
        StringBuilder sb = new StringBuilder("<html>");
        for (String course : scheduledCourses) {
            sb.append(course).append("<br>");
        }
        sb.append("</html>");

        JLabel lblCourses = new JLabel(sb.toString());
        lblCourses.setBounds(10, 10, 480, 280);
        frame.getContentPane().add(lblCourses);
    }

    public static void addCourse(String course) {
        scheduledCourses.add(course);
    }

    public static void removeCourse(String course) {
        scheduledCourses.remove(course);
    }
}
