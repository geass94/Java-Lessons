package ge.itestep.Lesson_One;


import ge.itestep.Lesson_One.*;

public class Main {
    public static void main(String[] args) {
        Computer pc = new Computer();

        pc.motherboard = new Motherboard();
        pc.motherboard.socket = "LGA 1200";
        pc.motherboard.manufacturer = "Asus";
        pc.motherboard.year = 2023;

        pc.motherboard.cpu = new Cpu(4.4, "Intel", 2022);
//        pc.motherboard.cpu.setFrequency(4.8);
//        pc.motherboard.cpu.manufacturer = "Intel";
//        pc.motherboard.cpu.year = 2022;
        pc.motherboard.ram = new Ram();
        pc.motherboard.ram.capacity = 32;
        pc.motherboard.ram.manufacturer = "Gskill";
        pc.motherboard.ram.year = 2022;
        pc.psu = new Psu();
        pc.psu.manufacturer = "Seasonic";
        pc.psu.output = 1200d;
        pc.psu.year = 2022;

        String names[] = {"Saba", "Dato", "Otto"};
        String surnames[] = new String[5];
//        Integer age[] = new Integer[10];



        for (int i = 0; i < 3; i++) {
//            surnames[i] = "Iterator " + i;
        }

        for (String surname : surnames) {
//            System.out.println(surname + "\n");
        }

        for (int i = 0; i < names.length; i++) {
//            System.out.println("name[" + i + "] " + names[i] + "\n");
        }
        int i = 10;
        do {
            System.out.println("aq aris");
            i++;
        }
        while(i < 10);

//        System.out.println(pc.monitor.resolution);
//
//
//
//        System.out.println(
//                pc.motherboard.cpu.calculate(56, 14) + " \n" +
//                pc.motherboard.ram.calculate(4, 6)
//        );

        Computer pcs[] = new Computer[10];
    }
}

