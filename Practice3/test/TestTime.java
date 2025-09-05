public class TestTime {
    public static void test() {
        Time t1 = new Time();
        Time t2 = new Time(20, 2, 45);

        t1.setHour(7).setMinute(32).setSecond(23);
        System.out.println("T1 is :" + t1);
        System.out.println("T2 is :" + t2);
    }
}