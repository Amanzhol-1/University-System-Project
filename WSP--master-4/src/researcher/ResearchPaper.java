package researcher;

public class ResearchPaper{
    private int paperId;
    private String title;
    private Researcher author;
    private int publicationYear;
    private int numberOfPages;
    private int citationNumber;

    public ResearchPaper(int paperId, String title, Researcher author, int publicationYear, int numberOfPages, int citationNumber) {
        this.setPaperId(paperId);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublicationYear(publicationYear);
        this.setNumberOfPages(numberOfPages);
        this.setCitationNumber(citationNumber);
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Researcher getAuthor() {
        return author;
    }

    public void setAuthor(Researcher author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getCitationNumber() {
        return citationNumber;
    }

    public void setCitationNumber(int citationNumber) {
        this.citationNumber = citationNumber;
    }

    public String getCitation(Format format) {
        switch (format) {
            case BIBTEX:
                return getBibtexCitation();
            case PLAIN_TEXT:
                return getPlainTextCitation();
            default:
                throw new IllegalArgumentException("Unsupported citation format");
        }
    }

    private String getBibtexCitation() {
        return String.format("@article{%d,\n  title = {%s},\n  author = {%s},\n  year = {%d},\n  pages = {%d},\n  citationNumber = {%d},\n}",
                getPaperId(), getTitle(), getAuthor().getName(), getPublicationYear(), getNumberOfPages(), getCitationNumber());
    }

    private String getPlainTextCitation() {
        return String.format("\"%s\" (ID: %d) by %s in %d. %d pages. Citation Number: %d.",
                getTitle(), getPaperId(), getAuthor().getName(), getPublicationYear(), getNumberOfPages(), getCitationNumber());
    }


    public static void main(String[] args) {
        Researcher researcher = new Researcher();
        researcher.setName("Zoe");

        ResearchPaper paper = new ResearchPaper(1, "game research", researcher, 2023, 10, 20);

        System.out.println("Bibtex citation:\n" + paper.getCitation(Format.BIBTEX));
        System.out.println("\nPlain text citation:\n" + paper.getCitation(Format.PLAIN_TEXT));
    }
}
