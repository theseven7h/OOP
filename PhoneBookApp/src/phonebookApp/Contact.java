package phonebookApp;

import exceptions.*;
import java.util.Arrays;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        validateName(firstName);
        validateName(lastName);
        validatePhoneNumber(phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String newFirstName) {
        validateName(newFirstName);
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        validateName(newLastName);
        this.lastName = newLastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new InvalidDetailException("Field cannot be empty");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        validatePhoneNumberLength(phoneNumber);
        validatePhoneNumberIsDigits(phoneNumber);
        validatePhoneNumberStartFormat(phoneNumber);
    }

    private void validatePhoneNumberIsDigits(String phoneNumber) {
        boolean isDigits = phoneNumber.matches("\\d+");
        if (!isDigits) {
            throw new InvalidPhoneNumberFormatException("Phone number should be digits only");
        }
    }

    private void validatePhoneNumberLength(String phoneNumber) {
        boolean isNotElevenDigits = phoneNumber.length() != 11;
        if(isNotElevenDigits) {
            throw new InvalidPhoneNumberLengthException("Phone number length should be 11 digits");
        }
    }

    private void validatePhoneNumberStartFormat(String phoneNumber) {
        String[] validPhoneNumberStarts = {"070", "080", "090", "071", "081", "091"};
        boolean isValidFormat = Arrays.stream(validPhoneNumberStarts).anyMatch(phoneNumber::startsWith);
        if(!isValidFormat) {
            throw new InvalidPhoneNumberFormatException("Invalid phone number format");
        }
    }
}