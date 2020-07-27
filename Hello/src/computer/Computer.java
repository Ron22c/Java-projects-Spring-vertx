package computer;

public class Computer {
    private int ram;
    private Processor processor;
    private GraphicCard graphicCard;
    private String motherBoard;

    public Computer(int ram, Processor processor, GraphicCard graphicCard, String motherBoard) {
        this.ram = ram;
        this.processor = processor;
        this.graphicCard = graphicCard;
        this.motherBoard = motherBoard;
    }

    public Computer() {
        this.ram = 12;
        this.processor = new Processor();
        this.graphicCard = new GraphicCard();
        this.motherBoard = "Intel";
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", processor=" + processor +
                ", graphicCard=" + graphicCard +
                ", motherBoard='" + motherBoard + '\'' +
                '}';
    }

    public int getRam() {
        return ram;
    }

    public Processor getProcessor() {
        return processor;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public String getMotherBoard() {
        return motherBoard;
    }
}
