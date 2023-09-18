package ge.itestep.Lesson_One;

public class Ram extends Component implements Operation {
    public Integer capacity;

    public Ram()
    {

    }

    @Override
    public String toString() {
        return "Ram{" +
                "capacity=" + capacity +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public Double calculate(int a, int b) {
        return (double)(a * b);
    }
}
