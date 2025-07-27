package phonebookAppTests;

import exceptions.*;
import phonebookApp.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testFirstNameIsCorrect_atStart() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("firstName", contact.getFirstName());
    }

    @Test
    public void testLastNameIsCorrect_atStart() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("lastName", contact.getLastName());
    }

    @Test
    public void testPhoneNumberIsCorrect_atStart() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("08012345678", contact.getPhoneNumber());
    }

    @Test
    public void testFirstNameIsCorrect_whenFirstNameIsChanged() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("firstName", contact.getFirstName());

        contact.setFirstName("firstName2");
        assertEquals("firstName2", contact.getFirstName());
    }

    @Test
    public void testLastNameIsCorrect_whenLastNameIsChanged() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("lastName", contact.getLastName());

        contact.setLastName("lastName2");
        assertEquals("lastName2", contact.getLastName());
    }

    @Test
    public void testExceptionIsThrown_whenFirstNameIsEmpty_atStart() {
        assertThrows(InvalidDetailException.class ,() -> new Contact("", "lastName", "08012345678"));

    }

    @Test
    public void testExceptionIsThrown_whenFirstNameIsEmpty_whenFirstNameIsChanged() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("firstName", contact.getFirstName());

        assertThrows(InvalidDetailException.class ,() -> contact.setFirstName(""));
    }

    @Test
    public void testExceptionIsThrown_whenLastNameIsEmpty_atStart() {
        assertThrows(InvalidDetailException.class ,() -> new Contact("firsName", "", "08012345678"));
    }

    @Test
    public void testExceptionIsThrown_whenLastNameIsEmpty_whenLastNameIsChanged() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("firstName", contact.getFirstName());

        assertThrows(InvalidDetailException.class ,() -> contact.setLastName(""));
    }

    @Test
    public void testPhoneNumberIsCorrect_whenPhoneNumberIsChanged() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("08012345678", contact.getPhoneNumber());

        contact.setPhoneNumber("09012345678");
        assertEquals("09012345678", contact.getPhoneNumber());
    }

    @Test
    public void testExceptionIsThrown_whenPhoneNumberLength_isNot_11_atStart() {
        assertThrows(InvalidPhoneNumberLengthException.class ,() -> new Contact("firstName", "lastName", "0801234568"));
    }

    @Test
    public void testExceptionIsThrown_whenPhoneNumberIsEmpty_atStart() {
        assertThrows(InvalidPhoneNumberLengthException.class ,() -> new Contact("firstName", "lastName", ""));
    }

    @Test
    public void testExceptionIsThrown_whenPhoneNumberLength_isNot_11_whenEditingContact() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("08012345678", contact.getPhoneNumber());

        assertThrows(InvalidPhoneNumberLengthException.class ,() -> contact.setPhoneNumber("080123456"));
    }

    @Test
    public void testExceptionIsThrown_whenPhoneNumber_isEmpty_whenEditingContact() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");
        assertEquals("08012345678", contact.getPhoneNumber());

        assertThrows(InvalidPhoneNumberLengthException.class ,() -> contact.setPhoneNumber(""));
    }

    @Test
    public void testExceptionIsThrown_whenPhoneNumber_doesNotContainOnlyDigits_atStart() {
        assertThrows(InvalidPhoneNumberFormatException.class ,() -> new Contact("firstName", "lastName", "0801234567a"));
    }
    @Test
    public void testExceptionIsThrown_whenPhoneNumberStartsWithInvalidCountryFormats_atStart() {
        assertThrows(InvalidPhoneNumberFormatException.class, () -> new Contact("firstName", "lastName", "06012345678"));
    }

    @Test
    public void testExceptionIsThrown_whenPhoneNumber_doesNotContainOnlyDigits_whenEditingContact() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");

        assertEquals("08012345678", contact.getPhoneNumber());

        assertThrows(InvalidPhoneNumberFormatException.class, () -> contact.setPhoneNumber("0601234567a"));
    }

    @Test
    public void testExceptionIsThrown_whenPhoneNumberStartsWithInvalidCountryFormats_whenEditingContact() {
        Contact contact = new Contact("firstName", "lastName", "08012345678");

        assertEquals("08012345678", contact.getPhoneNumber());

        assertThrows(InvalidPhoneNumberFormatException.class, () -> contact.setPhoneNumber("06012345678"));
    }
}