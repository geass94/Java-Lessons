package ge.itestep.Lesson_Two;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String name[] = {"დათო", "ნიკა", "...."};
        String age[] = new String[5];

        List<String> stringList = new ArrayList<>();

        stringList.add("sandro");
        stringList.add("luka");
        stringList.add("nika");

        List<String> ucList = stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        Set<String> stringSet = new HashSet<>();

        HashMap<String, HashMap<String, String>>  studentScore = new HashMap<>();

        HashMap<String, String > cities = new HashMap<>();
        cities.put("georgia", "tbilisi");
        cities.put("germany", "berlin");

        studentScore.put("2023-09-10", cities);

        HashMap score = studentScore.get("2023-09-10");

        System.out.println(score);
    }
}
