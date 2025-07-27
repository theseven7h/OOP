package phonebookApp;

import exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(String firstName, String lastName, String phoneNumber) {
        contacts.add(new Contact(firstName, lastName, phoneNumber)); // new Contact("James", "Tauri", "09134510476")
    }

    public Contact findContactByPhoneNumber(String phoneNumber) {
        checkIfPhonebookIsEmpty();
        return contacts.stream()
                .filter(contact -> contact.getPhoneNumber().equals(phoneNumber))
                .findFirst().orElseThrow(() -> new InvalidDetailException("No contact with that number exists"));
    }

    public Contact findContactByFirstName(String firstName) {
        checkIfPhonebookIsEmpty();
        return contacts.stream()
                .filter(contact -> contact.getFirstName().equals(firstName))
                .findFirst().orElseThrow(() -> new InvalidDetailException("No contact with that first name exists"));
    }

    public Contact findContactByLastName(String lastName) {
        checkIfPhonebookIsEmpty();
        return contacts.stream()
                .filter(contact -> contact.getLastName().equals(lastName)).
                findFirst().orElseThrow(() -> new InvalidDetailException("No contact with that last name exists"));
    }

    private void checkIfPhonebookIsEmpty() {
        if (contacts.isEmpty())
            throw new EmptyPhoneBookException("Phone book is empty");
    }

//    public void editContact(String detail, String oldDetail, String newDetail) {
//        switch (detail) {
//            case "firstName": editFirstName(oldDetail, newDetail);
//            case "lastName": editLastName(oldDetail, newDetail);
//            case "phoneNumber": editPhoneNumber(oldDetail, newDetail);
//        }
//    }

    public void editPhoneNumber(String phoneNumber, String newPhoneNumber) {
        Contact foundContact = contacts.stream().filter(contact -> contact.getPhoneNumber().equals(phoneNumber))
                .findFirst().orElseThrow(() -> new InvalidDetailException("No contact with that number exists"));
        foundContact.setPhoneNumber(newPhoneNumber);
    }

    public void editFirstName(String firstName, String newFirstName) {
        Contact foundContact = contacts.stream().filter(contact -> contact.getFirstName().equals(firstName))
                .findFirst().orElseThrow(() -> new InvalidDetailException("No contact with that first name exists"));
        foundContact.setFirstName(newFirstName);
    }

    public void editLastName(String lastName, String newLastName) {
        Contact foundContact = contacts.stream().filter(contact -> contact.getLastName().equals(lastName))
                .findFirst().orElseThrow(() -> new InvalidDetailException("No contact with that last name exists"));
        foundContact.setLastName(newLastName);
    }
}
