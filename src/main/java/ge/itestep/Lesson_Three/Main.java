package ge.itestep.Lesson_Three;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.InflaterInputStream;

public class Main {
    public static void main(String[] args) {

//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Enter you name: ");
//            String name = reader.readLine();
//            String age = reader.readLine();
//            OutputStream outputStream = System.out;
//            String output = "My name is: " + name + " I am " + age + " years old";
//
//            outputStream.write(output.getBytes());
//
//            System.out.println(
//                    "My name is: " + name +
//                            "I am " + age + " years old"
//            );
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            System.out.println("Enter your dream car name: ");
//
//            String dreamCar = reader.readLine();
//
//            reader.close();
//
//            Stream<String> stringStream = Stream.of(dreamCar);
//            Stream<String> filteredStream = stringStream
//                    .map(c -> c.split("\\s+")) // ყოფს წინადადებას სიტყვებად, აბრუნებს სტრინგების მასივის სტრიმს
//                    .flatMap(Stream::of) // ეს დაგვუბრუნებს ჩვეულებრივ სტრინგების სტრიმს
//                    .filter(c -> !c.equals("Toyota")) // დატოვებს მარტო იმ ნაწილებს რომელშიც არ არის Toyota
//                    .map(String::toUpperCase); // ეს გადაიყვანს მაღალ რეგისტრში
//
//            String modified = filteredStream.collect(Collectors.joining(" ")); // ეს სტრიმს აქცევს უბრალო სსტრინგად
//
//            System.out.println(modified);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            PipedInputStream pis = new PipedInputStream();
//            PipedOutputStream pos = new PipedOutputStream();
//            pis.connect(pos); // აკავშირებს Input-ს Output-თან
//
//            Thread producer = new Thread(() -> {
//                try {
//                    for (int i = 0; i < 5; i++) {
//                        pos.write(("Hello this is me from other thread: " + i).getBytes());
//                        Thread.sleep(1000); // აფერხებს კოდის შესრულებას ერთი წაამით
//                    }
//                    pos.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//
//            Thread listener = new Thread(() -> {
//                try {
//                    int input;
//                    while((input = pis.read()) != -1) {
//                        System.out.println((char)input);
//                    }
//                    pis.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//
////            ვუშვებთ სრედებს
//            producer.start();
//            listener.start();
//
////            უცდის სრედების ოპერაციის შესრულებას
//            producer.join();
//            listener.join();
//
//        } catch (IOException | InterruptedException e) { // შეგვილია ველოდოთ რამდენიმე ტიპის ექსეფშენს
//            e.printStackTrace();
//        }



    }
}
