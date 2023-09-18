package ge.itestep.Lesson_One;

public class Monitor {
    public Integer frequency;
    public Integer diagonal;

    public String resolution;

    public Monitor()
    {

    }

    public Monitor(Integer frequency, Integer diagonal, String resolution)
    {
        this.diagonal = diagonal;
        this.frequency = frequency;
        this.resolution = resolution;
    }
}
