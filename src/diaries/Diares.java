package diaries;

import diaries.exceptions.EntryHasNotBeenCreatedException;

import java.util.ArrayList;

public class Diares {

    private ArrayList<Diary> diaries = new ArrayList<>();

    public void add(String user_name, String password){
        Diary diary = new Diary(user_name, password);
        diaries.add(diary);
    }
    public Diary findByUsername(String user_name){
        for(Diary diary : diaries){
            if (diary.getUserName().equals(user_name)) return diary;
        }
        throw new EntryHasNotBeenCreatedException("User name does not exist");
    }

    public void delete(String user_name, String password){
        for (Diary diary : diaries) {
            if (diary.getUserName().equals(user_name) && diary.getPassword().equals(password)) diaries.remove(diary);
        }
    }
}
