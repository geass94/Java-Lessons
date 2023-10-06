package ge.itestep.Lesson_Nine;

import java.util.ArrayList;

public class MobilePhone {


    public static void main(String[] args) {
        MobilePhone mp = new MobilePhone("599 99 99 99");

        try{
            mp.addNewContact(Contact.createContact("vigaca1","+995 599 234567"));
            mp.addNewContact(Contact.createContact("vigaca2 gamsxmeli","1234567"));
            mp.addNewContact(Contact.createContact("vigaca3","+995 32 1234567"));
            mp.addNewContact(Contact.createContact("vigaca4","+995 32 1234567"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }





    }


    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position >= 0) {
            myContacts.set(position, newContact);
            return true;
        }else{
            System.out.println("Couldn't find contact");
        }

        return false;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position >= 0) {
            myContacts.remove(position);
            return true;
        }else{
            System.out.println("Couldn't find contact");
        }
        return false;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String keyword) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(keyword) || contact.getPhoneNumber().equals(keyword)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }



    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }


}

