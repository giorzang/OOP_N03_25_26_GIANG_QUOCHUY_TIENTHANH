import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getCurrentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public int toSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    public int diffInSeconds(int h1, int m1, int s1, int h2, int m2, int s2) {
        return Math.abs(toSeconds(h1, m1, s1) - toSeconds(h2, m2, s2));
    }
}
