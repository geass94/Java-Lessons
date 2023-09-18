package ge.itestep.Lesson_One;

public class Motherboard extends Component {
    public String socket;
    public Cpu cpu;
    public Ram ram;

    public Motherboard()
    {
        super();
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                "socket='" + socket + '\'' +
                ", cpu=" + cpu +
                ", ram=" + ram +
                '}';
    }
}
