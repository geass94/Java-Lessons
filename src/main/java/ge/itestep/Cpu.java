package ge.itestep;

public class Cpu extends Component {

    private Double frequency;

    public Cpu()
    {
        super();
    }

    public void setFrequency(Double freq)
    {
        this.frequency = freq;
    }

    public Double getFrequency()
    {
        return this.frequency;
    }

}
