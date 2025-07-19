package diaryTests;

import diaryApp.Diary;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    Diary diary;

    @BeforeEach
    public void doFirst(){
        Diary.resetUsersId();
        diary = new Diary("username", "password");
    }

    @Test
    public void testCanUnlockDiaryWithRightPassword() {
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
    }

    @Test
    public void testUnlockAttempt_withWrongPassword_throwsException() {
        assertTrue(diary.isLocked());
        assertThrows(InvalidPasswordException.class, () -> diary.unlockDiary("notPassword"));
    }

    @Test
    public void testCanLockDiaryBack_afterUnlocking() {
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatAnEntryExists_afterEntryIsCreated() {
        diary.unlockDiary("password");
        assertThrows(EmptyDiaryException.class, () -> diary.findEntryById(1001));
        diary.createEntry("title", "body");
        assertDoesNotThrow(() -> diary.findEntryById(1001));
        assertNotNull(diary.findEntryById(1001));
    }

    @Test
    public void testThatExceptionIsThrown_whenEntryIdNotFound() {
        diary.unlockDiary("password");
        diary.createEntry("title", "body");
        assertNotNull(diary.findEntryById(1001));
        assertThrows(InvalidIdException.class, () -> diary.findEntryById(1002));
    }

    @Test
    public void testSearchingForDeletedEntry_throwsException() {
        diary.unlockDiary("password");
        assertThrows(EmptyDiaryException.class, () -> diary.findEntryById(1001));
        diary.createEntry("title", "body");
        diary.createEntry("title2", "body2");
        assertNotNull(diary.findEntryById(1001));
        assertDoesNotThrow(() -> diary.findEntryById(1001));

        diary.deleteEntry(1001);
//        diary.deleteEntry(1002);

        assertThrows(InvalidIdException.class, () -> diary.findEntryById(1001));
    }

    @Test
    public void testThatRightEntry_isReturnedAfterFindEntryById_byCheckingEntryTitle() {
        diary.unlockDiary("password");
        assertThrows(EmptyDiaryException.class, () -> diary.findEntryById(1001));
        diary.createEntry("title", "body");
        assertDoesNotThrow(() -> diary.findEntryById(1001));
        assertEquals("title", diary.findEntryById(1001).getTitle());
    }

    @Test
    public void testThatBodyIsModified_whenEntryIsUpdated() {
        diary.unlockDiary("password");
        diary.createEntry("title", "body");
        assertEquals("body", diary.findEntryById(1001).getBody());

        String newBody = "this is a new body";
        diary.updateEntry(1001, "Title", newBody);

        assertEquals(newBody, diary.findEntryById(1001).getBody());
    }

    @Test
    public void testThatExceptionIsThrown_whenUpdatingWithNonExistentId() {
        diary.unlockDiary("password");
        diary.createEntry("title", "body");
        assertEquals("body", diary.findEntryById(1001).getBody());

        String newBody = "this is a new body";

        assertThrows(InvalidIdException.class, () -> diary.updateEntry(1002, "Title", newBody));
    }

    @Test
    public void testThatDateOfEntryCreationIsCorrect() {
        diary.unlockDiary("password");
        diary.createEntry("title", "body");

        LocalDateTime date = LocalDateTime.now();
        LocalDateTime entryDate = diary.findEntryById(1001).getDateCreated();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        assertEquals(date.format(formatter), entryDate.format(formatter));
    }
}