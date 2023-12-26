package student;

import java.awt.EventQueue;

import system.User;

import javax.swing.JFrame;

import researcher.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Student extends User{

	private JFrame frame;
//
//  /
//   * Launch the application.
//   */
////  public static void main(String[] args) {
////    EventQueue.invokeLater(new Runnable() {
////      public void run() {
////        try {
////          Student window = new Student();
////          window.frame.setVisible(true);
////        } catch (Exception e) {
////          e.printStackTrace();
////        }
////      }
////    });
////  }
//
//  /
//   * Create the application.
//   */
  public Student(String username, String name, String surname) {
    super(username, name, surname);
  }

  /**
   * Initialize the contents of the frame.
   * @wbp.parser.entryPoint
   */
  
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JButton newsButton = new JButton("News");
    newsButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    newsButton.setBounds(56, 130, 150, 50);
    frame.getContentPane().add(newsButton);
    
    JButton viewCourseButton = new JButton("View Courses ");
    viewCourseButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    viewCourseButton.setBounds(342, 254, 150, 50);
    frame.getContentPane().add(viewCourseButton);
    
    JButton attButton = new JButton("View Attestation");
    attButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    attButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        studentAtt();
      }
    });
    attButton.setBounds(56, 254, 150, 50);
    frame.getContentPane().add(attButton);
    
    JButton stuOrgButton = new JButton("Student Organization");
    stuOrgButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
    stuOrgButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        studentOrganization();
      } 
    });
    stuOrgButton.setBounds(342, 192, 150, 50);
    frame.getContentPane().add(stuOrgButton);
    
    JButton transcriptButton = new JButton("View Transcript");
    transcriptButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    transcriptButton.setBounds(342, 130, 150, 50);
    frame.getContentPane().add(transcriptButton);
    
    JButton addDropButton = new JButton("ADD/DROP");
    addDropButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    addDropButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addDrop();
      }
    });
    addDropButton.setBounds(607, 130, 150, 50);
    frame.getContentPane().add(addDropButton);
    
    JButton queButton = new JButton("Questionnaire");
    queButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    queButton.setBounds(607, 192, 150, 50);
    frame.getContentPane().add(queButton);
    
    JButton scheduleButton = new JButton("View Schedule");
    scheduleButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    scheduleButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        schedule();
      }
    });
    scheduleButton.setBounds(56, 192, 150, 50);
    frame.getContentPane().add(scheduleButton);
    
    JButton btnNewButton = new JButton("BeResearcher");
    btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Researcher researcher = new Researcher();
            ResearcherGUI researcherGUI = new ResearcherGUI(researcher);
            researcherGUI.setVisible(true); 
            btnNewButton.setEnabled(false); 
        }
    });
    btnNewButton.setBounds(607, 254, 150, 50);
    frame.getContentPane().add(btnNewButton);
  }

  @Override
  public void logIn() {
    initialize();
    
  }
  
  public void studentOrganization() {
    StudentOrganization studentOrganization = new StudentOrganization();
    studentOrganization.setVisible(true);
  } 
  
  public void addDrop() {
    StudentAddDrop addDrop = new StudentAddDrop();
    addDrop.setVisible(true);
  }
  
  public void schedule() {
    StudentSchedule schedule = new StudentSchedule();
    schedule.setVisible(true);
  }
  
  public void studentAtt() {
    StudentAttestation studentAtt = new StudentAttestation(name, surname);
  }
  
  public void research() {
	  CanBeResearcher researcher = new CanBeResearcher(); 
	  researcher.setResearcher(researcher.getResearcher());
  }
}