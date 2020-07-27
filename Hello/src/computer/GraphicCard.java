package computer;

public class GraphicCard {
    private int memory;
    private String name;

    public GraphicCard(int memory, String name) {
        this.memory = memory;
        this.name = name;
    }

    public GraphicCard() {
        this.memory = 2;
        this.name = "AMD";
    }

    @Override
    public String toString() {
        return "GraphicCard{" +
                "memory=" + memory +
                ", name='" + name + '\'' +
                '}';
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
