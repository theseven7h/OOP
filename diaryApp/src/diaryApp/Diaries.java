package diaryApp;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private final List<Diary> diaries = new ArrayList<>();

    public void add(String username, String password) {
        diaries.add(new Diary(username, password));
    }

    public Diary findByUserName(String username) {
       for (Diary diary : diaries) {
          if (diary.getName().equals(username)) {
              return diary;
          }
       }
       return null;
    }

    public void delete(String username, String password) {
        Diary foundDiary = findByUserName(username);
        if (foundDiary.getPassword().equals(password))
            diaries.remove(foundDiary);
    }
}