package ge.itstep.demo;

public class HomeWork14 {
    public static void main(String args[]) {
        System.out.println(countChars("aaaaooiiiIIccgglppZZxx"));
    }

//    aaaaooiiiIIccgglppZZxx გარდაქმენით შემდეგ ენკოდინგად: 4a2o3i2I2c2g1l2p2Z2x

    public static String countChars(String word)
    {
        if (word == null || word.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                builder.append(count).append(word.charAt(i - 1));
                count = 1;
            }
        }

        builder.append(count).append(word.charAt(word.length() - 1));

        return builder.toString();
    }

}
