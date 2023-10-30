package ge.itstep.demo;

public class HomeWork18 {
    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3}, // 1 4 7
                {4, 5, 6}, // 2 5 8
                {7, 8, 9}  // 3 6 9
        };
        /* რასაც კითხულობთ ვერტიკალურად ეგ უნდა გარდაქმნათ ახალ
        * მასივად ოღონდ ჰორიზნტებში უნდა იყოს ჩაწერილი ვერტიკალები. */
        DrawMatrix(data);
        int[][] data2 = DrawMatrixHerizontallyVerticalled(data);
        DrawMatrix(data2);


        String[] examplesaba = {"qvabi", "qvaba", "qvavri"}; //qva
        String[] example1 = {"flower", "flow", "flight"};
        String[] example2 = {"dog", "racecar", "car"};




    }
    public static void LongestCommonPrefix(String[] strs){
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) > -1){

            }



        }
    }
    public static void DrawMatrix(int[][] matrix){
        System.out.println("===================");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]  + ",");
            }
            System.out.println();
        };
        System.out.println("===================");
    }
    public static int[][] DrawMatrixHerizontallyVerticalled(int[][] matrixtobereversed){
        int[][] HorizontallyVerticalledMatrix = new int[matrixtobereversed.length][matrixtobereversed.length];
        for (int i = 0; i < matrixtobereversed.length; i++) {
            //System.out.println("in data: " + data[0][i]);
            for (int j = 0; j < matrixtobereversed[i].length; j++) {
                HorizontallyVerticalledMatrix[i][j] = matrixtobereversed[j][i];
                //System.out.println("Added in data2: " + data2[i][j]);
            }
        }
        return HorizontallyVerticalledMatrix;
    }
}
