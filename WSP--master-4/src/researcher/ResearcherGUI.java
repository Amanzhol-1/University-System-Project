package researcher;
import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;

public class ResearcherGUI {

    private JFrame frame;
    private Researcher researcher;

    public ResearcherGUI(Researcher researcher) {
        this.researcher = researcher;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnName = new JButton("Name");
        btnName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display the researcher's name
                JOptionPane.showMessageDialog(frame, "Researcher's Name: " + researcher.getName());
            }
        });
        btnName.setBounds(30, 30, 150, 30);
        frame.getContentPane().add(btnName);

        JButton btnPaper = new JButton("Paper");
        btnPaper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display paper details
                List<ResearchPaper> paper = researcher.getPaper();
                if (paper != null) {
                    JOptionPane.showMessageDialog(frame, "Paper Title: " + paper.getTitle());
                    // Add more details as needed
                } else {
                    JOptionPane.showMessageDialog(frame, "No paper available for this researcher.");
                }
            }
        });
        btnPaper.setBounds(30, 80, 150, 30);
        frame.getContentPane().add(btnPaper);

        JButton btnProject = new JButton("Project");
        btnProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display project details
                ResearchProject project = researcher.getProject();
                if (project != null) {
                    JOptionPane.showMessageDialog(frame, "Project Name: " + project.getProjectName());
                    // Add more details as needed
                } else {
                    JOptionPane.showMessageDialog(frame, "No project available for this researcher.");
                }
            }
        });
        btnProject.setBounds(30, 130, 150, 30);
        frame.getContentPane().add(btnProject);

        JButton btnPrintPapers = new JButton("Print Papers");
        btnPrintPapers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comparator<ResearchPaper> comparatorByCitation = new ComparatorByCitation();
                Comparator<ResearchPaper> comparatorByDate = new ComparatorByDate();
                Comparator<ResearchPaper> comparatorByPages = new ComparatorByPages();

                ResearchProject project = researcher.getProject();

                if (project != null) {
                    String result = researcher.printPapers(project, comparatorByCitation)
                            + researcher.printPapers(project, comparatorByDate)
                            + researcher.printPapers(project, comparatorByPages);

                    JOptionPane.showMessageDialog(frame, result);
                } else {
                    JOptionPane.showMessageDialog(frame, "No project available for this researcher.");
                }
            }
        });
        btnPrintPapers.setBounds(30, 180, 150, 30);
        frame.getContentPane().add(btnPrintPapers);
        JButton btnAddProject = new JButton("Add Project");
        btnAddProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int projectId = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Project ID:"));
                String projectName = JOptionPane.showInputDialog(frame, "Enter Project Name:");
                //ResearchProject newProject = new ResearchProject(projectId, projectName);
                researcher.addProject(projectId, projectName);
                JOptionPane.showMessageDialog(frame, "Project added successfully.");
            }
        });
        btnAddProject.setBounds(200, 30, 150, 30);
        frame.getContentPane().add(btnAddProject);

        JButton btnAddPaper = new JButton("Add Paper");
        btnAddPaper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int paperid = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Paper ID:"));
                String paperTitle = JOptionPane.showInputDialog(frame, "Enter Paper Title:");
            	int publicationYear = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter publicationYear:"));
            	int numberOfPages = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter numberOfPages:"));
            	int citationNumber = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter citationNumber:"));

                ResearchPaper newPaper = new ResearchPaper(paperid, paperTitle, researcher, publicationYear, numberOfPages, citationNumber);
                newPaper.setAuthor(researcher);
                newPaper.setTitle(paperTitle);
                newPaper.setCitationNumber(citationNumber);
                newPaper.setNumberOfPages(numberOfPages);
                newPaper.setPaperId(paperid);
                newPaper.setPublicationYear(publicationYear);

                ResearchProject currentProject = researcher.getProject();
                if (currentProject != null) {
                    researcher.addPaper(currentProject, newPaper);
                    JOptionPane.showMessageDialog(frame, "Paper added successfully to the current project.");
                } else {
                    JOptionPane.showMessageDialog(frame, "No project available to add paper to.");
                }
            }
        });
        btnAddPaper.setBounds(200, 80, 150, 30);
        frame.getContentPane().add(btnAddPaper);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Researcher researcher = new Researcher();
                    researcher.setName("John Doe");
                    ResearchPaper paper1 = new ResearchPaper(1, "Ooop research", researcher, 2020, 9, 20);
                    ResearchPaper paper2 = new ResearchPaper(2, "game research", researcher, 2023, 12, 5);
                    
                    researcher.setPaper(paper1);
                    researcher.setPaper(paper2);
                    
                    ResearchProject project = new ResearchProject(101, "Oop Project");
                    
                    project.addPaper(paper1);
                    project.addPaper(paper2);
                    researcher.setProject(project);
                    

                    ResearcherGUI window = new ResearcherGUI(researcher);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            } 
        });
    }
}