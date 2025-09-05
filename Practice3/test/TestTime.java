public class TestTime {
    public static void main(String[] args) {
        Time t = new Time();

        System.out.println("Current Time: " + t.getCurrentTime());
        System.out.println("Current Date: " + t.getCurrentDate());
        System.out.println("Convert 1:1:1 to Seconds = " + t.toSeconds(1,1,1));
        System.out.println("Diff 12:00:00 and 13:30:30 = " +
            t.diffInSeconds(12,0,0,13,30,30) + " seconds");
    }
}
