package researcher;

import java.util.Comparator;

public class ComparatorByCitation implements Comparator<ResearchPaper>{
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitationNumber(), paper2.getCitationNumber());
    }
}
