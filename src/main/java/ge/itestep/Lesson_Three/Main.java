package ge.itestep.Lesson_Three;

import java.io.*;
import java.util.ArrayList;
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
//                        pos.write(("Hello this is me from other thread: " + i + "\n").getBytes());
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
//
//                    while((input = pis.read()) != -1) {
//                        ArrayList<Integer> chars = new ArrayList<>();
//                        chars.add(input);
//                        String str = chars
//                                .stream()
//                                .map(s -> (char)s.intValue())
//                                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
//                        System.out.print(str);
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

//        try {
//            FileInputStream fis = new FileInputStream("input.txt");
//
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
//
//            int input;
//            while((input = bufferedInputStream.read()) != -1) {
//                System.out.print((char) input);
//            }
//            bufferedInputStream.close();
//            fis.close();
//
//            FileOutputStream fos = new FileOutputStream("output.txt");
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos);
//
//
//            String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rhoncus quam quis mi maximus rhoncus. Mauris nec odio eu sapien iaculis dignissim a ac neque. In ultricies commodo nisi, in pharetra nulla pulvinar in. Nam scelerisque nisi sed purus blandit vestibulum. Phasellus ultricies risus dolor, a finibus elit lacinia sit amet. Integer id tincidunt turpis. Ut euismod imperdiet diam eget convallis. Vivamus a iaculis nulla. Morbi quis faucibus arcu. In aliquet euismod viverra. Morbi quis ornare risus. Sed vel augue eros. Integer tempus ligula eu libero rutrum, a maximus nibh dictum.";
//            byte[] bytes = message.getBytes();
//            bufferedOutputStream.write(bytes);
//            bufferedOutputStream.close();
//            fos.close();
//
//            fis = new FileInputStream("output.txt");
//            fos = new FileOutputStream("output-copy.txt");
//            int data;
//            while((data = fis.read()) != -1) {
//                fos.write(data);
//            }
//
//            fis.close();
//            fos.close();
//            System.out.println("File copied");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        try {
            Student st1 = new Student();
            st1.setFirstName("Otto");
            st1.setLastName("Koridze");
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(st1);


            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));

            Student st2 = (Student) ois.readObject();

            System.out.println(st2.getLastName());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
