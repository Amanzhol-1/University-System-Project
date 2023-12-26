package researcher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collections;
public class ResearchProjectUI {

    private JFrame frame;
    private ResearchProject project;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResearchProjectUI window = new ResearchProjectUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ResearchProjectUI() {
        initialize();
        Researcher researcher = new Researcher();
        researcher.setName("Zoe");

        ResearchPaper paper = new ResearchPaper(1, "Game Research", researcher, 2023, 10, 20);
        ResearchPaper paper1 = new ResearchPaper(2, "Oop Research", researcher, 2019, 17, 23);

        project = new ResearchProject(101, "Research Project 1");

        project.addPaper(paper);
        project.addPaper(paper1);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnProjectId = new JButton("Project ID");
        btnProjectId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Project ID: " + project.getProjectId());

            }
        });
        btnProjectId.setBounds(27, 26, 117, 29);
        frame.getContentPane().add(btnProjectId);

        JButton btnProjectName = new JButton("Project Name");
        btnProjectName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Project Name: " + project.getProjectName());

            }
        });
        btnProjectName.setBounds(27, 65, 117, 29);
        frame.getContentPane().add(btnProjectName);

        JButton btnNumberOfPapers = new JButton("Number of Papers");
        btnNumberOfPapers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Number of Papers: " + project.getNumberOfPapers());

            }
        });
        btnNumberOfPapers.setBounds(27, 104, 176, 29);
        frame.getContentPane().add(btnNumberOfPapers);

        JButton btnGetPapers = new JButton("Get Papers");
        btnGetPapers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                

                StringBuilder papersInfo = new StringBuilder("Papers in the project:\n");

                for (ResearchPaper p : project.getPapers()) {
                    papersInfo.append("Paper ID: ").append(p.getPaperId()).append("\n");
                    papersInfo.append("Paper Title: ").append(p.getTitle()).append("\n");
                    papersInfo.append("Author: ").append(p.getAuthor().getName()).append("\n");
                    papersInfo.append("Publication Year: ").append(p.getPublicationYear()).append("\n");
                    papersInfo.append("Number of Pages: ").append(p.getNumberOfPages()).append("\n");
                    papersInfo.append("Citation Number: ").append(p.getCitationNumber()).append("\n\n");
                }

                JOptionPane.showMessageDialog(frame, papersInfo.toString());
            }
        });
        btnGetPapers.setBounds(27, 143, 176, 29);
        frame.getContentPane().add(btnGetPapers);
        
        JButton btnSortByCitation = new JButton("Sort by Citation");
        btnSortByCitation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(project.getPapers(), new ComparatorByCitation());    
                StringBuilder papersInfo = new StringBuilder("Papers in the project:\n");

                for (ResearchPaper p : project.getPapers()) {
                    papersInfo.append("Paper ID: ").append(p.getPaperId()).append("\n");
                    papersInfo.append("Paper Title: ").append(p.getTitle()).append("\n");
                    papersInfo.append("Author: ").append(p.getAuthor().getName()).append("\n");
                    papersInfo.append("Publication Year: ").append(p.getPublicationYear()).append("\n");
                    papersInfo.append("Number of Pages: ").append(p.getNumberOfPages()).append("\n");
                    papersInfo.append("Citation Number: ").append(p.getCitationNumber()).append("\n\n");
                }

                JOptionPane.showMessageDialog(frame, papersInfo.toString());

            }
        });
        btnSortByCitation.setBounds(27, 182, 176, 29);
        frame.getContentPane().add(btnSortByCitation);
        
        JButton btnSortByDate = new JButton("Sort by Date");
        btnSortByDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(project.getPapers(), new ComparatorByDate());    
                StringBuilder papersInfo = new StringBuilder("Papers in the project:\n");

                for (ResearchPaper p : project.getPapers()) {
                    papersInfo.append("Paper ID: ").append(p.getPaperId()).append("\n");
                    papersInfo.append("Paper Title: ").append(p.getTitle()).append("\n");
                    papersInfo.append("Author: ").append(p.getAuthor().getName()).append("\n");
                    papersInfo.append("Publication Year: ").append(p.getPublicationYear()).append("\n");
                    papersInfo.append("Number of Pages: ").append(p.getNumberOfPages()).append("\n");
                    papersInfo.append("Citation Number: ").append(p.getCitationNumber()).append("\n\n");
                }

                JOptionPane.showMessageDialog(frame, papersInfo.toString());
            }
        });
        btnSortByDate.setBounds(27, 221, 176, 29);
        frame.getContentPane().add(btnSortByDate);

        JButton btnSortByPages = new JButton("Sort by Pages");
        btnSortByPages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(project.getPapers(), new ComparatorByPages());    
                StringBuilder papersInfo = new StringBuilder("Papers in the project:\n");

                for (ResearchPaper p : project.getPapers()) {
                    papersInfo.append("Paper ID: ").append(p.getPaperId()).append("\n");
                    papersInfo.append("Paper Title: ").append(p.getTitle()).append("\n");
                    papersInfo.append("Author: ").append(p.getAuthor().getName()).append("\n");
                    papersInfo.append("Publication Year: ").append(p.getPublicationYear()).append("\n");
                    papersInfo.append("Number of Pages: ").append(p.getNumberOfPages()).append("\n");
                    papersInfo.append("Citation Number: ").append(p.getCitationNumber()).append("\n\n");
                }

                JOptionPane.showMessageDialog(frame, papersInfo.toString());
            }
        });
        btnSortByPages.setBounds(240, 220, 176, 29);
        frame.getContentPane().add(btnSortByPages);
    }
}
