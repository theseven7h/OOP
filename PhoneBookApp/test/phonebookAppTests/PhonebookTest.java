package phonebookAppTests;

import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phonebookApp.*;

import static org.junit.jupiter.api.Assertions.*;

public class PhonebookTest {
    PhoneBook phoneBook;

    @BeforeEach
    public void doFirst() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testFindingContactByPhoneNumber_whenPhoneNumber_hasNotBeenAdded_throwsException() {
        assertThrows(EmptyPhoneBookException.class, () -> phoneBook.findContactByPhoneNumber("08012345678"));
    }

    @Test
    public void testNoExceptionIsThrown_whenFindingContact_thatHasBeenAddedToPhoneBook() {
        assertThrows(EmptyPhoneBookException.class, () -> phoneBook.findContactByPhoneNumber("08012345678"));

        phoneBook.addContact("firstName", "lastName", "08012345678");

        assertDoesNotThrow(() -> phoneBook.findContactByPhoneNumber("08012345678"));
        assertEquals("firstName", phoneBook.findContactByPhoneNumber("08012345678").getFirstName());
    }

    @Test
    public void testPhoneNumber_OfReturnedContact_isCorrect_afterFindingContactByFirstName() {
        phoneBook.addContact("firstName", "lastName", "08012345678");

        Contact contact = phoneBook.findContactByFirstName("firstName");

        assertEquals("firstName", contact.getFirstName());
    }

    @Test
    public void testPhoneNumber_OfReturnedContact_isCorrect_afterFindingContactByLastName() {
        phoneBook.addContact("firstName", "lastName", "08012345678");

        Contact contact = phoneBook.findContactByLastName("lastName");

        assertEquals("lastName", contact.getLastName());
    }

    @Test
    public void testFirstName_andLastNames_OfReturnedContact_areCorrect_afterFindingContactByPhoneNumber() {
        phoneBook.addContact("firstName", "lastName", "08012345678");

        Contact contact = phoneBook.findContactByPhoneNumber("08012345678");

        assertEquals("08012345678", contact.getPhoneNumber());
    }

    @Test
    public void testExceptionIsThrown_whenFindingContact_withPhoneNumberThatDoesNotExist() {
        phoneBook.addContact("firstName", "lastName", "08012345678");

        Exception e = assertThrows(InvalidDetailException.class, () -> phoneBook.findContactByPhoneNumber("08012345333"));

        assertEquals("No contact with that number exists", e.getMessage());
    }

    @Test
    public void testExceptionIsThrown_whenFindingContact_withFirstNameThatDoesNotExist() {
        phoneBook.addContact("firstName", "lastName", "08012345678");

        Exception e = assertThrows(InvalidDetailException.class, () -> phoneBook.findContactByFirstName("notFirstName"));

        assertEquals("No contact with that first name exists", e.getMessage());
    }

    @Test
    public void testExceptionIsThrown_whenFindingContact_withLastNameThatDoesNotExist() {
        phoneBook.addContact("firstName", "lastName", "08012345678");

        Exception e = assertThrows(InvalidDetailException.class, () -> phoneBook.findContactByLastName("notLastName"));

        assertEquals("No contact with that last name exists", e.getMessage());
    }

    @Test
    public void testFirstNameIsSame_whenContactFirstNameIsGotten_usingNewEditedPhoneNumber() {
        phoneBook.addContact("firstName", "lastName", "08012345678");
        assertEquals("firstName", phoneBook.findContactByPhoneNumber("08012345678").getFirstName());

        phoneBook.editPhoneNumber("08012345678", "08012345999");
        assertEquals("firstName",  phoneBook.findContactByPhoneNumber("08012345999").getFirstName());
    }

    @Test
    public void testPhoneNumberIsSame_whenContactPhoneNumberIsGotten_usingNewEditedFirstName() {
        phoneBook.addContact("firstName", "lastName", "08012345678");
        assertEquals("08012345678", phoneBook.findContactByFirstName("firstName").getPhoneNumber());

        phoneBook.editFirstName("firstName", "newFirstName");
        assertEquals("08012345678",  phoneBook.findContactByFirstName("newFirstName").getPhoneNumber());
    }

    @Test
    public void testPhoneNumberIsSame_whenContactPhoneNumberIsGotten_usingNewEditedLastName() {
        phoneBook.addContact("firstName", "lastName", "08012345678");
        assertEquals("08012345678", phoneBook.findContactByLastName("lastName").getPhoneNumber());

        phoneBook.editLastName("lastName", "newLastName");
        assertEquals("08012345678",  phoneBook.findContactByLastName("newLastName").getPhoneNumber());
    }

    @Test
    public void testExceptionIsThrown_whenLengthOfNewEditedPhoneNumber_isNotElevenDigits() {
        phoneBook.addContact("firstName", "lastName", "08012345678");
        assertEquals("firstName", phoneBook.findContactByPhoneNumber("08012345678").getFirstName());

        assertThrows(InvalidPhoneNumberLengthException.class, () -> phoneBook.editPhoneNumber("08012345678", "08012345"));
    }

    @Test
    public void testExceptionIsThrown_whenNewEditedPhoneNumber_doesNotContainDigitsOnly() {
        phoneBook.addContact("firstName", "lastName", "08012345678");
        assertEquals("firstName", phoneBook.findContactByPhoneNumber("08012345678").getFirstName());

        assertThrows(InvalidPhoneNumberFormatException.class, () -> phoneBook.editPhoneNumber("08012345678", "08012345a33"));
    }

    @Test
    public void testExceptionIsThrown_whenNewEditedPhoneNumber_doesNotStartWithCountryFormat() {
        phoneBook.addContact("firstName", "lastName", "08012345678");
        assertEquals("firstName", phoneBook.findContactByPhoneNumber("08012345678").getFirstName());

        Exception e = assertThrows(InvalidPhoneNumberFormatException.class, () -> phoneBook.editPhoneNumber("08012345678", "05012345533"));

        assertEquals("Invalid phone number format", e.getMessage());
    }
}