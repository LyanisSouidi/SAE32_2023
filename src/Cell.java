public class Cell {

    private String rawContent;

    public Cell(String rawContent) {
        this.rawContent = rawContent;
    }

    @Override
    public String toString() {
        return this.rawContent;
    }

}