import Account.exceptions.IncorrectPinExceptions;
import diaries.Diary;
import diaries.Entry;
import diaries.exceptions.DiaryLockedExceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    @Test
    public void testThatDiaryCreatedIsLocked(){
        Diary myDiary = new Diary("user_name", "user_password");
        assertTrue(myDiary.isLocked());
    }
    @Test
    public void testThatDiaryCanBeUnlockAndThenLock(){
        Diary myDiary = new Diary("user_name", "user_password");
        myDiary.unLock("user_password");
        assertFalse(myDiary.isLocked());
    }

    @Test
    public void testThatDiaryCanBeUnlockedWhenThePasswordIsCorrectAndCanBeLocked(){
        Diary myDiary = new Diary("user_name", "user_password");
        myDiary.unLock("user_password");
        myDiary.lock();
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void testThatDiaryCanThrowAnExceptionWhenThePasswordIsIncorrect(){
        Diary myDiary = new Diary("user_name", "user_password");
        assertThrows(IncorrectPinExceptions.class, ()-> myDiary.unLock("wrong_password"));
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void testThatDiaryWhenLockedCanBeUnlockedAndAlsoBeLockedBack(){
        Diary diary = new Diary("user_name", "user_password");
        diary.unLock("user_password");
        diary.lock();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatDiaryCanCreateAnEntryWithTheTitleAndBody(){
        Diary diary = new Diary("user_name", "user_password");
        diary.unLock("user_password");
        diary.createEntry("Beautiful Girl", "I saw a beautiful girl on my way to school and we gave our self eyes");
        diary.lock();
        assertEquals(1, diary.numberOfEntry());
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatDiaryCanFindAnEntryWIthTheIdNumber(){
        Diary diary = new Diary("user_name", "user_password");
        diary.unLock("user_password");
        diary.createEntry("Beautiful Girl", "I saw a fine girl on way to school");
        Entry entry = diary.findEntryById(1);
        assertEquals("Beautiful Girl", entry.getTitle());
        assertEquals(1, diary.numberOfEntry());
    }

    @Test
    public void testThatWhenTheDiaryIsNotUnlockedWeCanCreateAnEntry(){
        Diary diary = new Diary("user_name", "user_password");
        assertThrows(DiaryLockedExceptions.class, ()-> diary.createEntry("Amaka go to school", "my name is amaka"));
        assertEquals(0, diary.numberOfEntry());
    }

    @Test
    public void testThatWhenTheDiaryHasAnEntryWeCanDeleteAnEntryInTheDiary(){
        Diary diary = new Diary("user_name", "user_password");
        diary.unLock("user_password");
        diary.createEntry("Amaka go to school", "My name is amaka i go to school");
        diary.createEntry("Beautiful Girl", "I saw a fine girl and fell down inside water");
        assertEquals(2, diary.numberOfEntry());
        diary.deleteEntry(1);
        assertEquals(1, diary.numberOfEntry());
    }

    @Test
    public void testThatWhenTheDiaryIsDeletedAndWantToGetTheEntryInTheDiary(){
        Diary diary = new Diary("user_name", "user_password");
        diary.unLock("user_password");
        diary.createEntry("Amaka go to school", "My name is amaka i go to school");
        diary.createEntry("Beautiful Girl", "I saw a fine girl and fell down inside water");
        assertEquals(2, diary.numberOfEntry());
        diary.deleteEntry(1);
        Entry entry = diary.findEntryById(2);
        assertEquals("Beautiful Girl", entry.getTitle());
    }

    @Test
    public void testThatWhenWeCreateAnEntryAndUpdateEntryTheEntryIsUpdated(){
        Diary diary = new Diary("user_name", "user_password");
        diary.unLock("user_password");
        diary.createEntry("Amaka go to school", "My name is amaka i go to school");
        diary.updateEntry(1, "Beautiful Girl", "I saw a fine girl and fell down inside gutter");
        Entry entry = diary.findEntryById(1);
        assertEquals(1, diary.numberOfEntry());
        assertEquals("Beautiful Girl",entry.getTitle());
        assertEquals("""
        My name is amaka i go to school
        I saw a fine girl and fell down inside gutter""", entry.getBody());
    }
}
