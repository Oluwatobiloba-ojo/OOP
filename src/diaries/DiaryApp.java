package diaries;

import static Account.BankApp.input;

public class DiaryApp {

    static Diary diary;
    public static void main(String[] args) {
        setUpDiaryApp();
        diaryMenu();
    }

    private static void diaryMenu() {
        String menu = """
                =========================
                1 -> Create Entry
                2 -> Unlock Diary
                3 -> Lock Diary
                4 -> Find Entry By Id
                5 -> Update Entry
                6 -> Delete Entry
                =========================
                """;
        String response = input(menu);
        operationOnDiary(response);
    }

    private static void operationOnDiary(String response) {
        switch (response){
            case "1"  -> addEntry();
            case "2" -> unlock();
            case "3" -> lock();
            case "4" -> findEntryById();
            case "5" -> updateEntry();
            case "6" -> deleteEntry();
            default -> exit();
        }
    }

    private static void exit() {
        System.out.println("""
                ===============================
                Congratulation for picking this
                Diary App, You Have Successfully
                Log out
                Wished to see you next time.
                ================================
                """);
        System.exit(9);
    }

    private static void deleteEntry() {
        int id = Integer.parseInt(input("Enter your id for the diary app"));
        try {
            diary.deleteEntry(id);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            addEntry();
            diaryMenu();
        }
    }

    private static void updateEntry() {
       int id =  Integer.parseInt(input("Enter your id for the diary app"));
       String title = input("Enter the title for the entry you want to update");
       String body = input("Enter the body of the entry you want to update");
       try {
           diary.updateEntry(id, title, body);
           Entry entry = diary.findEntryById(id);
           System.out.println(entry);
           diaryMenu();
       }catch (Exception exception){
           System.out.println(exception.getMessage());
           addEntry();
           diaryMenu();
       }
    }

    private static void findEntryById() {
        int id = 0;
       try {
           id =  Integer.parseInt(input("Enter the id you want to find out "));
       }catch (NumberFormatException exception){
           System.out.println("Wrong input we are expecting number");
       }
       try {
           Entry entry = diary.findEntryById(id);
           System.out.println(entry);
           diaryMenu();
       }catch (Exception exception){
           System.out.println(exception.getMessage());
           addEntry();
           diaryMenu();
       }
    }

    private static void addEntry() {
       String title =  input("Enter the title of the entry to be add to the diary");
       String body = input("Enter the body of your diary");
       try {
           diary.createEntry(title, body);
           System.out.println("Entry has been created");
           diaryMenu();
       }catch (Exception exception){
           System.out.println(exception.getMessage());
           unlock();
           diaryMenu();
       }

    }

    private static void lock() {
        diary.lock();
        diaryMenu();
    }

    private static void unlock() {
      String password = input("Enter your password created");
      try {
          diary.unLock(password);
          diaryMenu();
      }catch (Exception exception){
          System.out.println(exception.getMessage());
          diaryMenu();
      }
    }

    private static void setUpDiaryApp() {
        System.out.println("===============================");
        System.out.println("WELCOME TO PAST TENSE DIARY");
        System.out.println("===============================");
        String name = input("Enter your user_name");
        String password = input("Enter your desire password for your diary");
        diary = new Diary(name, password);
    }
}
