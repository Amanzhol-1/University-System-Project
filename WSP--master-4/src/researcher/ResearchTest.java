package researcher;

public class ResearchTest {
    public static void main(String[] args) {
    
        Researcher researcher = new Researcher();
        researcher.setName("John Doe");

        ResearchPaper paper = new ResearchPaper(1, "Ooop research", researcher, 2022, 8, 6);

        ResearchProject project = new ResearchProject(101, "Oop Project");
        project.addPaper(paper);

        researcher.setProject(project);
        

        CanBeResearcher canBeResearcher = new CanBeResearcher();
        canBeResearcher.setResearcher(researcher);
        //canBeResearcher.canBeResearcher();
        
        try {
            canBeResearcher.canBeResearcher();
        } catch (InvalidHIndexException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
