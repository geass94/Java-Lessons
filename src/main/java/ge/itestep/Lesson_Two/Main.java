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

        HashMap<String, HashMap<String, String>> studentScore = new HashMap<>();

        HashMap<String, String> cities = new HashMap<>();
        cities.put("georgia", "tbilisi");
        cities.put("germany", "berlin");

        studentScore.put("2023-09-10", cities);

        HashMap score = studentScore.get("2023-09-10");

        TreeSet<String> treeList = new TreeSet<>();

        treeList.add("ვაშლი");
        treeList.add("ალუბალი");
        treeList.add("ბანანი");
//
//        System.out.println(treeList);
//
//        System.out.println(score);

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("ნიკა");
        linkedList.add("სანდრო");
        linkedList.add("ელენე");
        linkedList.add("გიორგი");
        linkedList.add("ირაკლი");
        linkedList.add("საბა");

        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.addFirst("ოთო");
        linkedList.addAll(new ArrayList<>(){{
            add("გელა");
            add("ზურა");
        }});

//        System.out.println(linkedList);


        Collections.sort(stringList, (s1, s2) -> s1.compareTo(s2));
        System.out.println(stringList);


        List<Integer> numbers = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
            add(10);
        }};

        numbers.sort((s1, s2) -> {
            if (s1 > s2) return -1;
            else return 1;
        });

        System.out.println(numbers);
//        System.out.println(numbers);
//        List<Integer> odds = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> odds = new ArrayList<>();
        for(Integer n : numbers) {
            if (n % 2 == 0) {
                odds.add(n);
            }
        }

        CustomAnnotation anotation = Student.class.getAnnotation(CustomAnnotation.class);
        if (anotation != null) {
            System.out.println(anotation.age());
        }
    }
}

