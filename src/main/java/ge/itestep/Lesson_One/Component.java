package ge.itestep.Lesson_One;

public class Component {
    protected String manufacturer;
    protected Integer year;

    public Component() {

    }

    public Component(String manufacturer, Integer year)
    {
        this.manufacturer = manufacturer;
        this.year = year;
    }


    public Component(String manufacturer, Integer year, String country)
    {
        this.manufacturer = manufacturer;
        this.year = year;
    }


}
