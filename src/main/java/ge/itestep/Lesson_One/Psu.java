package ge.itestep.Lesson_One;

public class Psu extends Component {
    public Double output;

    public Psu()
    {

    }

    @Override
    public String toString() {
        return "Psu{" +
                "output=" + output +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }
}
