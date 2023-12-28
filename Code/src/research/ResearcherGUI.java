package research;
import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ResearcherGUI {

    private JFrame frame;
    private Researcher researcher;

    public ResearcherGUI(Researcher researcher) {
        this.researcher = researcher;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 390, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnName = new JButton("Name");
        btnName.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display the researcher's name
                JOptionPane.showMessageDialog(frame, "Researcher's Name: " + researcher.getName());
            }
        });
        btnName.setBounds(30, 30, 150, 30);
        frame.getContentPane().add(btnName);

        JButton btnPaper = new JButton("Paper");
        btnPaper.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnPaper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder paperss = new StringBuilder("Papers:\n");

                List<ResearchPaper> papers = researcher.getPaper();
            	for(ResearchPaper p : papers) {
                    if (p != null) {
                        paperss.append(p.getTitle()).append("\n");

                    } else {
                        JOptionPane.showMessageDialog(frame, "No paper available for this researcher.");
                    }
            	}
                JOptionPane.showMessageDialog(frame, paperss.toString());            	


            }
        });
        btnPaper.setBounds(30, 80, 150, 30);
        frame.getContentPane().add(btnPaper);

        JButton btnProject = new JButton("Project");
        btnProject.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder projects = new StringBuilder("Projects:\n");

                List<ResearchProject> ps = researcher.allProject();
            	for(ResearchProject p : ps) {
                    if (p != null) {
                        projects.append(p.getProjectName()).append("\n");

                    } else {
                        JOptionPane.showMessageDialog(frame, "No paper available for this researcher.");
                    }
            	}
                JOptionPane.showMessageDialog(frame, projects.toString());            	
                
            }
        });
        btnProject.setBounds(30, 130, 150, 30);
        frame.getContentPane().add(btnProject);

        JButton btnPrintPapers = new JButton("Print Papers");
        btnPrintPapers.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnPrintPapers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	List<ResearchPaper> papers = researcher.getPaper();

                StringBuilder result = new StringBuilder();
                result.append("Papers:").append("\n");

                for (ResearchPaper paper : papers) {
                    result.append("Paper ID: ").append(paper.getPaperId())
                          .append(", Paper Title: ").append(paper.getTitle())
                          .append(", Author: ").append(paper.getAuthor().getName())
                          .append(", Publication Year: ").append(paper.getPublicationYear())
                          .append(", Number of Pages: ").append(paper.getNumberOfPages())
                          .append(", Citation Number: ").append(paper.getCitationNumber())
                          .append("\n");
                }

                JOptionPane.showMessageDialog(frame, result.toString());            	
                
            }
        });
        btnPrintPapers.setBounds(30, 180, 150, 30);
        frame.getContentPane().add(btnPrintPapers);
        JButton btnAddProject = new JButton("Add Project");
        btnAddProject.setFont(new Font("Arial Black", Font.PLAIN, 13));
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
        btnAddPaper.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnAddPaper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	int paperid = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Paper ID:"));
                String paperTitle = JOptionPane.showInputDialog(frame, "Enter Paper Title:");
            	int publicationYear = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter publicationYear:"));
            	int numberOfPages = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter numberOfPages:"));
            	int citationNumber = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter citationNumber:"));
            	
                int projectId = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Project ID:"));
                String projectName = JOptionPane.showInputDialog(frame, "Enter Project Name:");
                ResearchProject project =  new ResearchProject(projectId, projectName);
                ResearchPaper newPaper = new ResearchPaper(paperid, paperTitle, researcher, publicationYear, numberOfPages, citationNumber);
                newPaper.setAuthor(researcher);
                newPaper.setTitle(paperTitle);
                newPaper.setCitationNumber(citationNumber);
                newPaper.setNumberOfPages(numberOfPages);
                newPaper.setPaperId(paperid);
                newPaper.setPublicationYear(publicationYear);

                ResearchProject currentProject = researcher.getProject(project);
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
        
        JButton btnNewButton = new JButton("Manage Project");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		researchProject();
        	}
        });
        btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnNewButton.setBounds(200, 132, 150, 28);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Manage Papers");
        btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		managePapers();
        	}
        });
        btnNewButton_1.setBounds(200, 182, 150, 28);
        frame.getContentPane().add(btnNewButton_1);
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
    
    public void managePapers() {
    	ResearchPaperUI managePapers = new ResearchPaperUI();
    	managePapers.setVisible(true);
    }
    
    public void researchProject() {
    	ResearchProjectUI researchProject = new ResearchProjectUI();
    	researchProject.setVisible(true);
    }
}