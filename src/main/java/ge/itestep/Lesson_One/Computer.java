package ge.itestep.Lesson_One;

public class Computer {
    public Motherboard motherboard;
    public Psu psu;
    public Monitor monitor;

    private boolean turnedOn = false;

    public void turnOn() throws Exception {
        this.turnedOn = true;
        System.out.println(
                "I am " + motherboard.manufacturer +
                        "I am turned " + pcState()
        );
    }

    private String pcState()
    {
        if (turnedOn) return "On";
        else return "Off";
    }

    public void turnOff()
    {
        this.turnedOn = false;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "motherboard=" + motherboard +
                ", psu=" + psu +
                ", monitor=" + monitor +
                '}';
    }
}
