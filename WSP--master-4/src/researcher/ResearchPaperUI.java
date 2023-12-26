package researcher;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResearchPaperUI {

    private JFrame frame;
    private ResearchPaper paper;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResearchPaperUI window = new ResearchPaperUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ResearchPaperUI() {
        initialize();
        Researcher researcher = new Researcher();
        researcher.setName("Zoe");
        paper = new ResearchPaper(1, "Game Research", researcher, 2023, 10, 20);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnPaperId = new JButton("Paper ID");
        btnPaperId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Paper ID: " + paper.getPaperId());

            }
        });
        btnPaperId.setBounds(27, 26, 117, 29);
        frame.getContentPane().add(btnPaperId);

        JButton btnTitle = new JButton("Title");
        btnTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Title: " + paper.getTitle());

            }
        });
        btnTitle.setBounds(27, 65, 117, 29);
        frame.getContentPane().add(btnTitle);

        JButton btnAuthor = new JButton("Author");
        btnAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Author: " + paper.getAuthor().getName());

            }
        });
        btnAuthor.setBounds(27, 104, 117, 29);
        frame.getContentPane().add(btnAuthor);

        JButton btnPublicationYear = new JButton("Publication Year");
        btnPublicationYear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Publication Year: " + paper.getPublicationYear());

            }
        });
        btnPublicationYear.setBounds(27, 143, 176, 29);
        frame.getContentPane().add(btnPublicationYear);

        JButton btnNumberOfPages = new JButton("Number of Pages");
        btnNumberOfPages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Number of Pages: " + paper.getNumberOfPages());

            }
        });
        btnNumberOfPages.setBounds(27, 182, 176, 29);
        frame.getContentPane().add(btnNumberOfPages);

        JButton btnCitationNumber = new JButton("Citation Number");
        btnCitationNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Citation Number: " + paper.getCitationNumber());

            }
        });
        btnCitationNumber.setBounds(27, 221, 176, 29);
        frame.getContentPane().add(btnCitationNumber);

        JButton btnGetBibtexCitation = new JButton("Get Bibtex Citation");
        btnGetBibtexCitation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Bibtex citation:\n" + paper.getCitation(Format.BIBTEX));

            }
        });
        
        btnGetBibtexCitation.setBounds(231, 182, 176, 29);
        frame.getContentPane().add(btnGetBibtexCitation);

        JButton btnGetPlainTextCitation = new JButton("Get Plain Text Citation");
        btnGetPlainTextCitation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Plain text citation:\n" + paper.getCitation(Format.PLAIN_TEXT));

            }
        });
        btnGetPlainTextCitation.setBounds(231, 221, 176, 29);
        frame.getContentPane().add(btnGetPlainTextCitation);
    }
}
