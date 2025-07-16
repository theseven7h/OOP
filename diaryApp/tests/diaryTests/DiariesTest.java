package diaryTests;

import diaryApp.Diaries;
import diaryApp.Diary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {
    @Test
    public void testCanAddDiaryToDiaries() {
        Diaries diaries = new Diaries();
        assertNull(diaries.findByUserName("username"));
        diaries.add("username", "password");
        assertNotNull(diaries.findByUserName("username"));
    }

    @Test
    public void testCanDeleteDiaryFromDiaries() {
        Diaries diaries = new Diaries();
        assertNull(diaries.findByUserName("username"));
        diaries.add("username", "password");
        diaries.add("username2", "password2");
        assertNotNull(diaries.findByUserName("username2"));

        diaries.delete("username2", "password2");

        assertNull(diaries.findByUserName("username2"));
    }
}
