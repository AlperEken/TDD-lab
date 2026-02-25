public class Time {

    private int theHour = 0;
    private int theMinute = 0;
    private int theSecond = 0;



    protected String timeSet(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24) {
            theHour = hour;
        } else if (hour == 24) {
            theHour = 0;
        } else {
            theHour = -1;
        }

        if (minute >= 0 && minute < 60) {
            theMinute = minute;
        } else if (minute == 60) {
            theMinute = 0;
        } else {
            theMinute = -1;
        }

        if (second >= 0 && second < 60) {
            theSecond = second;
        } else if (second == 60) {
            theSecond = 0;
        } else {
            theSecond = -1;
        }

        return showTime();
    }

    protected String showTime() {
        return theHour + ":" + theMinute + ":" + theSecond;
    }
}