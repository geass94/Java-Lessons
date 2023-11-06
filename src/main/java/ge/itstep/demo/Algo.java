package ge.itstep.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algo {
    // [[1, 3], [2, 6], [8, 10], [15, 18]]
    // [[1, 6], [8, 10], [15, 18]]
    public static void main(String[] args) {
        int[][] range = { { 2, 6 }, { 1, 3 }, {19, 21}, { 5, 10 }, { 15, 18 } };
        Arrays.stream(range).forEach(interval -> Arrays.sort(interval));

        while (hasIntersection(range)) {
            range = findIntervals(range);
        }

        printRange(range);


    }

    public static void printRange(int[][] range) {
        for (int[] item : range) {
            System.out.println(Arrays.toString(item));
        }
    }

    public static int[][] findIntervals(int[][] range) {
        if (range.length < 1) {
            return new int[0][];
        }

        List<int[]> results = new ArrayList<>();
        int[] intersection = range[0];

        for (int i = 1; i < range.length; i++) {
            if (intersection[1] >= range[i][0]) {
                intersection[1] = range[i][1];
            } else {
                results.add(intersection);
                intersection = range[i];
            }
        }

        results.add(intersection);

        return results.toArray(new int[results.size()][]);
    }

    public static boolean hasIntersection(int[][] range) {
        if (range.length < 1) {
            return false;
        }
      
        int[] intersection = range[0];
        for (int i = 1; i < range.length; i++) {
            if (intersection[1] >= range[i][0]) {
                return true;
            }
        }

        return false;
    }
}
