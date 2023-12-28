package research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Researcher {
    private String name;
    private ResearchPaper paper;
    private ResearchProject project;
    private List<ResearchProject> projects = new ArrayList<>();
    
    public Researcher() {
        
    }

    public Researcher(String name, ResearchPaper paper, ResearchProject project) {
        this.name = name;
        this.paper = paper;
        this.project = project;
        
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResearchPaper> getPaper() {
        return project.getPapers();
    }

    public void setPaper(ResearchPaper paper) {
        this.paper = paper;

    }

    public List<ResearchProject> allProject(){
        return projects;
        
    }
    public ResearchProject getProject(ResearchProject Project) {
    	return project;
    }

    public void addPaper(ResearchProject project, ResearchPaper newPaper) {
    	project.addPaper(newPaper);
    }

    public void setProject(ResearchProject project) {
        this.project = project;
    }
    public void addProject(int projectId,String projectName) {
        ResearchProject newProject = new ResearchProject(projectId, projectName);
        projects.add(newProject);
    }

    public int calculateHIndex() {
        List<ResearchPaper> papers = getProject(project).getPapers();

        // Sort papers based on citation number using ComparatorByCitation
        papers.sort(new ComparatorByCitation().reversed());

        int hIndex = 0;

        for (int i = 0; i < papers.size(); i++) {
            int citations = papers.get(i).getCitationNumber();
            hIndex += citations;
        }

        return hIndex;
    }

   
    public String printPapers(ResearchProject project, Comparator<ResearchPaper> comparator) {
    	List<ResearchPaper> papers = project.getPapers();
        Collections.sort(papers, comparator);

        StringBuilder result = new StringBuilder();
        result.append("Papers for Project: ").append(project.getProjectName()).append("\n");

        for (ResearchPaper paper : papers) {
            result.append("Paper ID: ").append(paper.getPaperId())
                  .append(", Paper Title: ").append(paper.getTitle())
                  .append(", Author: ").append(paper.getAuthor().getName())
                  .append(", Publication Year: ").append(paper.getPublicationYear())
                  .append(", Number of Pages: ").append(paper.getNumberOfPages())
                  .append(", Citation Number: ").append(paper.getCitationNumber())
                  .append("\n");
        }

        return result.toString();
    }
}