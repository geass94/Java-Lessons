package ge.itestep.Lesson_Nine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    //regex
    private static final String regexPattern = "^\\+995\\s(559|557|555|599|593|...)\\s\\d{6}$";


    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) throws Exception {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()){
            throw new Exception("This PhoneNumber - " +phoneNumber + "Is in invalid format, or wrong. (+995 559 123456)");
        }
        return new Contact(name, phoneNumber);
    }
}
