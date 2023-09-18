package ge.itestep.Lesson_One;

public class Cpu extends Component implements Operation {

    private Double frequency;

    public Cpu()
    {
        super();
    }

    public Cpu(Double frequency, String manufacturer, Integer year)
    {
        super(manufacturer, year);
        this.frequency = frequency;
    }

    public void setFrequency(Double freq)
    {
        this.frequency = freq;
    }

    public Double getFrequency()
    {
        return this.frequency;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "frequency=" + frequency +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public Double calculate(int a, int b) {
        return (double)(a + b);
    }
}
