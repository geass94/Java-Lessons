package ge.itstep.demo.model;

public enum ShipType {

    TWO_SLOT(2, "TWO_SLOT"),
    FOUR_SLOT(4, "FOUR_SLOT");

    private int size;
    private String name;

    ShipType(int size, String name)
    {
        this.size = size;
        this.name = name;
    }

    public static ShipType getFromName(String name)
    {
        for (ShipType shipType :ShipType.values()) {
            if (shipType.getName().equals(name)) {
                return shipType;
            }
        }
        throw new RuntimeException("Could not find ShipType by name: " + name);
    }

    public static ShipType getFromSize(int size)
    {
        for (ShipType shipType : ShipType.values()) {
            if (shipType.getSize() == size) {
                return shipType;
            }
        }

        throw new RuntimeException("Could not find ShipType by size: " + size);
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
