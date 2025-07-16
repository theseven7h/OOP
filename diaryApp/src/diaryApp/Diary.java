package diaryApp;

import exceptions.EmptyDiaryException;
import exceptions.InvalidIdException;
import exceptions.InvalidPasswordException;
import java.util.ArrayList;
import java.util.List;


public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;
    private List<Entry> entries;

    private static int usersId = 1000;

    public Diary(String username, String password){
        this.username = username;
        this.password = password;
        this.entries = new ArrayList<>();
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlockDiary(String userPassword) {
        validatePassword(userPassword);
        isLocked = false;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public void createEntry(String title, String body) {
        entries.add(new Entry(++usersId, title, body));
    }

    public Entry findEntryById(int id) {
        validateEntryNotEmpty();
        for (Entry entry : entries) {
            boolean entryFound = id == entry.getId();
            if (entryFound) return entry;
        }
        throw new InvalidIdException("Entry with id " + id + " not found");
    }

    public void deleteEntry(int id) {
        validateEntryNotEmpty();
        entries.removeIf(entry -> entry.getId() == id);
    }

    public void updateEntry(int id, String newTitle, String newBody) {
        validateEntryNotEmpty();
        Entry entry = findEntryById(id);
        entry.setTitle(newTitle);
        entry.setBody(newBody);
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private void validatePassword(String userPassword) {
        boolean passwordIsIncorrect = !userPassword.equals(password);
        if (passwordIsIncorrect) {
            throw new InvalidPasswordException("You entered an incorrect password");
        }
    }

    private void validateEntryNotEmpty() {
        if (entries.isEmpty()) {
            throw new EmptyDiaryException("You have not added any entries yet");
        }
    }

    public static void resetUsersId() {
        usersId = 1000;
    }
}