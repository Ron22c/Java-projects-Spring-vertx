package computer;

public class Processor {
    private int threads;
    private String name;
    private int cores;

    public Processor(int threads, String name, int cores) {
        this.threads = threads;
        this.name = name;
        this.cores = cores;
    }

    public Processor() {
        this.threads = 64;
        this.name = "Ryzen";
        this.cores = 8;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "threads=" + threads +
                ", name='" + name + '\'' +
                ", cores=" + cores +
                '}';
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }
}
