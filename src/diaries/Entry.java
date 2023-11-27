package diaries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {

    private int id;
    private String title;
    private String body;
    private LocalDateTime dateTime = LocalDateTime.now();

    public Entry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body += "\n"+ body;
    }
    public String getTitle() {
        return this.title;
    }

    public String toString(){
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
        return String.format("""
                ===============================================
                %s
                            %s
                %s
                ================================================
                """, dateTime.format(formatter),title,body);
    }
}
