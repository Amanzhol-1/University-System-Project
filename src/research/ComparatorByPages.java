package research;

import java.util.Comparator;

public class ComparatorByPages implements Comparator<ResearchPaper>{
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getNumberOfPages(), paper2.getNumberOfPages());
    }
}
