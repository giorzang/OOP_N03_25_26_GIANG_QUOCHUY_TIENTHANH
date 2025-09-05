package Model;

public class Time {
    int Hour;
    int Minute;
    int Second;

    Time(){
        setTime(0, 0 , 0);
    }

    Time(int h) {setTime(h, 0, 0); }

    Time(int h, int m) {setTime(h, m, 0); }

    Time(int h, int m, int s) {setTime(h, m, s); }

    Time setTime (int h, int m, int s){

        if(h >= 0 && h < 24) {
            Hour = h;
        }
        else{
            Hour = 0;
        }

        if (m >= 0 && m < 60) {
            Minute = m;
        }else {
            Minute = 0;
        }

        if (s >= 0 && s < 60) {
            Second = s;
        }else {
            Second = 0;
        }
        return this;
    }

    public int getHour() {return Hour; }
    public int getMinute() {return Minute; }
    public int getSecond() {return Second; }

    public String getToString() {
        return ((Hour == 12 || Hour == 0) ? 12 : Hour % 12) +
           ":" + (Minute < 10 ? "0" : "") + Minute +
           ":" + (Second < 10 ? "0" : "") + Second +
           (Hour < 12 ? " AM" : " PM") + " ";
    }

}
