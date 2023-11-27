package diaries;

import Account.exceptions.IncorrectPinExceptions;
import diaries.exceptions.DiaryLockedExceptions;
import diaries.exceptions.EntryHasNotBeenCreatedException;

import java.util.ArrayList;

public class Diary {
    private boolean isLocked = true;
    private String userPassword;
    private int numberOfEntry;
    private ArrayList<Entry>entries = new ArrayList<>();
    private String userName;
    public Diary(String userName, String userPassword) {
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unLock(String userPassword) {
        validate(userPassword);
        this.isLocked = false;
    }

    private void validate(String userPassword) {
        if (!this.userPassword.equals(userPassword)) throw new IncorrectPinExceptions("Wrong password");
    }

    public void lock() {
        this.isLocked = true;
    }

    public void createEntry(String title, String body) {
        if (!isLocked) {
            numberOfEntry++;
            int id = generateId();
            Entry entry = new Entry(id, title, body);
            entries.add(entry);
        }else throw new DiaryLockedExceptions("Diary is locked");
    }

    private int generateId() {
        return numberOfEntry;
    }

    public int numberOfEntry() {
        return numberOfEntry;
    }

    public Entry findEntryById(int id) {
        for (Entry entry: entries) {
            if (entry.getId() == id) return entry;
        }
        throw new EntryHasNotBeenCreatedException("Entry not created");
    }

    public void deleteEntry(int id) {
        Entry entry = findEntryById(id);
        entries.remove(entry);
        numberOfEntry--;
    }

    public void updateEntry(int id, String title, String body) {
        Entry entry = findEntryById(id);
        entry.setBody(body);
        entry.setTitle(title);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return this.userPassword;
    }
}
